package com.dkit.oop.dao;
import com.dkit.oop.Comparator.AlbumPriceComparator;
import com.dkit.oop.dto.Albums;
import com.dkit.oop.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MySqlAlbumDao extends MySqlDao implements AlbumsDaoInterface {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet resultSet = null;

    @Override
    public List<Albums> findAllAlbums() throws DaoException {

        List<Albums> albumsList = new ArrayList<>();
        String getAlbumsSQL = "SELECT * FROM ALBUMS";
        try (Connection con = this.getConnection();
             PreparedStatement ps = con.prepareStatement(getAlbumsSQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int albumID = rs.getInt("ALBUM_ID");
                String albumTitle = rs.getString("ALBUM_TITLE");
                String artistName = rs.getString("ARTIST_NAME");
                int year = rs.getInt("RELEASE_YEAR");
                float price = rs.getFloat("PRICE");
                Albums m = new Albums(albumID, albumTitle, artistName, year, price);
                albumsList.add(m);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllAlbumsResultSet() " + e.getMessage());
        }
        return albumsList;     // may be empty
    }


    @Override
    public Albums findAlbumByTitle(String albumTitle) throws DaoException {
        Albums album = null;
        String getAlbumSQL = "SELECT * FROM ALBUMS WHERE ALBUM_TITLE = ?";
        String checkTitleSQL = "SELECT COUNT(*) FROM ALBUMS WHERE ALBUM_TITLE = ?";

        try (Connection con = this.getConnection();
             PreparedStatement psCheck = con.prepareStatement(checkTitleSQL)) {
            psCheck.setString(1, albumTitle);
            ResultSet rsCheck = psCheck.executeQuery();
            rsCheck.next();
            int count = rsCheck.getInt(1);

            if (count > 0) {
                try (PreparedStatement psGetAlbum = con.prepareStatement(getAlbumSQL)) {
                    psGetAlbum.setString(1, albumTitle);
                    ResultSet rs = psGetAlbum.executeQuery();
                    if (rs.next()) {
                        int albumID = rs.getInt("ALBUM_ID");
                        String artistName = rs.getString("ARTIST_NAME");
                        int year = rs.getInt("RELEASE_YEAR");
                        float price = rs.getFloat("PRICE");
                        album = new Albums(albumID, albumTitle, artistName, year, price);
                    }
                }
            }
        } catch (SQLException e) {
            throw new DaoException("findAlbumByTitle() " + e.getMessage());
        }

        return album;
    }
    public boolean deleteAlbumByAlbumID(int albumID) throws DaoException
    {
        Connection con = null;

        PreparedStatement ps = null;
        ResultSet rs = null;

        try
        {
            con = this.getConnection();

            String Query = "SELECT * FROM albums WHERE album_id = ?";
            ps = con.prepareStatement(Query);
            ps.setInt(1, albumID);

            rs = ps.executeQuery();


            if(!rs.next())
            {
                return false;
            }

            String deleteAlbumQuery = "DELETE FROM albums WHERE album_id = ?";
            ps = con.prepareStatement(deleteAlbumQuery);
            ps.setInt(1, albumID);
            ps.executeUpdate();
        }
        catch(SQLException sqle)
        {
            throw new DaoException("deleteAlbumByAlbumID() " + sqle.getMessage());
        }
        finally
        {
            try
            {
                if(rs != null)
                {
                    rs.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(con != null)
                {
                    this.freeConnection(con);
                }
            }
            catch(SQLException sqle)
            {
                throw new DaoException("findAllAlbums() " + sqle.getMessage());
            }
        }

        return true;
    }

    @Override
    public void insertnewAlbum(Albums album) throws DaoException {
        try
        {
            connection = this.getConnection();

            String query = "insert into albums (album_title, artist_name, release_year, price) values (?, ?, ?, ?)";
            ps = connection.prepareStatement(query);
            ps.setString(1, album.getAlbum_title());
            ps.setString(2, album.getArtist_name());
            ps.setInt(3, album.getYear());
            ps.setFloat(4, album.getPrice());


            //Using a PreparedStatement to execute SQL...
            ps.executeUpdate();
        } catch (SQLException e)
        {
            throw new DaoException("insertNewAlbumResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("insertNewAlbum() " + e.getMessage());
            }
        }
    }
    @Override
    public List<Albums> listAlbumsByPrice() throws DaoException {
        MySqlAlbumDao ad = new MySqlAlbumDao();
        List<Albums> albums = ad.findAllAlbums();
        albums.sort(new AlbumPriceComparator());
        return albums;
    }
    @Override
    // Create a Cache using a HashSet to store the album ids
    public List<Albums> findAllAlbumsCache() throws DaoException {
        List<Albums> albumsList = new ArrayList<>();
        String getAlbumsSQL = "SELECT * FROM ALBUMS";
        try (Connection con = this.getConnection();
             PreparedStatement ps = con.prepareStatement(getAlbumsSQL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int albumID = rs.getInt("ALBUM_ID");
                String albumTitle = rs.getString("ALBUM_TITLE");
                String artistName = rs.getString("ARTIST_NAME");
                int year = rs.getInt("RELEASE_YEAR");
                float price = rs.getFloat("PRICE");
                Albums m = new Albums(albumID, albumTitle, artistName, year, price);
                albumsList.add(m);
            }
        } catch (SQLException e) {
            throw new DaoException("findAllAlbumsResultSet() " + e.getMessage());
        }
        return albumsList;     // may be empty

    }
    @Override
    //checkAlbumExists() method to check if the album exists in the cache
    public boolean checkAlbumExists(int albumID) throws DaoException {
        List<Albums> albums = findAllAlbumsCache();
        for (Albums a : albums) {
            if (a.getAlbum_id() == albumID) {
                return true;
            }
        }
        return false;
    }
}







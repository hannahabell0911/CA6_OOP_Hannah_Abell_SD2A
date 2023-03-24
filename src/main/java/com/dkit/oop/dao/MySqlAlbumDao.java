package com.dkit.oop.dao;
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

    Scanner kb = new Scanner(System.in);
    @Override
    public List<Albums> findAllAlbums() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Albums> albumsList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM ALBUMS";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int albumID = resultSet.getInt("ALBUM_ID");
                String albumTitle = resultSet.getString("ALBUM_TITLE");
                String artistName = resultSet.getString("ARTIST_NAME");
                int year = resultSet.getInt("RELEASE_YEAR");
                float price = resultSet.getFloat("PRICE");
                Albums m = new Albums(albumID,albumTitle, artistName, year, price);
                albumsList.add(m);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAllAlbumsResultSet() " + e.getMessage());
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
                throw new DaoException("findAllAlbums() " + e.getMessage());
            }
        }
        return albumsList;     // may be empty
    }

    @Override
    public Albums findAlbumByAlbumID() throws DaoException
    {
        System.out.println("Enter the album ID: ");
        int albumId = kb.nextInt();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Albums m = null;

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM ALBUMS WHERE ALBUM_ID = " + albumId;
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                String albumTitle = resultSet.getString("ALBUM_TITLE");
                String artistName = resultSet.getString("ARTIST_NAME");
                int year = resultSet.getInt("RELEASE_YEAR");
                float price = resultSet.getFloat("PRICE");
                m = new Albums(albumId, albumTitle, artistName, year, price);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAlbumByAlbumIDResultSet() " + e.getMessage());
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
                throw new DaoException("findAlbumByAlbumID() " + e.getMessage());
            }
        }
        return m;     // may be null
    }
//create function findAlbumByTitle
    @Override
    public Albums findAlbumByTitle() throws DaoException
    {
        System.out.println("Enter the album title: ");
        String albumTitle = kb.next();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        Albums m = null;

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM ALBUMS WHERE ALBUM_TITLE like '%" + albumTitle + "%'";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                int albumId = resultSet.getInt("ALBUM_ID");
                String albumTitle1 = resultSet.getString("ALBUM_TITLE");
                String artistName = resultSet.getString("ARTIST_NAME");
                int year = resultSet.getInt("RELEASE_YEAR");
                float price = resultSet.getFloat("PRICE");
                m = new Albums(albumId, albumTitle1, artistName, year, price);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findAlbumByTitleResultSet() " + e.getMessage());
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
                throw new DaoException("findAlbumByTitle() " + e.getMessage());
            }
        }
        return m;     // may be null
    }
    //create function deleteAlbumByAlbumID
    @Override
    public boolean deleteAlbumByAlbumID() throws DaoException
    {
        System.out.println("Enter the album ID: ");
        int albumId = kb.nextInt();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        boolean result = false;

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "DELETE FROM ALBUMS WHERE ALBUM_ID = " + albumId;
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1)
            {
                result = true;
            }
        } catch (SQLException e)
        {
            throw new DaoException("deleteAlbumByAlbumIDResultSet() " + e.getMessage());
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
                throw new DaoException("deleteAlbumByAlbumID() " + e.getMessage());
            }
        }
        return result;     // may be null
    }
}
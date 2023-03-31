package com.dkit.oop.dao;

import com.dkit.oop.dto.Albums;
import com.dkit.oop.Exceptions.DaoException;
import java.util.List;

public interface AlbumsDaoInterface {
    public List<Albums> findAllAlbums() throws DaoException;

    Albums findAlbumByTitle(String albumTitle) throws DaoException;
    public boolean deleteAlbumByAlbumID(int albumID) throws DaoException;
    public void insertnewAlbum(Albums album) throws DaoException;
    public List<Albums> listAlbumsByPrice() throws DaoException;
    public List<Albums> findAllAlbumsCache() throws DaoException;
    public boolean checkAlbumExists(int albumID) throws DaoException;
}

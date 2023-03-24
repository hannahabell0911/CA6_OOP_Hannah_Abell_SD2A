package com.dkit.oop.dao;

import com.dkit.oop.dto.Albums;
import com.dkit.oop.Exceptions.DaoException;
import java.util.List;

public interface AlbumsDaoInterface {
    public List<Albums> findAllAlbums() throws DaoException;
    Albums findAlbumByAlbumID() throws DaoException;
}

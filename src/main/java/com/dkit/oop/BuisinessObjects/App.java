package com.dkit.oop.BuisinessObjects;
import com.dkit.oop.dto.Albums;
import com.dkit.oop.dao.AlbumsDaoInterface;
import com.dkit.oop.dao.MySqlAlbumDao;
import com.dkit.oop.dao.MySqlDao;
import com.dkit.oop.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AlbumsDaoInterface IAlbumDao = new MySqlAlbumDao();
        try
        {
            System.out.println("\nCall findAllAlbums()");
            Albums a = IAlbumDao.findAlbumByAlbumID();
            System.out.println(a);



    } catch (DaoException e) {
            throw new RuntimeException(e);
        }


    }
}
package com.dkit.oop.BuisinessObjects;
import com.dkit.oop.dto.Albums;
import com.dkit.oop.dao.AlbumsDaoInterface;
import com.dkit.oop.dao.MySqlAlbumDao;
import com.dkit.oop.dao.MySqlDao;
import com.dkit.oop.Exceptions.DaoException;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws DaoException {
        AlbumsDaoInterface IAlbumDao = new MySqlAlbumDao();
        System.out.println( "Welcome to Hannah's Music App" );
        System.out.println( "Please enter your choice" );
        System.out.println( "1. Find all albums" );
        System.out.println( "2. Find album by album ID" );
        System.out.println( "3. Find album by title" );
        System.out.println( "4. Delete album by album ID" );
        System.out.println( "5. Exit" );
        int choice = keyboard.nextInt();
        switch (choice) {
            case 1:
                List<Albums> albums = IAlbumDao.findAllAlbums();
                System.out.println(albums);
                break;
            case 2:
                Albums a = IAlbumDao.findAlbumByAlbumID();
                System.out.println(a);
                break;
            case 3:
                Albums a2 = IAlbumDao.findAlbumByTitle();
                System.out.println(a2);
                break;
            case 4:
                IAlbumDao.deleteAlbumByAlbumID();
                break;
            case 5:
                System.out.println("Goodbye");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }


    }
}
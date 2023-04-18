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
    private static Albums insertNewAlbums() {
        Scanner kb = new Scanner(System.in);

        String albumTitle = "";

        System.out.println("Enter Title Name:");
        albumTitle = kb.nextLine();

        String artistName = "";

        System.out.println("Enter Artist Name:");
        artistName = kb.nextLine();


        int releaseYear = 0;

        System.out.println("Enter Release Year:");
        releaseYear = kb.nextInt();

        float albumPrice = 0;

        System.out.println("Enter Album Price:");
        albumPrice = kb.nextFloat();


        return new Albums(albumTitle, artistName, releaseYear, albumPrice);
    }
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws DaoException {
        AlbumsDaoInterface IAlbumDao = new MySqlAlbumDao();
        System.out.println( "Welcome to Hannah's Music App" );
        System.out.println( "Please enter your choice" );
        System.out.println( "1. Find all albums" );
        System.out.println( "2. Find album by title" );
        System.out.println( "3. Delete album by album ID" );
        System.out.println( "4. Add album" );
        System.out.println( "5. Compare by Price" );
        System.out.println( "6. Find all Albums cache" );
        int choice = keyboard.nextInt();
        switch (choice) {
            case 1:
                List<Albums> albums = IAlbumDao.findAllAlbums();
                System.out.println(albums);
                break;
            case 2:
                System.out.println("Enter album title");
                String albumTitle = keyboard.next();
                Albums album = IAlbumDao.findAlbumByTitle(albumTitle);
                System.out.println(album);
                break;
            case 3:
                System.out.println("Enter album ID");
                int albumID = keyboard.nextInt();
                IAlbumDao.deleteAlbumByAlbumID(albumID);
                System.out.println(albumID);
                break;
            case 4:
           IAlbumDao.insertnewAlbum(insertNewAlbums());
                break;
            case 5:
                List<Albums> albums1 = IAlbumDao.listAlbumsByPrice();
                System.out.println(albums1 + "\n" );
                break;
            case 6:
                List<Albums> albums2 = IAlbumDao.findAllAlbumsCache();
                System.out.println(albums2);
                break;
            case 7:
                String albums3 = IAlbumDao.findAllAlbumsJson();
                System.out.println(albums3);
                break;
            case 8:
                System.out.println("Goodbye");
                System.exit(0);
                break;
                 default:
                System.out.println("Invalid choice");
                break;
        }


    }
}
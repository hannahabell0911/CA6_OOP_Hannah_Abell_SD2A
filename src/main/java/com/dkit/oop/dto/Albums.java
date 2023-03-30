package com.dkit.oop.dto;

public class Albums {
    private int album_id;
    private String album_title;
    private String artist_name;
    private int year;
    private float price;


    public Albums(int album_id, String album_title, String artist_name, int year, float price) {
        this.album_id = album_id;
        this.album_title = album_title;
        this.artist_name = artist_name;
        this.year = year;
        this.price = price;
    }
public Albums( String album_title, String artist_name, int year, float price) {
        this.album_id = 0;
        this.album_title = album_title;
        this.artist_name = artist_name;
        this.year = year;
        this.price = price;
    }
    public int getAlbum_id() {
        return album_id;
    }

    public void setAlbum_id(int album_id) {
        this.album_id = album_id;
    }

    public String getAlbum_title() {
        return album_title;
    }

    public void setAlbum_title(String album_title) {
        this.album_title = album_title;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "album_id=" + album_id +
                ", album_title='" + album_title + '\'' +
                ", artist_name='" + artist_name + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}

package com.dvoss;

/**
 * Created by Dan on 5/25/16.
 */
public class Album {

    String title;
    String artist;
    String genre;
    int songNumber;
    int year;

    public Album() {
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public int getSongNumber() {
        return songNumber;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Album{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", genre='" + genre + '\'' +
                ", songNumber=" + songNumber +
                ", year=" + year +
                '}';
    }
}

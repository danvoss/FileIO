package com.dvoss;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by Dan on 5/25/16.
 */
public class MainTest {
    static final String TEST_FILE = "test.json";

    @Test
    public void saveInfo() throws Exception {
        Album album = new Album();
        album.title = "Test title";
        album.artist = "Test artist";
        album.genre = "Test genre";
        album.songNumber = 5;
        album.year = 1900;

        Main.saveInfo(album, "test.json");
        File f = new File(TEST_FILE);
        f.delete();

    }

    @Test
    public void loadInfo() throws Exception {
        Album album = new Album();
        album.title = "Test title";
        album.artist = "Test artist";
        album.genre = "Test genre";
        album.songNumber = 5;
        album.year = 1900;

        Album testAlbum = Main.loadInfo("test.json");
        File f = new File(TEST_FILE);
        f.delete();

    }

}
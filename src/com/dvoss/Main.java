package com.dvoss;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static final String SAVE_INFO = "album.json";
    static Album album;

    public static void main(String[] args) {

        loadInfo(SAVE_INFO);

        System.out.println("Enter album title.");
        String titleEntry = scanner.nextLine();
        System.out.println("Enter artist name.");
        String artistEntry = scanner.nextLine();
        System.out.println("Enter genre.");
        String genreEntry = scanner.nextLine();
        System.out.println("Enter the number of songs.");
        int songNumEntry = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter album year.");
        int yearEntry = Integer.valueOf(scanner.nextLine());

        //Album album = new Album();
        album.title = titleEntry;
        album.artist = artistEntry;
        album.genre = genreEntry;
        album.songNumber = songNumEntry;
        album.year = yearEntry;

        saveInfo(album, SAVE_INFO);

    }

    public static void saveInfo(Album album, String filename) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(album);

        File a = new File(filename);
        try {
            FileWriter fw = new FileWriter(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Album loadInfo(String filename) {
        File a = new File(filename);
        try {
            Scanner scanner = new Scanner(a);
            scanner.useDelimiter("\\Z");
            String contents = scanner.next();
            JsonParser parser = new JsonParser();
            return parser.parse(contents, Album.class);
        } catch (FileNotFoundException e) {
        }
        return null;
    }
}

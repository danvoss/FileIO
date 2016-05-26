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

        album = loadInfo(SAVE_INFO);
        if (album == null) {
            album = new Album();
            System.out.println("Creating new album info.");
        }
        else {
            System.out.println("Found saved info.");
            System.out.println(album);
            System.out.println("Do you want to update? [Y/N]");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("Y")) {
                album = new Album();
            }
            else {
                System.out.println("Thank you.");
            }
        }

        System.out.println("Enter album title.");
        album.title = scanner.nextLine();
        System.out.println("Enter artist name.");
        album.artist = scanner.nextLine();
        System.out.println("Enter genre.");
        album.genre = scanner.nextLine();
        System.out.println("Enter the number of songs.");
        album.songNumber = Integer.valueOf(scanner.nextLine());
        System.out.println("Enter album year.");
        album.year = Integer.valueOf(scanner.nextLine());

        saveInfo(album, SAVE_INFO);

    }

    public static void saveInfo(Album album, String filename) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(album);

        File a = new File(filename);
        try {
            FileWriter fw = new FileWriter(a);
            fw.write(json);
            fw.close();
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

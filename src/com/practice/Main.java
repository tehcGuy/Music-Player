package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    // Create a program that implements a playlist for songs

    // Create a Song class having Title and Duration for a song. (in the inner Song class)
    // The program will have an Album class containing a list of songs. (LinkedList playlist, album class)  +
    // The albums will be stored in an ArrayList (Main class)

    // Songs from different albums can be added to the playlist and will appear in the list in the order ...
    // they are added.

    // Once the songs have been added to the playlist, create a menu of options to:-
    // Quit,Skip forward to the next song, skip backwards to a previous song.  Replay the current song.
    // List the songs in the playlist

    // A song must exist in an album before it can be added to the playlist (so you can only play songs that
    // you own).
    // Hint:  To replay a song, consider what happened when we went back and forth from a city before we
    // started tracking the direction we were going.
    // As an optional extra, provide an option to remove the current song from the playlist
    // (hint: listiterator.remove()

//    implement the playList with LinkedList

    private ArrayList<Album> album = new ArrayList<>();

    public ArrayList<Album> getAlbum() {
        return album;
    }

    public static void main(String[] args) {
        Main obj = new Main();
        Album nvm = new Album("Nevermind");
        Album blch = new Album("Bleach");

        obj.album.add(nvm);
        obj.album.add(blch);

        ArrayList<Song> test = new ArrayList<Song>();
        test.add(new Song("1", "1"));
        nvm.setAlbumSong(test);

/*
        obj.album.get(0).setAlbumSong(new ArrayList<Song>("1", "1"));
        obj.album.get(0).setAlbumSong(new ArrayList<Song>("2", "2"));
*/

        System.out.println(nvm.getAlbumSong().get(0).getTitle());

//        System.out.println(obj.album.get(0).getAlbumSong().getTitle());
    }
}

package com.practice;

/*Class with operations */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Album {
    //it is not a field nor method. I cannot interact with that during the initialization with a constructor
    private LinkedList<Song> playlist = new LinkedList();
    private String albumName;
    private Song albumSong;

    public Album(String albumName) { //important remove the 1st parameter: LinkedList<Song> playlist !!!
        this.albumName = albumName;
    }

    public Album() {
    }

    private boolean setAlbumSong(Song albumSong) {
        this.albumSong = albumSong;
        return true;
    }

    public Song getAlbumSong() {
        return albumSong;
    }

    public boolean addSongToAlbum(Album chosenAlbum, Song newSong) {
        if(chosenAlbum.albumName.contains(newSong.getTitle())) {
            return chosenAlbum.setAlbumSong(newSong);
        }
        return false;
    }

    public boolean addToPlaylist(Song newSong) {
        ArrayList<Album> checkAlbum = new ArrayList<>(); //logical mistake? am i creating a new instance that won't have any entries?
        if(checkAlbum.contains(newSong) && !playlist.contains(newSong)) {
            return playlist.add(newSong);
        }
        return false;
    }

    public void listFromPlaylist(LinkedList<Song> playlist) {
        for(Song i : playlist)
            System.out.println(i);
    }

    private boolean removeFromPlaylist(LinkedList<Song> playlist, String songToRemove) {
        ListIterator iteratePlaylist = playlist.listIterator();
        while(iteratePlaylist.hasNext()) {
            if(iteratePlaylist.next().equals(songToRemove))
                return true;
        }
        return false;
    }

    private static void menu() {
        System.out.println("0 -> exit");
        System.out.println("1 -> skip forward");
        System.out.println("2 -> skip backwards");
        System.out.println("3 -> replay current song");
        System.out.println("4 -> list the songs in the playlist");
    }

    public static void menuOfOption(LinkedList<Song> navigatingPlayList) {
        Album tempAccess = new Album();
        ListIterator iteratePlaylist = navigatingPlayList.listIterator();
        Scanner userChoice = new Scanner(System.in);
        boolean goingForward = false;

        while(true) {
            Album.menu();
            int choice = userChoice.nextInt();

            switch(choice) {
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);

                case 1:
                    if(!goingForward) {
                        iteratePlaylist.next();
                        System.out.println(iteratePlaylist.next());
                    }
                    goingForward = true;
                    break;

                case 2:
                    if(goingForward) {
                        iteratePlaylist.previous();
                        System.out.println(iteratePlaylist.previous());
                    }
                    goingForward = false;
                    break;

                case 3:
                    if(goingForward){
                        iteratePlaylist.previous();
                    }
                    else iteratePlaylist.next();
                    break;

                case 4:
                    tempAccess.listFromPlaylist(navigatingPlayList);
                    break;
            }
        }
    }

}

package com.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Album {
    private LinkedList<Song> playlist = new LinkedList();

    public boolean addToPlaylist(Song newSong) {
        ArrayList<Album> checkAlbum = new ArrayList<>();
        if(checkAlbum.contains(newSong)) {
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

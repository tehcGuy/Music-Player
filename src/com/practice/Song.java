package com.practice;
/*the most basic class*/
public class Song {
    private String Title;
    private String duration;

    public String getTitle() {
        return Title;
    }

    public String getDuration() {
        return duration;
    }

    public Song(String title, String duration) {
        Title = title;
        this.duration = duration;
    }
}

package ru.tuturu.songsdisplayer.entitiy;

public class Song {
    private final String title;
    private final String lyrics;

    public Song(String title, String lyrics) {
        this.title = title;
        this.lyrics = lyrics;
    }

    public String getTitle() {
        return title;
    }

    public String getLyrics() {
        return lyrics;
    }
}

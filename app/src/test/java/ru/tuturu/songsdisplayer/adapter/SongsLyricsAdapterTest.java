package ru.tuturu.songsdisplayer.adapter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ru.tuturu.songsdisplayer.entitiy.Song;

public class SongsLyricsAdapterTest {

    private SongsLyricsAdapter adapter;
    private final int SONGS_COUNT = 5;

    @Before
    public void initAdapter(){
        List<Song> songs = new ArrayList<>();
        for (int i = 0; i < SONGS_COUNT; ++i)
            songs.add(new Song("Twinkle, twinkle little start",
                    "Twinkle, twinkle, little star\n" +
                    "How I wonder what you are\n" +
                    "Up above the world so high\n" +
                    "Like a diamond in the sky\n" +
                    "Twinkle, twinkle, little star\n" +
                    "How I wonder what you are"));
        adapter = new SongsLyricsAdapter(songs);
    }


    @Test
    public void getItemCount() {
        assertEquals(SONGS_COUNT, adapter.getItemCount());
    }
}
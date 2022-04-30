package ru.tuturu.songsdisplayer.data;

import android.content.Context;

import com.google.gson.Gson;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import ru.tuturu.songsdisplayer.entitiy.Song;

public class Serializer {
    private static final String FILE_NAME = "songs.json";

    public static boolean serialize(Context context, List<Song> songs) throws IOException {
        Gson gson = new Gson();
        DataItems dataItems = new DataItems();
        dataItems.setSongs(songs);
        String jsonString = gson.toJson(dataItems);

        try(FileOutputStream fileOutputStream
                    = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE)){
            fileOutputStream.write(jsonString.getBytes(StandardCharsets.UTF_8));
            return true;
        }
    }

    public static List<Song> deserialize(Context context) throws IOException {
        try(FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream)){
            Gson gson = new Gson();
            DataItems dataItems = gson.fromJson(inputStreamReader, DataItems.class);
            return dataItems.getSongs();
        }
    }

    private static class DataItems{
        private List<Song> songs;

        public List<Song> getSongs() {
            return songs;
        }

        public void setSongs(List<Song> songs) {
            this.songs = songs;
        }
    }
}

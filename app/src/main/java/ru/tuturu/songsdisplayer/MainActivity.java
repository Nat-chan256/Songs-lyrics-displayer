package ru.tuturu.songsdisplayer;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import ru.tuturu.songsdisplayer.adapter.SongsLyricsAdapter;
import ru.tuturu.songsdisplayer.async.LoadChartTracksTask;
import ru.tuturu.songsdisplayer.async.LoadTrackLyricsTask;
import ru.tuturu.songsdisplayer.data.Serializer;
import ru.tuturu.songsdisplayer.entitiy.Song;
import ru.tuturu.songsdisplayer.response.ChartTracks;
import ru.tuturu.songsdisplayer.util.ConnectionChecker;
import ru.tuturu.songsdisplayer.util.RequestParameters;

public class MainActivity extends AppCompatActivity {

    private List<Song> lyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ConnectionChecker.isConnectedToInternet(this)){
            lyrics = getLyricsViaInternet();
        }
        else{
            try {
                lyrics = Serializer.deserialize(this);
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }

        if (lyrics == null){
            Toast toast = Toast.makeText(this, "No internet connection", Toast.LENGTH_SHORT);
            toast.show();
            this.finishAffinity();
        }

        RecyclerView recyclerView = findViewById(R.id.rv_songs_lyrics);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SongsLyricsAdapter(lyrics));
    }

    @Override
    protected void onStop() {
        try {
            Serializer.serialize(this, lyrics);
        } catch(IOException ex){
            ex.printStackTrace();
        }
        super.onStop();
    }


    //======================Utility methods============================

    private List<Song> getLyricsViaInternet(){

        Map<String, String> requestParams = initializeRequestParams();
        ChartTracks chartTracks;

        try {
            // Load chart tracks
            LoadChartTracksTask loadChartTrackLyricsTask = new LoadChartTracksTask();
            loadChartTrackLyricsTask.execute(requestParams);
            chartTracks = loadChartTrackLyricsTask.get();

            return requestLyrics(chartTracks);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Initialization of GET-request to receive songs lyrics
    private Map<String, String> initializeRequestParams(){
        Map<String, String> params = new HashMap<>();
        params.put(RequestParameters.COUNTRY, "it");
        params.put(RequestParameters.CHART_NAME, "top");
        params.put(RequestParameters.PAGE, "1");
        params.put(RequestParameters.PAGE_SIZE, "5");
        params.put(RequestParameters.F_HAS_LYRICS, "1");

        return params;
    }

    private List<Song> requestLyrics(ChartTracks chartTracks)
            throws ExecutionException, InterruptedException {
            List<? extends ChartTracks.Message.Body.Track_list> tracks = chartTracks
                    .getMessage()
                    .getBody()
                    .getTrack_list();
            List<Song> songs = new ArrayList<>();
            for (ChartTracks.Message.Body.Track_list track : tracks){
                LoadTrackLyricsTask loadTrackLyricsTask = new LoadTrackLyricsTask();
                loadTrackLyricsTask.execute(track.getTrack().getTrack_id());
                songs.add(new Song(
                        track.getTrack().getTrack_name(),
                        loadTrackLyricsTask.get()
                ));
            }
            return songs;
    }
}
package ru.tuturu.songsdisplayer.async;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.tuturu.songsdisplayer.client.APIService;
import ru.tuturu.songsdisplayer.response.TrackLyrics;

public class LoadTrackLyricsTask extends AsyncTask<Integer, Void, String> {

    private final String API_KEY = "fdeab448ff0e42e1f766e8059012f06e";
    private final String BASE_URL = "https://api.musixmatch.com/ws/1.1/";

    @Override
    protected String doInBackground(Integer... trackId) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        Call<TrackLyrics> callTrackLyrics = service.getTrackLyrics(API_KEY, trackId[0]);
        try {
            Response<TrackLyrics> response = callTrackLyrics.execute();
            TrackLyrics trackLyrics = response.body();
            return trackLyrics.getMessage().getBody().getLyrics().getLyrics_body();
        } catch(IOException ex){
            return null;
        }
    }
}

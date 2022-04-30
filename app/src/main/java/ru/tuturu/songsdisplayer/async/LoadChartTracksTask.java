package ru.tuturu.songsdisplayer.async;

import android.os.AsyncTask;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.tuturu.songsdisplayer.client.APIService;
import ru.tuturu.songsdisplayer.response.ChartTracks;
import ru.tuturu.songsdisplayer.util.RequestParameters;

/**
 * Async task that loads chart tracks according to request parameters.
 */
public class LoadChartTracksTask extends AsyncTask<Map<String, String>, Void, ChartTracks> {

    private final String API_KEY = "fdeab448ff0e42e1f766e8059012f06e";
    private final String BASE_URL = "https://api.musixmatch.com/ws/1.1/";

    @Override
    protected ChartTracks doInBackground(Map<String, String>... songDetails) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService service = retrofit.create(APIService.class);
        Call<ChartTracks> callChartTracks = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            callChartTracks = service.getChartTracks(
                    API_KEY,
                    songDetails[0].getOrDefault(RequestParameters.COUNTRY, null),
                    songDetails[0].getOrDefault(RequestParameters.PAGE, null),
                    songDetails[0].getOrDefault(RequestParameters.PAGE_SIZE, null),
                    songDetails[0].getOrDefault(RequestParameters.CHART_NAME, null),
                    songDetails[0].getOrDefault(RequestParameters.F_HAS_LYRICS, null)
            );
        }
        try {
            Response<ChartTracks> response = callChartTracks.execute();
            return response.body();
        } catch(IOException ex){
            return null;
        }
    }
}

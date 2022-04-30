package ru.tuturu.songsdisplayer.client;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.tuturu.songsdisplayer.response.ChartTracks;
import ru.tuturu.songsdisplayer.response.TrackLyrics;
import ru.tuturu.songsdisplayer.util.RequestParameters;

public interface APIService {

    @GET("chart.tracks.get?format=json&callback=callback")
    Call<ChartTracks> getChartTracks(
            @Query("apikey") String apikey,
            @Query(RequestParameters.COUNTRY) String country,
            @Query(RequestParameters.PAGE) String page,
            @Query(RequestParameters.PAGE_SIZE) String pageSize,
            @Query(RequestParameters.CHART_NAME) String chartName,
            @Query(RequestParameters.F_HAS_LYRICS) String fHasLyrics
            );

    @GET("track.lyrics.get?format=json&callback=callback")
    Call<TrackLyrics> getTrackLyrics(@Query("apikey") String apikey,
            @Query(RequestParameters.TRACK_ID) Integer trackId);
}

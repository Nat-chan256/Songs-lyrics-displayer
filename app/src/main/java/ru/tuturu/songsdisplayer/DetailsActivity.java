package ru.tuturu.songsdisplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import ru.tuturu.songsdisplayer.util.StringUtil;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView tvSongTitle = findViewById(R.id.tv_song_title_details);
        TextView tvSongLyrics = findViewById(R.id.tv_song_lyrics_details);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            tvSongTitle.setText(extras.getString(getString(R.string.song_title)));
            tvSongLyrics.setText(
                    StringUtil.removeWarningLabel(
                            extras.getString(getString(R.string.song_lyrics))
                    )
            );
        }
    }
}
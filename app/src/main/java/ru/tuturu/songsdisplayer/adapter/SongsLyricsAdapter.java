package ru.tuturu.songsdisplayer.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.tuturu.songsdisplayer.R;
import ru.tuturu.songsdisplayer.entitiy.Song;

public class SongsLyricsAdapter extends
        RecyclerView.Adapter<SongsLyricsAdapter.SongsLyricsViewHolder> {

    private List<Song> songs;

    public SongsLyricsAdapter(List<Song> songs){
        this.songs = songs;
    }

    @NonNull
    @Override
    public SongsLyricsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new SongsLyricsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsLyricsViewHolder holder, int position) {
        holder.tvSongTitle.setText(songs.get(position).getTitle());
        holder.tvSongLyrics.setText(songs.get(position).getLyrics());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongsLyricsViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvSongTitle;
        private final TextView tvSongLyrics;

        public SongsLyricsViewHolder(View itemView) {
            super(itemView);
            tvSongTitle = itemView.findViewById(R.id.tv_song_title);
            tvSongLyrics = itemView.findViewById(R.id.tv_song_lyrics);
        }
    }
}

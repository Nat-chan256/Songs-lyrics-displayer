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
import ru.tuturu.songsdisplayer.util.StringUtil;

public class SongsLyricsAdapter extends
        RecyclerView.Adapter<SongsLyricsAdapter.SongsLyricsViewHolder> {

    private List<Song> songs;
    private OnNoteListener onNoteListener;

    public SongsLyricsAdapter(List<Song> songs, OnNoteListener onNoteListener){
        this.songs = songs;
        this.onNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public SongsLyricsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_item, parent, false);
        return new SongsLyricsViewHolder(itemView, onNoteListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsLyricsViewHolder holder, int position) {
        holder.tvSongTitle.setText(songs.get(position).getTitle());
        holder.tvSongLyrics.setText(
                StringUtil.extractFirstLines(5, songs.get(position).getLyrics())
        );
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class SongsLyricsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView tvSongTitle;
        private final TextView tvSongLyrics;
        private OnNoteListener onNoteListener;

        public SongsLyricsViewHolder(View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            tvSongTitle = itemView.findViewById(R.id.tv_song_title);
            tvSongLyrics = itemView.findViewById(R.id.tv_song_lyrics);
            this.onNoteListener = onNoteListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAbsoluteAdapterPosition());
        }
    }

    // Interface that reacts to recycler view item touch
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}

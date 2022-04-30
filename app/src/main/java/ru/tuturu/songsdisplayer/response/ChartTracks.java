package ru.tuturu.songsdisplayer.response;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class ChartTracks implements Serializable {
  private Message message;

  public Message getMessage() {
    return this.message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public static class Message implements Serializable {
    private Header header;

    private Body body;

    public Header getHeader() {
      return this.header;
    }

    public void setHeader(Header header) {
      this.header = header;
    }

    public Body getBody() {
      return this.body;
    }

    public void setBody(Body body) {
      this.body = body;
    }

    public static class Header implements Serializable {
      private Integer status_code;

      private Double execute_time;

      public Integer getStatus_code() {
        return this.status_code;
      }

      public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
      }

      public Double getExecute_time() {
        return this.execute_time;
      }

      public void setExecute_time(Double execute_time) {
        this.execute_time = execute_time;
      }
    }

    public static class Body implements Serializable {
      private List<? extends Track_list> track_list;

      public List<? extends Track_list> getTrack_list() {
        return this.track_list;
      }

      public void setTrack_list(List<? extends Track_list> track_list) {
        this.track_list = track_list;
      }

      public static class Track_list implements Serializable {
        private Track track;

        public Track getTrack() {
          return this.track;
        }

        public void setTrack(Track track) {
          this.track = track;
        }

        public static class Track implements Serializable {
          private String updated_time;

          private String track_share_url;

          private Primary_genres primary_genres;

          private String artist_name;

          private Integer commontrack_id;

          private Integer artist_id;

          private Integer explicit;

          private Integer num_favourite;

          private Integer track_rating;

          private Integer has_richsync;

          private Integer track_id;

          private Integer instrumental;

          private String album_name;

          private Integer restricted;

          private Integer has_subtitles;

          private Integer album_id;

          private Integer has_lyrics;

          private String track_edit_url;

          private String track_name;

          public String getUpdated_time() {
            return this.updated_time;
          }

          public void setUpdated_time(String updated_time) {
            this.updated_time = updated_time;
          }

          public String getTrack_share_url() {
            return this.track_share_url;
          }

          public void setTrack_share_url(String track_share_url) {
            this.track_share_url = track_share_url;
          }

          public Primary_genres getPrimary_genres() {
            return this.primary_genres;
          }

          public void setPrimary_genres(Primary_genres primary_genres) {
            this.primary_genres = primary_genres;
          }

          public String getArtist_name() {
            return this.artist_name;
          }

          public void setArtist_name(String artist_name) {
            this.artist_name = artist_name;
          }

          public Integer getCommontrack_id() {
            return this.commontrack_id;
          }

          public void setCommontrack_id(Integer commontrack_id) {
            this.commontrack_id = commontrack_id;
          }

          public Integer getArtist_id() {
            return this.artist_id;
          }

          public void setArtist_id(Integer artist_id) {
            this.artist_id = artist_id;
          }

          public Integer getExplicit() {
            return this.explicit;
          }

          public void setExplicit(Integer explicit) {
            this.explicit = explicit;
          }

          public Integer getNum_favourite() {
            return this.num_favourite;
          }

          public void setNum_favourite(Integer num_favourite) {
            this.num_favourite = num_favourite;
          }

          public Integer getTrack_rating() {
            return this.track_rating;
          }

          public void setTrack_rating(Integer track_rating) {
            this.track_rating = track_rating;
          }

          public Integer getHas_richsync() {
            return this.has_richsync;
          }

          public void setHas_richsync(Integer has_richsync) {
            this.has_richsync = has_richsync;
          }

          public Integer getTrack_id() {
            return this.track_id;
          }

          public void setTrack_id(Integer track_id) {
            this.track_id = track_id;
          }

          public Integer getInstrumental() {
            return this.instrumental;
          }

          public void setInstrumental(Integer instrumental) {
            this.instrumental = instrumental;
          }

          public String getAlbum_name() {
            return this.album_name;
          }

          public void setAlbum_name(String album_name) {
            this.album_name = album_name;
          }

          public Integer getRestricted() {
            return this.restricted;
          }

          public void setRestricted(Integer restricted) {
            this.restricted = restricted;
          }

          public Integer getHas_subtitles() {
            return this.has_subtitles;
          }

          public void setHas_subtitles(Integer has_subtitles) {
            this.has_subtitles = has_subtitles;
          }

          public Integer getAlbum_id() {
            return this.album_id;
          }

          public void setAlbum_id(Integer album_id) {
            this.album_id = album_id;
          }

          public Integer getHas_lyrics() {
            return this.has_lyrics;
          }

          public void setHas_lyrics(Integer has_lyrics) {
            this.has_lyrics = has_lyrics;
          }

          public String getTrack_edit_url() {
            return this.track_edit_url;
          }

          public void setTrack_edit_url(String track_edit_url) {
            this.track_edit_url = track_edit_url;
          }

          public String getTrack_name() {
            return this.track_name;
          }

          public void setTrack_name(String track_name) {
            this.track_name = track_name;
          }

          public static class Primary_genres implements Serializable {
          }
        }
      }
    }
  }
}

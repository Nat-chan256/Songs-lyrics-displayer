package ru.tuturu.songsdisplayer.response;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;

public class TrackLyrics implements Serializable {
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
      private Lyrics lyrics;

      public Lyrics getLyrics() {
        return this.lyrics;
      }

      public void setLyrics(Lyrics lyrics) {
        this.lyrics = lyrics;
      }

      public static class Lyrics implements Serializable {
        private Integer explicit;

        private String updated_time;

        private String lyrics_body;

        private String lyrics_copyright;

        private String pixel_tracking_url;

        private String script_tracking_url;

        private Integer lyrics_id;

        public Integer getExplicit() {
          return this.explicit;
        }

        public void setExplicit(Integer explicit) {
          this.explicit = explicit;
        }

        public String getUpdated_time() {
          return this.updated_time;
        }

        public void setUpdated_time(String updated_time) {
          this.updated_time = updated_time;
        }

        public String getLyrics_body() {
          return this.lyrics_body;
        }

        public void setLyrics_body(String lyrics_body) {
          this.lyrics_body = lyrics_body;
        }

        public String getLyrics_copyright() {
          return this.lyrics_copyright;
        }

        public void setLyrics_copyright(String lyrics_copyright) {
          this.lyrics_copyright = lyrics_copyright;
        }

        public String getPixel_tracking_url() {
          return this.pixel_tracking_url;
        }

        public void setPixel_tracking_url(String pixel_tracking_url) {
          this.pixel_tracking_url = pixel_tracking_url;
        }

        public String getScript_tracking_url() {
          return this.script_tracking_url;
        }

        public void setScript_tracking_url(String script_tracking_url) {
          this.script_tracking_url = script_tracking_url;
        }

        public Integer getLyrics_id() {
          return this.lyrics_id;
        }

        public void setLyrics_id(Integer lyrics_id) {
          this.lyrics_id = lyrics_id;
        }
      }
    }
  }
}

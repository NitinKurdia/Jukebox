package Declair;

import java.sql.Time;

public class Songs implements Comparable<Songs> {
    private int songsId;
    private String songName;
    private String artistName;
    private String album;
    private String genre;
    private Time duration;
    private String songsPath;

    public Songs(int songsId, String songName, String artistName, String album, String genre, Time duration, String songsPath) {
        this.songsId = songsId;
        this.songName = songName;
        this.artistName = artistName;
        this.album = album;
        this.genre = genre;
        this.duration = duration;
        this.songsPath = songsPath;
    }

    public int getSongsId() {
        return songsId;
    }

    public void setSongsId(int songsId) {
        this.songsId = songsId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getSongsPath() {
        return songsPath;
    }

    public void setSongsPath(String songsPath) {
        this.songsPath = songsPath;
    }

    @Override
    public String toString()
    {

        return " " +songsId +  "           " + songName +"          "  + artistName+
                "        "+ album  + "          " + genre +  "      "+duration  +   "       " + songsPath;
    }

    @Override
    public int compareTo(Songs o) {
        return getSongName().compareTo(songName);
    }
}

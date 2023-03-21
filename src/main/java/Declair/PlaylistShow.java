package Declair;

public class PlaylistShow {
    private int playListId;
    private int songId;
    private int userId;

    public PlaylistShow(int playListId, int songId, int userId) {
        this.playListId = playListId;
        this.songId = songId;
        this.userId = userId;
    }

    public int getPlayListId() {
        return playListId;
    }

    public void setPlayListId(int playListId) {
        this.playListId = playListId;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "PlaylistShow{" +
                "playListId=" + playListId +
                ", songId=" + songId +
                ", userId=" + userId +
                '}';
    }
}

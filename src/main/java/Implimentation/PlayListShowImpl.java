package Implimentation;
import Declair.Playlist;
import Declair.PlaylistShow;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListShowImpl {
    Connection con;

    public void showPlaylistSongs(int playListId, Connection con) {
        try {
            String sql = "select * from songs where songId in(select songId from playlistShow where playlistId=?)";
            PreparedStatement statement1 = con.prepareStatement(sql);
            statement1.setInt(1, playListId);
            ResultSet Play = statement1.executeQuery();
            while (Play.next()) {
                System.out.format("%-5s %-25s %-25s %-25s %-10s %-15s %n", Play.getInt(1), Play.getString(2), Play.getString(3), Play.getString(4), Play.getString(5), Play.getTime(6));

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void addSongToPlatList(int playListId, int songId, int userId, Connection con) {
        try {

            String sql = "insert into playListShow values (?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playListId);
            statement.setInt(2, songId);
            statement.setInt(3, userId);
            statement.executeUpdate();
            System.out.println("Song Added Successfully");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void playListName(int playListId, Connection con) {

        try {

            String sql = "select  playListName from playlist where playlistId=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, playListId);
            ResultSet Playlist = statement.executeQuery();

            while (Playlist.next()) {
                Playlist.getString(1);
            }
            System.out.println("Your PlayList Name" + Playlist);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public void DeletePlayListSong(int songId, Connection con) {
        try {
            String sql = "delete from playListShow where songId =?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, songId);
            statement.executeUpdate();

            System.out.println("  Song Is Deleted");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}





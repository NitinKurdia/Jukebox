package Implimentation;
import Connection.GetConnection;
import Declair.Playlist;
import Declair.Songs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Exception.PlayListAlreadyExist;

public class PlaylistImpl {
    Connection con;
    List<Playlist> playlist = new ArrayList<>();

    public List<Playlist> PlaylistAddList(Connection con) {

        List<Playlist> playlist = new ArrayList<>();
        try {

            String sql = "select * from playlist";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Playlist Play;
            while (resultSet.next()) {
                int playlistId = resultSet.getInt(1);
                String playlistName = resultSet.getString(2);
                int userId = resultSet.getInt(3);
                Playlist play = new Playlist(playlistId, playlistName, userId);
                playlist.add(play);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return playlist;


    }
    public void showPlaylist(int userId,Connection con)   {
        try {

            String sql = "select * from playlist where userId=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.format("%-15s %-20s   %n", resultSet.getInt(1), resultSet.getString(2));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void createPlayList( int userId,String playlistName,Connection con) {
        try{
            String sql= "insert into playlist(userId,playListName) values(?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1,userId);
            statement.setString(2,playlistName);

statement.executeUpdate();
            System.out.println("PlayList is created");



        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



}

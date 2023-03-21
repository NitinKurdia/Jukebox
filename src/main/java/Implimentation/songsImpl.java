package Implimentation;

import Declair.Songs;
import Connection.GetConnection;
import Funtional_Interface.ArtistName;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import Exception.SongNotFound;
import  Exception.SearchNotFound;

public class songsImpl {
    Connection con;
    List<Songs> songs = new ArrayList<>();

    public List<Songs> AllSongInList(Connection con) {


        try {
            String sql = "select * from songs";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            Songs songs1;
            while (resultSet.next()) {
                int songId = resultSet.getInt(1);
                String songName = resultSet.getString(2);
                String artistName = resultSet.getString(3);
                String album = resultSet.getString(4);
                String genre = resultSet.getString(5);
                Time duration = resultSet.getTime(6);
                String songPath = resultSet.getString(7);
                songs1 = new Songs(songId, songName, artistName, album, genre, duration, songPath);
                songs.add(songs1);

            }
//Collections.sort(songs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return songs;
    }

    public void showAllSongs(Connection con) {
        try {

            String sql = "select * from songs";
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.format("%-5s %-25s %-25s %-25s %-10s %-15s %n", resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getTime(6));
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Songs> sortByArtistName(String artistName,List<Songs> songs) throws SearchNotFound {


        List<Songs> ByArtistName = new ArrayList<>();

        for (Songs songs1 : songs) {
            // System.out.println(songs1.getArtistName()+"    "+artistName);
            if (songs1.getArtistName().equalsIgnoreCase(artistName)) {
                ByArtistName.add(songs1);

            }
            ByArtistName.sort((o1, o2) ->
            {
                return o1.getArtistName().compareToIgnoreCase(o2.getArtistName());
            });
        }
//        try {
//            if (ByArtistName.isEmpty()) {
//                throw new SearchNotFound("No Song Found In The List");
//            }
//        } catch (SearchNotFound ex)
//        {
//            System.out.println(ex.getMessage());
//        }

                return ByArtistName;


    }

        public List<Songs> sortByAlbum(String album,List<Songs> songs)throws SearchNotFound {
        List<Songs> ByAlbum = new ArrayList<>();
        for (Songs songs1 : songs) {
            if (songs1.getAlbum().equalsIgnoreCase(album)) {
                ByAlbum.add(songs1);
            }
            ByAlbum.sort((o1, o2) ->
            {
                return o1.getAlbum().compareToIgnoreCase(o2.getAlbum());
            });

        }
        return  ByAlbum;

    }
    public List<Songs> sortBySonName(String songName,List<Songs> songs)throws SearchNotFound {
        List<Songs> BySongName = new ArrayList<>();
        for (Songs songs1 : songs) {
            if (songs1.getSongName().equalsIgnoreCase(songName)) {
                BySongName.add(songs1);
            }
            BySongName.sort((o1, o2) ->
            {
                return o1.getSongName().compareToIgnoreCase(o2.getSongName());
            });

        }
        return  BySongName;

    }
    public List<Songs> sortByGenre(String genre,List<Songs> songs)throws SearchNotFound {
        List<Songs> ByGenre = new ArrayList<>();
        for (Songs songs1 : songs) {
            if (songs1.getGenre().equalsIgnoreCase(genre)) {
                ByGenre.add(songs1);
            }
            ByGenre.sort((o1, o2) ->
            {
                return o1.getGenre().compareToIgnoreCase(o2.getGenre());
            });

        }
        return ByGenre;

    }
}


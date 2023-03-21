package Implimentation;

import AudioPlayer.SongPath;
import Declair.Songs;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import Connection.GetConnection;
import Exception.SearchNotFound;

import static org.junit.jupiter.api.Assertions.*;

class songsImplTest {
    GetConnection getConnection = new GetConnection();
    Connection conn = getConnection.getConnect();
    songsImpl songImp=new songsImpl();
    SongPath songPath = new SongPath();
    List<Songs> songs=songImp.AllSongInList(conn);


    @Test
    void sortByArtistName() throws SQLException, ClassNotFoundException, SearchNotFound {
        List<Songs> songsList=songImp.sortByArtistName("Arijit-Singh",songs);
        assertEquals(2,songsList.size());    }

    @Test
    void sortByGenre() throws SQLException, ClassNotFoundException, SearchNotFound {
        List<Songs> genre=songImp.sortByGenre("Romantic",songs);
        assertEquals(2,genre.size());    }

    @Test
    void sortByAlbum() throws SQLException, ClassNotFoundException, SearchNotFound {
        List<Songs> album=songImp.sortByAlbum("Kabir-Singh",songs);
        assertEquals(1,album.size());    }
    @Test
    void sortBySonName() throws SQLException, ClassNotFoundException, SearchNotFound {
        List<Songs> name=songImp.sortBySonName("Laagi-Lagan-Shankara",songs);
        assertEquals(1,name.size());    }



}
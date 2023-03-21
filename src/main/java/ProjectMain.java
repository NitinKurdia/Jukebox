import Connection.GetConnection;
import Declair.Songs;
import Implimentation.songsImpl;
import java.sql.Connection;
import AudioPlayer.SongPath;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Declair.Playlist;
import Declair.PlaylistShow;
import Implimentation.PlaylistImpl;
import Implimentation.PlayListShowImpl;
import User.UserCheck;
import AudioPlayer.Audio;
import Exception.SearchNotFound;
import Exception.PassMustContainSpecial;
import Exception.EmailContainsSpecial;
import Exception.SongNotFound;
import AudioPlayer.SongPath;

import javax.sound.midi.Soundbank;

//import User.userCheck;
//import Implimentation.songsImpl;
//import AudioPlayer.Audio;
////import dao.*;
////import exceptions.PlaylistNotFoundException;
////import exceptions.SongNotFoundException;
////import operation.SongOperation;
//
//import javax.sound.sampled.LineUnavailableException;
//import javax.sound.sampled.UnsupportedAudioFileException;
//import java.io.IOException;
//import java.sql.SQLException;
//import java.util.Scanner;
//
public class ProjectMain {
    public static void main(String[] args) throws  PassMustContainSpecial, EmailContainsSpecial {
        GetConnection getConnection = new GetConnection();
        Connection conn = getConnection.getConnect();
        UserCheck userCheck = new UserCheck();
        SongPath songPath = new SongPath();
        String path;
        songsImpl songs = new songsImpl();
        PlaylistImpl playlist=new PlaylistImpl();
        PlayListShowImpl playListShow=new PlayListShowImpl();
        Scanner scanner = new Scanner(System.in);
        int ch1,ch2,ch3,ch4,ch5,choice5, choice1, choice7,choice6,choice8,choice9,choice4,enter,choice3,variable=1;
        System.out.println("\n \n ***********************************            ~~~~~~~~~~~~~~~~~     WELCOME TO NITIN JUKEBOX       ~~~~~~~~~~~~~~~~                         ****************************************************************************************************************************************");
        System.out.println();
        System.out.println("Press    \n     1:-   To Continue                    0:-       To Exit");
         enter = scanner.nextInt();
        while (enter == 1) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~             !!!   Welcome to Jukebox Login Portal  !!!   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println(" Enter \n   1)  If You Are Registered User        2) If You Are New User");

            int Enter = scanner.nextInt();
            int op1=1,op2=1;
            switch (Enter) {
                case 1: {
                    System.out.println(" Login Details :- ");
                    System.out.println();
                    System.out.println(" Enter User Name");
                    String name = scanner.next();
                    System.out.println(" Enter Password");
                    String password = scanner.next();
                    boolean check = userCheck.Login(name, password);
                    if (check == false) {
                        System.out.println("Please Enter Correct Details");
                        break;
                    }
                    while (op1 == 1) {

                        System.out.println(" Select From Following");
                        System.out.println("\n 1) Display All Songs ");
                        System.out.println(" 2) Search Songs Name By Alphabet \n  3) Search Song By Artist Name" +
                                " \n 4) Search By Album \n  5) Search By Genre \n 6) Show All PlayList \n 7) Create PlayList " +
                                "\n 8) Adding Song To Existing PlayList \n 9) Delete Song From PlayList \n 10) To Go Out From The Portal ");

                        int choice = scanner.nextInt();
                        switch (choice) {
                            case 1: {
                                System.out.println("       TABLE OF ALL SONGS      ");
                                System.out.println("    -------------------------      ");
                                System.out.println();
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n", "ID", "SONG NAME", "ARTIST", "ALBUM", "GENRE", "TIME");
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------");
                                songs.showAllSongs(conn);
//                                System.out.println("\n Enter Song Id:-");
//                                path = songPath.showSongPath(conn);
//                                Audio.playSong(path);
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  Choose   1) If You Want To  Play Another Song                           0) If You Want To Main Menu ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  Press\n  1)    GO TO MAIN MENU              \n  2) To Go Out Of The Portal            ");
                                choice1 = scanner.nextInt();
                                if (choice1 == 1) {
                                    op1 = 1;
                                    continue;
                                }
                                // op1 = 0;
                                break;
                            }




                            case 2: {
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                System.out.println("------------------------------------------------------------------------------------------------------------------");
                                try {
                                    songs.showAllSongs(conn);
                                    List<Songs> list = songs.AllSongInList(conn);
                                    System.out.println("Enter Song Name");
                                    String songName = scanner.next();
                                    List<Songs> s = songs.sortBySonName(songName, list);
                                    System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                    for (Songs list1 : s) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-20s %-20s %n", list1.getSongsId(),
                                                list1.getSongName(), list1.getArtistName(), list1.getAlbum(),
                                                list1.getGenre(), list1.getDuration());
                                    }
                                    if (s.isEmpty()) {
                                        throw new SearchNotFound("Search Not Found");
                                    }
                                } catch (SearchNotFound e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                    ch2 = scanner.nextInt();
                                    if (ch2 == 1) {
                                        op1 = 1;
                                        enter = 1;
                                        continue;
                                    }
                                    break;
                                }
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  Choose   1) If You Want To  Play Another Song                           0) If You Want To Main Menu ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  Enter \n1)   TO GO TO MAIN MENU                *) Press Any Key To Exit          ");
                                ch3 = scanner.nextInt();
                                if (ch3 == 1) {
                                    op1 = 1;
                                    enter = 0;
                                    continue;
                                }
                                break;
                            }

                            case 3: {
                                System.out.println("Enter Artist Name");
                                String artistName = scanner.next();
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------");
                                List<Songs> list = songs.AllSongInList(conn);
                                try {

                                    List<Songs> s = songs.sortByArtistName(artistName, list);
                                    for (Songs list1 : s) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-20s %-20s %n", list1.getSongsId(),
                                                list1.getSongName(), list1.getArtistName(), list1.getAlbum(), list1.getGenre(), list1.getDuration());
                                    }
                                    if (s.isEmpty()) {
                                        throw new SearchNotFound("No Data Searched");
                                    }

                                } catch (SearchNotFound e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                     choice3 = scanner.nextInt();
                                    if (choice3 == 1) {
                                        op1 = 1;
                                        enter = 1;
                                        continue;
                                    }
                                    break;
                                }
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  Choose   1) If You Want To  Play Another Song                           0) If You Want To Main Menu ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  Enter \n1)   TO GO TO MAIN MENU                *) Press Any Key To Exit          ");
                                choice4 = scanner.nextInt();
                                if (choice4 == 1) {
                                    op1 = 1;
                                    enter = 0;
                                    continue;
                                }
                                break;
                            }

                            case 4: {
                                try {
                                    System.out.println("Enter Album Name");
                                    String album = scanner.next();
                                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                                    List<Songs> list = songs.AllSongInList(conn);
                                    List<Songs> s = songs.sortByAlbum(album, list);
                                    for (Songs list1 : s) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-20s %-20s  %n", list1.getSongsId(),
                                                list1.getSongName(), list1.getArtistName(), list1.getAlbum(), list1.getGenre(), list1.getDuration());
                                    }
                                    if (s.isEmpty()) {
                                        throw new SearchNotFound("No Data Searched");
                                    }

                                } catch (SearchNotFound e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                    choice5 = scanner.nextInt();
                                    if (choice5 == 1) {
                                        op1 = 1;
                                        enter = 1;
                                        continue;
                                    }
                                    break;
                                }
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  Choose   1) If You Want To  Play Another Song                           0) If You Want To Main Menu ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  Enter \n1)   TO GO TO MAIN MENU                *) Press Any Key To Exit          ");
                                ch3 = scanner.nextInt();
                                if (ch3 == 1) {
                                    op1 = 1;
                                    enter = 0;
                                    continue;
                                }
                                break;
                            }


                            case 5: {
                                try {
                                    System.out.println("Enter Genre Name");
                                    String genre = scanner.next();
                                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                                    List<Songs> list = songs.AllSongInList(conn);
                                    List<Songs> s = songs.sortByGenre(genre, list);
                                    for (Songs list1 : s) {
                                        System.out.format("%-10s %-20s %-28s %-30s  %-20s %-20s %n", list1.getSongsId(),
                                                list1.getSongName(), list1.getArtistName(), list1.getAlbum(), list1.getGenre(), list1.getDuration());
                                    }
                                    if (s.isEmpty()) {
                                        throw new SearchNotFound("No Data Searched");
                                    }

                                } catch (SearchNotFound e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("  DO YOU WANT TO GO BACK TO MAIN MENU  Enter 1)   TO GO TO MAIN MENU                2) TO EXIT           ");
                                    choice6 = scanner.nextInt();
                                    if (choice6 == 1) {
                                        op1 = 1;
                                        enter = 1;
                                        continue;
                                    }
                                    break;
                                }
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  Choose   1) If You Want To  Play Another Song                           0) If You Want To Main Menu ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  Enter \n1)   TO GO TO MAIN MENU                *) Press Any Key To Exit          ");
                               choice7 = scanner.nextInt();
                                if ( choice7 == 1) {
                                    op1 = 1;
                                    enter = 0;
                                    continue;
                                }
                                break;
                            }


                            case 6: {
                                System.out.println("Enter User Id");
                                int userId = scanner.nextInt();
                                System.out.println("*****************************************************************************");
                                // System.out.format("%-10s %-10s %n"," PlayList Id,PlayList Name,User Id");
                                System.out.println("PlayList Id     PlayList Name                   ");
                                playlist.showPlaylist(userId, conn);
                                System.out.println("*****************************************************************************");
                                System.out.println("Enter PlayList Id");
                                int playLisId = scanner.nextInt();
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                                playListShow.showPlaylistSongs(playLisId, conn);
//                                System.out.println("Enter Song Id");
//                                path = songPath.showSongPath(conn);
//                                Audio.playSong(path);
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id:-");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  PRESS  \n 1) To PLAY ANOTHER SONG   " +
                                            "         0) TO GO TO MAIN MENU  ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }

                                System.out.println("  Enter 1)   TO GO TO MAIN MENU                 *) Press Any Key To Exit           ");
                                ch4 = scanner.nextInt();
                                if (ch4 == 1) {
                                    op1 = 1;
                                    continue;
                                } else if (ch4 == 2) {
                                    break;
                                }
                                break;

                            }
                            case 7: {

                                System.out.println("Please Enter User Id ");
                                int userId = scanner.nextInt();
                                System.out.println("Please Enter PlayList Name");
                                String playName = scanner.next();
                                playlist.createPlayList(userId, playName, conn);
                                System.out.println("Successfully Updated");
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println(" PLAYLIST ID       PLAYLIST NAME");
                                playlist.showPlaylist(userId, conn);
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println("Enter playlist id to in which you want to Add");
                                int playLisId = scanner.nextInt();
                                songs.showAllSongs(conn);
                                System.out.println("Enter Song Id to add song to your playlist");
                                int songId = scanner.nextInt();
                                playListShow.addSongToPlatList(playLisId, songId, userId, conn);
                                System.out.println("     --- Songs Added Successfully to playlist  ----");
                                System.out.println("\n Songs in your PlayList Name " + playName + "   Contains These Songs");
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                                playListShow.showPlaylistSongs(playLisId, conn);
                                System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  PRESS  \n 1) To PLAY ANOTHER SONG             0) TO GO TO MAIN MENU  ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  \nEnter 1)   TO GO TO MAIN MENU                *) Press Any Key To Exit         ");
                                ch5 = scanner.nextInt();
                                if (ch5 == 1) {
                                    op1 = 1;
                                    enter = 0;
                                    continue;
                                }

                                break;
                            }

                            case 8: {
                                System.out.println("Please Enter User Id");
                                int userId = scanner.nextInt();
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println(" PLAYLIST ID     PLAYLIST NAME         ");
                                playlist.showPlaylist(userId, conn);
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println("Enter playlist id to in which you want to Add");
                                int playLisId = scanner.nextInt();
                                songs.showAllSongs(conn);
                                System.out.println("Enter Song Id to add song to your playlist");
                                int songId = scanner.nextInt();
                                playListShow.addSongToPlatList(playLisId, songId, userId, conn);
                                System.out.println("     --- Songs Added Successfully to playlist  ----");
//                              playListShow.playListName(playLisId, conn);
                                System.out.println("\n Songs in your PlayList  Contains These Songs");
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                playListShow.showPlaylistSongs(playLisId, conn);
                                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                                while (variable == 1) {
                                    System.out.println("\n Enter Song Id ");
                                    path = songPath.showSongPath(conn);
                                    Audio.playSong(path);
                                    System.out.println("  PRESS  \n 1) To PLAY ANOTHER SONG                     *) Press Any Key To Exit   ");
                                    variable = scanner.nextInt();
                                    if (variable == 0) {
                                        break;
                                    }
                                }
                                System.out.println("  \n Enter 1)    GO TO MAIN MENU                *) Press Any Key To Exit           ");
                              choice8 = scanner.nextInt();
                                if (choice8 == 1) {
                                    op1 = 1;
                                    continue;
                                }

                                break;
                            }
                            case 9:{
                                System.out.println("Please Enter User Id");
                                int userId = scanner.nextInt();
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println(" PLAYLIST ID       PLAYLIST NAME         ");
                                playlist.showPlaylist(userId, conn);
                                System.out.println("-------------------------------------------------------------------------------");
                                System.out.println("Enter playlist id to in which you want to Delete");
                                int playLisId = scanner.nextInt();
                                System.out.println("ID         SONG NAME             ARTIST                 ALBUM                 GENRE                             TIME");
                                playListShow.showPlaylistSongs(playLisId, conn);
                                System.out.println("Enter Song Id to Delete song From Your Playlist");
                                int songId = scanner.nextInt();
                                playListShow.DeletePlayListSong(songId,conn);
                                System.out.println("     --- Songs Deleted Successfully to playlist  ----");
                                System.out.printf("%-5s %-25s %-25s %-25s %-10s %-15s %n","ID","SONG NAME","ARTIST","ALBUM","GENRE","TIME");
                                System.out.println("-------------------------------------------------------------------------------");
                                playListShow.showPlaylistSongs(playLisId, conn);
                                System.out.println("  \n Enter 1)    GO TO MAIN MENU                *) Press Any Key To Exit           ");
                                choice9 = scanner.nextInt();
                                if (choice9 == 1) {
                                    op1 = 1;
                                    continue;
                                }

                                break;

                            }
                            case 10: {
                                System.out.println("******----------------THANK YOU--TO VISIT JUKEBOX -------............");
                                System.out.println("................Visit us again.......................");
                                break;
                            } default:
                                System.out.println("Wrong Input");
                        }
                        break;
                    }
                    break;
                }


                            case 2: {

                                System.out.println("Enter Your Details For Signup");
                                System.out.println("Enter your Details Here ");
                                System.out.println("Enter User Name");
                                String name = scanner.next();
                                System.out.println("Enter User Password Must Contains @");
                                String password = scanner.next();
                                try {
                                    boolean s = password.contains("@");
                                    if (s == false) {
                                        throw new PassMustContainSpecial("Password Must Contain @");
                                    }
                                } catch (PassMustContainSpecial e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                System.out.println("Enter Email ");
                                String email = scanner.next();
                                try {
                                    boolean emailCheck = email.contains("@");
                                    if (emailCheck == false) {
                                        throw new EmailContainsSpecial("Password Must Contain @");
                                    }
                                } catch (EmailContainsSpecial e) {
                                    System.out.println(e.getMessage());
                                    break;
                                }
                                System.out.println("Enter Mobile Number Minimum 10 Digit Required");
                                long mobile = scanner.nextLong();
                                userCheck.signUp(conn, name, password, email, mobile);
                                System.out.println("PRESS \n 1) To  HOME PAGE  \n 0) To EXIT");
                                ch5 = scanner.nextInt();
                                if (ch5 == 0)
                                {
                                    break;
                                }
                               enter=1;
continue;
                            }
                default:
                    System.out.println("Please Enter Correct Input");
            }
enter=7;
        }





                    if (enter == 0) {
                        System.out.println("Thank-You For Using Jukebox Music Player");
                    } else {
                        System.out.println("Thank You");
                    }
                }
            }


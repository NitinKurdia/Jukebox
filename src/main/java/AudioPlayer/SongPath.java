package AudioPlayer;
import java.sql.*;
import java.util.Scanner;

public class SongPath
{
    Connection con;
    String path;
    Scanner s=new Scanner(System.in);

    public String showSongPath(Connection con)
    {
       try{
            int choice=s.nextInt();
            String songName ="select * from Songs where songId=?";
            PreparedStatement statement1= con.prepareStatement(songName);
            statement1.setInt(1,choice);
            ResultSet url=statement1.executeQuery();
            while (url.next())
            {
                path=url.getString(7);
            }

        }
        catch (SQLException e)
        {
            System.out.println("Path not find");
        }

        return path;
    }

}

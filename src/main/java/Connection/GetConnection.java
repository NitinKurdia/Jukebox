package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection
{
  public Connection  getConnect(){
      Connection con=null;

      try {
    Class.forName("com.mysql.cj.jdbc.Driver");  // load the driver
    con = DriverManager.getConnection
            ("jdbc:mysql://localhost:3306/jukebox",
                    "root", "root");
} catch (ClassNotFoundException e) {
    System.out.println(e.getMessage());
} catch (SQLException e) {
    System.out.println(e.getMessage());
}
       return con;
   }

}
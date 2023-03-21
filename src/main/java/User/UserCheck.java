package User;

import java.sql.*;
import Exception.PassMustContainSpecial;
import  Exception.EmailContainsSpecial;

public class UserCheck  {
    Connection con;

    public int CheckUser(Connection con, String userName) {
        int found = 0;
        try {
            String sql = "Select * from Users where userName=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                found++;
                break;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        if (found == 1) {
            return 1;
        } else
            return 0;
    }

    public void signUp(Connection con, String userName,String PassWord, String email, long mobileNumber ) throws PassMustContainSpecial,EmailContainsSpecial {
        {
            int exist = CheckUser(con, userName);
            if (exist == 1) {
                System.out.println("User Already Exist");
                return;
            }
        }
        try {
            String sql = "insert into Users(userName,password,email,mobileNumber) values(?,?,?,?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, userName);
            statement.setString(2, PassWord);
            statement.setString(3, email);
            statement.setLong(4, mobileNumber);

            statement.execute();
            System.out.println("***************************Successfully Registered**************************************");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean Login( String userName, String Password) {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // load the driver
            con = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/jukebox",
                            "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();

            // System.out.println(e.getMessage());
        }

            try {
                String sql = "select userId from Users where userName=? and password=?";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, userName);
                statement.setString(2, Password);
                ResultSet resultSet = statement.executeQuery();
               // System.out.println(userName+"     "+Password);
                if(resultSet.next()){
                    System.out.println("User Id : -"+resultSet.getInt(1));

                        System.out.println("welcome to JukeBox User :-     " + userName);
                    } else  {
                        System.out.println("Your Entered Wrong User Name and Password");
return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                //System.out.println(e.getMessage());
            }
        return true;
    }
    

    }

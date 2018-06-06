package loginServlet;

import java.sql.*;

import java.io.*;





public class login {



public login(){}    //default constructor



public static boolean User(String user, String pass)

throws SQLException, IOException{



    String Username = null;

    String Password = null;

            login db=new login();

    Connection conn=null;

    conn=db.ConMe();



    Statement st=conn.createStatement();






String sql = "SELECT firstname, password FROM register" + "WHERE firstname='" + user + "'" + "AND password='" + pass + "'";

ResultSet rs = st.executeQuery(sql);

if(rs.next()){

Username = rs.getString("name");

Password = rs.getString("password");

}

if(Username != null && Password != null && user.equals(Username) && pass.equals(Password)){



return true;

}

else return false;



}



private Connection ConMe() {
	// TODO Auto-generated method stub
	return null;
}



}


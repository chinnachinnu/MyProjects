import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.*;
public class DBOperations {
public static void InsertData(String sno,String name,String city,String mobile)
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.
       getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
        PreparedStatement pst = con.prepareStatement("insert into team values(?,?,?,?)");
        pst.setString(1, sno);
        pst.setString(2, name);
        pst.setString(3, city);
        pst.setString(4, mobile);
        
        if(pst.executeUpdate()>0)
        {
        	System.out.println(sno+" Inserted sucessfully");
        	
        }}
        catch(Exception ex)
        {
        	System.out.println(sno+" failed to insert");
        	ex.printStackTrace();
        }
	}
public static ResultSet GetData()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.
       getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","12345");
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("select * from team");
        return rs;
	}
	catch(Exception e)
	{
		return null;
	}
}
}

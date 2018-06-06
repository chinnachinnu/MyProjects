package accounts.users;

import java.beans.Statement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login extends HttpServlet{
@Override
public void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	resp.setContentType("text/html");
	PrintWriter pw=resp.getWriter();
	try {
		int row_count=0;
		String username,pwd;
		username=req.getParameter("textUsername").toString();
		pwd=req.getParameter("txtPassword").toString();
		Class.forName("oracle.jdbc.driver.oracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
		
		Statement stmt=(Statement) con.createStatement();
		ResultSet rs=((java.sql.Statement) stmt).executeQuery("select tblUserMaster where userid='"+username+"'and password'"+pwd+"'");
		rs.last();
		row_count=rs.getRow();
		if(row_count>0) {
			pw.println("login successful...!");
		} 
		else
		{
			pw.println("login failed...!");
			
		}
				}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	
}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
	    String sno;
	    String name;
	    String city;
	    String mobile;
	    String age;
	    
	    PreparedStatement ps = null;
	    Connection con = null;
	    ResultSet rs = null;

	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader("G:\\java1\\test.txt"));
	        
	        Class.forName("oracle.jdbc.driver.OracleDriver");  
	        
	      
	       con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");  
	        
	        
	      Statement stmt=con.createStatement();
	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split("|");
	            sno = tmp[0];
	            name = tmp[1];
	            city = tmp[2];
	            mobile = tmp[3];
	            age = tmp[4];
	            System.out.println(sno + "\t" + name + "\t" + city + "\t" + mobile+"\txt"+ age);
	            String sql =
	                    "INSERT INTO  (date_resultat,valeur,code_pc,code_parametre,heure_resultat) values ('"
	                            + sno + "','" + name + "','1','" + city + "','" + mobile + "','" + age + "')";

	            ps = con.prepareStatement(sql);
	            ps.executeUpdate();
	        }

	        br.close();
	        con.close();
	        ps.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	}
}

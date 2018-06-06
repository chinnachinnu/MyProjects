import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.util.Scanner;


public class Sample {
public static void main(String[] args) throws IOException {
	Scanner sc=new Scanner(System.in);
	System.out.println("1.upload a FlatFile\n2.Generate FlatFIle\nEnter your Choice:");
	int choice=sc.nextInt();
	switch(choice)
	{
	case 1:
		System.out.println("Enter File Path:");
	String sPath=sc.next();
	ReadFlatFile(sPath);
	break;
	case 2:
		GenerateFlatFile();break;
		default:System.out.println("wrong input");
	}
}
public static void ReadFlatFile(String fPath)throws IOException
{
	String line="";
	BufferedReader br=null;
	try
	{
		br=new BufferedReader(new FileReader(fPath));
		while((line=br.readLine())!=null)
		{
			String[] data=line.split("\\|");
			DBOperations.InsertData(data[0],data[1],data[2],data[3]);
	}
}catch(Exception e)
	{
	e.printStackTrace();
	}
	finally {
		if(br!=null)
		{
			try
			{
				br.close();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
public static void GenerateFlatFile()
{
	try
	{
		String OutPath="F:\\insert.txt";
		int rows=0;
		ResultSet rs=DBOperations.GetData();
		File f1=new File(OutPath);
		if(!f1.exists())
		{
			f1.createNewFile();
		}
		FileOutputStream fos=new FileOutputStream(OutPath);
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(fos));
		bw.write("sno|name|city|mobile");
		bw.newLine();
		while(rs.next())
		{
			bw.write(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4));
			bw.newLine();
			rows++;
		}
		bw.close();
		System.out.println(rows+"Exported successfully....");
		System.out.println("please find the file under path:"+OutPath);
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
		System.out.println("Fail to export");
	}
}
}

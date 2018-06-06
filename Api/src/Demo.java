import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo {
public static void main(String[] args) {
	try {
		URL url=new URL("https://api.railwayapi.com/v2/route/train/12805/apikey/zgoqy3rqcm/");
		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "Application/json");
		if(conn.getResponseCode()!=200) {
			throw new RuntimeException("Failed:Http errorcode:"+conn.getResponseCode());
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String output;
		System.out.println("output from Server........\n");
		while((output=br.readLine())!=null) {
			System.out.println(output);
		}
		conn.disconnect();
	}
	catch(MalformedURLException e) {
		e.printStackTrace();
	}
	catch(IOException e) {
		e.printStackTrace();
	}
}
}


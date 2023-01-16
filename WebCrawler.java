import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WebCrawler
{
	public static void main(String[] args) throws IOException
	{
		//parse cli inputs into url string and number of hops(int)
		String stringUrl = args[0];

		//make a URL object from the input String
		URL url = new URL(stringUrl);

		//make the connection to fetch resources
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();

		int statusCode = connection.getResponseCode();
		System.out.println(statusCode);

		BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null)
		{
			System.out.println(line);
		}
	}
}

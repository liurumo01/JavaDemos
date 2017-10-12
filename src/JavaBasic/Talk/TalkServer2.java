import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer2
{
	public static void main(String[] args)
	{
		ServerSocket server=null;
		try
		{
			server=new ServerSocket(4700);
		}
		catch(Exception e)
		{
			System.err.println("can not listen to:"+e);
		}
		Socket socket=null;
		try
		{
			socket=server.accept();
		}
		catch(Exception e)
		{
			System.out.println("Error."+e);
		}
		
		
		BufferedReader is = null;
		PrintWriter os = null;
		BufferedReader sin = null;
		try
		{
			is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			os=new PrintWriter(socket.getOutputStream());
			sin=new BufferedReader(new InputStreamReader(System.in));
			
			while(!(is.readLine().equals("root") && is.readLine().equals("root")))
			{
				os.println(false);
				os.flush();
			}
			os.println(true);
			os.flush();
			
			String input = "";
			while(true)
			{
				input = is.readLine();
				System.out.println(input);
				switch(input)
				{
				case "1301":
					os.println("³£×ÓÐÀ");
					break;
				case "1302":
					os.println("ÉòÊ«Ñþ");
					break;
				case "1303":
					os.println("ÓîÎÄÉ¼ÔÂ");
					break;
				case "1304":
					os.println("Å·ÑôÃ÷Ô¶");
					break;
				case "1305":
					os.println("ÏÄÈô·«");
					break;
				}
				os.flush();
			}
		}
		catch(Exception ex)
		{
			System.err.println(ex);
		}
		finally
		{
			try
			{
				is.close();
				os.close();
				sin.close();
			}
			catch(Exception ex)
			{
				System.err.println(ex);
			}
		}
	}
}

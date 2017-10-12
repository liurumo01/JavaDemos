import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TalkClient2
{
	public static void main(String[] args)
	{
		Socket socket = null;
		PrintWriter os = null;
		BufferedReader is = null;
		
		Scanner sc = new Scanner(System.in);
		
		
		try
		{
			socket = new Socket("127.0.0.1",4700);
			os=new PrintWriter(socket.getOutputStream());
			is=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			do
			{
				System.out.println("�û�����");
				String uid = sc.nextLine();
				System.out.println("���룺");
				String psw = sc.nextLine();
				os.println(uid);
				os.flush();
				os.println(psw);
				os.flush();
				if(is.readLine().equals("true"))
				{
					System.out.println("��½�ɹ���");
					break;
				}
				else
				{
					System.err.println("�û������������");
				}
			} while(true);
			
			String input = "";
			String output = "";
			while(!input.equals("bye"))
			{
				System.out.println("������ָ�");
				input = sc.nextLine();
				os.println(input);
				os.flush();
				output = is.readLine();
				System.out.println(output);
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		finally
		{
			try
			{
				socket.close();
			}
			catch(IOException ex)
			{
				System.out.println(ex);
			}
		}
		sc.close();
	}
}

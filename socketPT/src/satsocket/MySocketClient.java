package satsocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class MySocketClient {
	
	Socket socket;
	BufferedWriter bw;
	BufferedReader br;
	
	public MySocketClient() throws Exception {
		
		socket = new Socket("192.168.0.6", 15000);
		
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String msg = "";
		
		while (true) {
			
			msg = br.readLine();
			
			if(msg.equals("종료")) {
				break;
			}
			
			bw.write(msg + "\n");
			System.out.println(" : " + msg);
			bw.flush();
		}
		

		bw.close();
		br.close();
		socket.close();
		
	}
	
	public static void main(String[] args) {
		try {
			
			new MySocketClient();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.ObjectInputStream.GetField;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;


public class TwitterClient {
	 private static int SERVER_RESPONSE_TIMEOUT = 60*1000;
	 public static BufferedReader socketReader;
	 public static PrintWriter socketWriter;
	 public static BufferedReader consoleReader;
	 public static ObjectInputStream objectInput;
	 static ResultSet asd;
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 3333); 
        socket.setSoTimeout(SERVER_RESPONSE_TIMEOUT); 
        socketReader = new BufferedReader( 
            new InputStreamReader(socket.getInputStream()) ); 
        socketWriter = 
            new PrintWriter(socket.getOutputStream()); 
        consoleReader = new BufferedReader( 
            new InputStreamReader(System.in) ); 
        objectInput = new ObjectInputStream(socket.getInputStream());
        
//        ArrayList un = new ArrayList();
//		ArrayList msg = new ArrayList();
//		String asd = "Hello,Hristo" + "\n";
//        for(int i = 0; i < 4 ; i ++) {
//        	un.add(socketReader.readLine());
//        	msg.add(socketReader.readLine());
//        	asd += un.get(i) + ":" + msg.get(i) + "\n";
//        }
//        System.out.println(asd);
//        		
        
        try {
			asd = (ResultSet) objectInput.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        try {
			while(asd.next()) {
				  System.out.println(asd.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
//        LoginForm login = new LoginForm();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class ServerConection {
	 private static final int SERVER_RESPONSE_TIMEOUT = 60*1000;
	 private static final String CONECTION_URL_OR_IP = "localhost";
	 private static final int CONECTION_PORT = 3333; 
	 private Socket socket;
	 private BufferedReader socketReader;
	 private PrintWriter socketWriter;
	 private ObjectOutputStream objectOutputStream;
	 private ObjectInputStream objectInputStream;
	 
	 
	 public ServerConection() {
		try {
			socket = new Socket(CONECTION_URL_OR_IP, CONECTION_PORT);
			socket.setSoTimeout(SERVER_RESPONSE_TIMEOUT); 
	        socketReader = new BufferedReader( 
	            new InputStreamReader(socket.getInputStream())); 
	        socketWriter = 
	            new PrintWriter(socket.getOutputStream()); 
	        objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
	        objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}  
	 }
	 
	 
	 public void closeConection() {
	      try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
	 
	 public BufferedReader getSocketReader() {
		 return socketReader;
	 }
	 
	 public PrintWriter getSocketWriter() {
		 return socketWriter;
	 }
	 
	 public ObjectOutputStream getObjectOutputStream() {
		 return objectOutputStream;
	 }
	 
	 public ObjectInputStream getObjectInputStream() {
		 return objectInputStream;
	 }
}

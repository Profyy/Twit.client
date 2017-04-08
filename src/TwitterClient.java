
public class TwitterClient {
	public static ServerConection serverConection;
	
	public static void main(String[] args)  {
		serverConection = new ServerConection();	
		new LoginForm();
	}
}

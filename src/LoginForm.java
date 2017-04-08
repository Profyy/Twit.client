import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class LoginForm {
	private String usernameContainer;
	private String passwordContainer;
	private JTextField textField1;
	private JTextField textField2;
	private boolean isAccessAllowed = false;
	HomePageForm homepage;
	WrongUsernameOrPasswordForm wrongUsername;
	
	     public LoginForm() {
	    	final MyFrame myFrame = new MyFrame("MyTwitter",250,150);
			myFrame.setLayout(new FlowLayout());
			myFrame.setBackground(Color.white);
			textField1 = new JTextField(10);
			textField2 = new JTextField(10);
			JButton loginButton = new JButton("Login");
			JButton createAccountButton = new JButton("Create new account");
			myFrame.add(new JLabel("Username: "));
			myFrame.add(textField1);
			myFrame.add(new JLabel("Password: "));
			myFrame.add(textField2);
			myFrame.add(createAccountButton);
			myFrame.add(loginButton);
			myFrame.setVisible(true);
			loginButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e)
	            {
	            	try {
		                usernameContainer = textField1.getText();
		                TwitterClient.socketWriter.println(usernameContainer);
		                TwitterClient.socketWriter.flush();
		                passwordContainer = textField2.getText();
		                TwitterClient.socketWriter.println(passwordContainer);
		                TwitterClient.socketWriter.flush();
						isAccessAllowed = Boolean.parseBoolean(TwitterClient.socketReader.readLine());
						if (isAccessAllowed) {
							myFrame.dispose();
							homepage = new HomePageForm(usernameContainer);
						}
						else{	
							myFrame.dispose();
							wrongUsername = new WrongUsernameOrPasswordForm();
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            }
	        }); 
			
			
	     }
	     
}

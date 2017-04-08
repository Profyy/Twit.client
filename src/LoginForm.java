import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class LoginForm extends MyFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton loginButton, createAccountButton;
	private ServerConection serverConection = TwitterClient.serverConection;
	
     public LoginForm() {
    	super("MyTwitter-Login",250,150);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
		textField = new JTextField(10);
		passwordField = new JPasswordField(10);
		loginButton = new JButton("Login");
		createAccountButton = new JButton("Create new account");
		this.add(new JLabel("Username: "));
		this.add(textField);
		this.add(new JLabel("Password: "));
		this.add(passwordField);
		this.add(createAccountButton);
		this.add(loginButton);
		this.setVisible(true);
		
		loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
	        	try {
	        		serverConection.getObjectOutputStream().writeInt(1);
					serverConection.getObjectOutputStream().flush();
					serverConection.getSocketWriter().println(textField.getText());
	                serverConection.getSocketWriter().flush();
	                serverConection.getSocketWriter().println(passwordField.getPassword());
	                serverConection.getSocketWriter().flush();
					boolean isAccessAllowed = 
							Boolean.parseBoolean(serverConection.getSocketReader().readLine());
					if (isAccessAllowed) {
						dispose();
						serverConection.getObjectOutputStream().writeInt(3);
						serverConection.getObjectOutputStream().flush();
						String messages = (String)serverConection.getObjectInputStream().readObject();
						new HomePageForm(messages);
					}
					else{	
						JOptionPane.showMessageDialog(null,"Wrong username or password!!!");
					}
				} catch (IOException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
            }
        }); 
		
		createAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
					new CreateAccountForm();
            }
        }); 
		
     }   
}

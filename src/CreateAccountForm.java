import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class CreateAccountForm extends MyFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton createAccountButton, cancelButton;
	private ServerConection serverConection;
	
	public CreateAccountForm() {
		super("Create account",400,150);
		serverConection = TwitterClient.serverConection;
		textField = new JTextField(10);
		passwordField = new JPasswordField(10);
		createAccountButton = new JButton("Create account");
		cancelButton = new JButton("Cancel");
		this.add(new JLabel("Username: "));
		this.add(textField);
		this.add(new JLabel("Password: "));
		this.add(passwordField);
		this.add(createAccountButton);
		this.add(cancelButton);
		this.setVisible(true);
		
		createAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
            {
				try {
					serverConection.getObjectOutputStream().writeInt(2);
					serverConection.getObjectOutputStream().flush();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
				if(textField.getText().equals("") || passwordField.getPassword().equals("")) {
					JOptionPane.showMessageDialog(null,"Invalid username or password!!!");
				}else if(textField.getText().length() >= 20) {
					JOptionPane.showMessageDialog(null,"Username is too long");
				}else {
				serverConection.getSocketWriter().println(textField.getText());
				serverConection.getSocketWriter().flush();
				serverConection.getSocketWriter().println(passwordField.getPassword());
				serverConection.getSocketWriter().flush();
				}
				boolean success = false;
				try {
					success = (boolean)serverConection.getObjectInputStream().readBoolean();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(success == false) {
					JOptionPane.showMessageDialog(null,"Username already exist");
				} else if(success == true) {
					JOptionPane.showMessageDialog(null,"Registration sucess");
				}
            }
        }); 
		
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
            {
				dispose();
            }
        }); 
	}
}

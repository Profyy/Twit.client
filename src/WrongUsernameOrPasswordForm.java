import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;


public class WrongUsernameOrPasswordForm {
	
	public WrongUsernameOrPasswordForm() {
		final MyFrame wrongUsernameOrPasswordFrame = new MyFrame("MyTwitter",250,100);
		wrongUsernameOrPasswordFrame.setLayout(new FlowLayout());
		wrongUsernameOrPasswordFrame.setBackground(Color.white);
		wrongUsernameOrPasswordFrame.add(new JLabel("Wrong USERNAME or PASSWORD!!!"));
		JButton button = new JButton("OK");
		wrongUsernameOrPasswordFrame.add(button);
		button.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e)
	        {
	        	LoginForm login = new LoginForm();
	        	wrongUsernameOrPasswordFrame.dispose();
	        }
	    }); 
	}
}

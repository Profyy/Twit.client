import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class HomePageForm extends MyFrame {
	 private JTextArea textArea;
	 private JScrollPane scrlText;
	 private JButton btnQuit, btnWriteMsg, btnRefreshMsgs, btnFollowings;
	 ServerConection serverConection;
	
	
	public HomePageForm(String messages) throws IOException{
		super("Profyy",300,275);
		serverConection = TwitterClient.serverConection;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		textArea = new JTextArea(messages, 25, 50);
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		scrlText = new JScrollPane(textArea);
		scrlText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		btnFollowings = new JButton("Followings");
		btnWriteMsg = new JButton("Write msg");
		btnRefreshMsgs = new JButton("Refresh");
		btnQuit = new JButton("Log-out");
		this.add(btnFollowings);
		this.add(scrlText);
		this.add(btnWriteMsg);
		this.add(btnRefreshMsgs);
        this.add(btnQuit);
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
        
        btnFollowings.addActionListener(
    			new ActionListener(){
    				public void actionPerformed(ActionEvent e){
    					try {
							serverConection.getObjectOutputStream().writeInt(5);
							serverConection.getObjectOutputStream().flush();
							ArrayList usernames = 
									(ArrayList) serverConection.getObjectInputStream().readObject();
							new FollowingsForm(usernames);
						} catch (IOException | ClassNotFoundException e1) {
							e1.printStackTrace();
						}
    				}
    			}
    		);
		
		btnWriteMsg.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					new WriteMessageForm();
				}
			}
		);
        
        btnRefreshMsgs.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try {
						serverConection.getObjectOutputStream().writeInt(3);
						serverConection.getObjectOutputStream().flush();
						String msgs = (String) serverConection.getObjectInputStream().readObject();
						textArea.setText("");
						textArea.setText(msgs);
					} catch (IOException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
				}
			}
		);

        btnQuit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					dispose();
					new LoginForm();
				}
			}
		);
	}
}

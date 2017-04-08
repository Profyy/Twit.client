import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class HomePageForm {
	 private JTextArea textArea;
		private JScrollPane scrlText;
	    private JButton btnQuit, btnWriteMsg;
	    String uname = null;
		ArrayList un = new ArrayList();
		ArrayList msg = new ArrayList();
		String asd = "Hello \n";
	
	
	public HomePageForm(String username) throws  IOException {
//		uname = username;
//		 for(int i = 0; i < 4 ; i ++) {
//	        	un.add(TwitterClient.socketReader.readLine());
//	        	msg.add(TwitterClient.socketReader.readLine());
//	        	asd += un.get(i) + ":" + msg.get(i) + "." + "\n";
//	        }
		MyFrame myFrame = new MyFrame(uname,500,300);
		myFrame.setLayout(new FlowLayout());
		myFrame.setBackground(Color.white);
		textArea = new JTextArea(asd, 25, 50);
		textArea.setLineWrap(true);
		scrlText = new JScrollPane(textArea);
		scrlText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		myFrame.getContentPane().add(scrlText);
		btnWriteMsg = new JButton("Write msg");
        btnWriteMsg.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);         
				}
			}
		);

		btnQuit = new JButton("Quit");
        btnQuit.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.exit(0);         
				}
			}
		);
        
		myFrame.getContentPane().add(scrlText);
		myFrame.getContentPane().add(btnWriteMsg);
        myFrame.getContentPane().add(btnQuit);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack(); // Adjusts frame to size of components
        myFrame.setVisible(true);
	}
}

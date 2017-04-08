import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class WriteMessageForm extends MyFrame {
	 private JTextArea textArea;
	 private JButton sendMessageButton, cancelBtn;
	 private JScrollPane scrlText;
	 private ServerConection serverConection;
	
	public WriteMessageForm() {
		super("Send Message",260,300);
		serverConection = TwitterClient.serverConection;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(new JLabel(""));
		textArea = new JTextArea("", 10, 20);
		textArea.setLineWrap(true);
		scrlText = new JScrollPane(textArea);
		scrlText.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sendMessageButton = new JButton("Send");
		cancelBtn = new JButton("Cancel");
		this.add(scrlText);
		this.add(textArea);
		this.add(sendMessageButton);
		this.add(cancelBtn);
		this.setVisible(true);
		
			sendMessageButton.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
							String textMessageContainer = textArea.getText();
							textArea.setText("");
							try {
								serverConection.getObjectOutputStream().writeInt(4);
								serverConection.getObjectOutputStream().flush();
								serverConection.getObjectOutputStream().writeObject(textMessageContainer);
								serverConection.getObjectOutputStream().flush();
								JOptionPane.showMessageDialog(null,"You message was sended");
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					}
				);
			
			cancelBtn.addActionListener(
					new ActionListener(){
						public void actionPerformed(ActionEvent e){
								dispose();
						}
					}
				);
	}
}

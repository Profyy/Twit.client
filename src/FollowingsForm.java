import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class FollowingsForm extends JFrame {
	 ServerConection serverConection;

    public FollowingsForm(ArrayList usernames) {
    	serverConection = TwitterClient.serverConection;
        JPanel panel = new JPanel();
        final JComboBox comboBox = new JComboBox();
        this.setTitle("Followings");
        this.setSize(250, 200);
        setLocationRelativeTo(null);
        for(int i = 0; i < usernames.size(); i++) {
        	comboBox.addItem(usernames.get(i));
        }
        this.setVisible(true);
        
        JButton button = new JButton("Select");
        JButton cancelbtn = new JButton("Cancel");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }

            private void buttonActionPerformed(ActionEvent evt) {
                String item = comboBox.getSelectedItem().toString();
                try {
					serverConection.getObjectOutputStream().writeInt(6);
					serverConection.getObjectOutputStream().flush();
					serverConection.getObjectOutputStream().writeObject(item);
					serverConection.getObjectOutputStream().flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
                JOptionPane.showMessageDialog(null, "From now you are following for : " + item);
            }
        });
        
        cancelbtn.addActionListener(
    			new ActionListener(){
    				public void actionPerformed(ActionEvent e){
    					dispose();
    				}
    			}
    		);
        
        panel.add(comboBox);
        panel.add(button);
        panel.add(cancelbtn);
        this.add(panel);
    }
}
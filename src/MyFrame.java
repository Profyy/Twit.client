import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
 
 
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	public MyFrame() {
    	setSize(100, 100);
        setTitle("MyFrame");
        setLayout(new FlowLayout());
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
   }
	
	public MyFrame(String name, int sizeX,int sizeY) {
    	setSize(sizeX, sizeY);
        setTitle(name);
        setLayout(new FlowLayout());
        setBackground(Color.white);
        setLocationRelativeTo(null);
        setVisible(true);
   }
}
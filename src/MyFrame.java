import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
 
 
public class MyFrame extends JFrame {
	public MyFrame() {
    	setSize(100, 100);
        setTitle("MyFrame");
        setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        		size.height/2 - getHeight()/2);
   }
	
	public MyFrame(String name, int sizeX,int sizeY) {
    	setSize(sizeX, sizeY);
        setTitle(name);
        setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, 
        		size.height/2 - getHeight()/2);
   }
}
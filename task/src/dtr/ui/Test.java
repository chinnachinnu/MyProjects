package dtr.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test extends JPanel {
	BufferedImage img;
	public Test() {
		// TODO Auto-generated constructor stub
		setSize(600,400);
		setVisible(true);
		loadImage("/images/rose1.jpg");
		
	}
private void loadImage( String str) {
	try {
		img=ImageIO.read(Test.class.getResource(str));
	} catch (IOException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	g.drawImage(img, 0, 0, 600, 400, this);
}
public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			JFrame frm=new JFrame();
			frm.setSize(600, 400);
			frm.setVisible(true);
			frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frm.add(new Test());
		}
	});
	
}
}

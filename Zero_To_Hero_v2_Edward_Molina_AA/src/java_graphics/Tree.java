package java_graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Tree extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4214251135340472099L;

	public Tree() {
		this.setPreferredSize(new Dimension(233, 222));
	}

	public void paint(Graphics g) {
		Color lightBlue = new Color(51,153,255);
		Color brown = new Color(102, 51, 0);
		Color veryDarkGreen = new Color(0, 102, 0);
		Color darkGreen = new Color(0,153,0);
		Color green = new Color(0,204,0);
		Color lightGreen = new Color(0,255,51);
		
		int width = 233;
		int height = 222;

		super.paintComponent(g);
		this.setBackground(lightBlue);

		Graphics2D g2D = (Graphics2D) g;
        //Creating Trunk
		g2D.setPaint(brown);
		g2D.fillRect(100, 100, width - 200, height - 100);
        //Creating Leaves
		g2D.setPaint(veryDarkGreen);
		g2D.fillArc(25, 75, 100, 100, 0, 360);
		
		g2D.setPaint(darkGreen);
		g2D.fillArc(75, 25, 100, 100, 0, 360);
		
		g2D.setPaint(green);
		g2D.fillArc(100, 25, 100, 100, 0, 360);
		
		g2D.setPaint(lightGreen);
		g2D.fillArc(115, 115, 75, 50, 0, 360);

	}

}

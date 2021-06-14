package java_graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

//Creating Graphics for the Sword Backbiter

public class Backbiter extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Backbiter() {
		this.setPreferredSize(new Dimension(233, 222));
	}

	public void paint(Graphics g) {
		Color darkYellow = new Color(255, 204, 51);
		Color lightBlue = new Color(51, 153, 255);
		Color lightBrown = new Color(153, 102, 0);
		Color brown = new Color(102, 51, 0);

		super.paintComponent(g);
		this.setBackground(lightBlue);

		Graphics2D g2D = (Graphics2D) g;

		int[] x = { 100, 111, 125 };
		int[] y = { 25, 10, 25 };
        
		//Drawing the point
		g2D.setPaint(darkYellow);
		g2D.fillPolygon(x, y, 3);
        //Drawing the sword
		g2D.setPaint(darkYellow);
		g2D.fillRect(100, 25, 25, 150);
  
		g2D.setPaint(lightBrown);
		g2D.fillRect(110, 25, 2, 150);

		g2D.setPaint(lightBrown);
		g2D.fillRect(110, 10, 2, 150);
		
        //Drawing the handle
		g2D.setPaint(brown);
		g2D.fillRect(65, 165, 100, 15);

		g2D.setPaint(brown);
		g2D.fillRect(103, 170, 20, 50);

	}
}

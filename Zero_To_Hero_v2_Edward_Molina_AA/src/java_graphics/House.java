package java_graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class House extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public House() {
		this.setPreferredSize(new Dimension(233, 222));

	}

	public void paint(Graphics g) {
		Color black = new Color(0, 0, 0);
		Color lightBrown = new Color(153, 102, 0);
		Color brown = new Color(102, 51, 0);
		Color darkBrown = new Color(51, 0, 0);
		Color veryDarkRed = new Color(153, 0, 0);

		super.paintComponent(g);
		this.setBackground(black);

		Graphics2D g2D = (Graphics2D) g;

		// Creating Chimney
		g2D.setPaint(veryDarkRed);
		g2D.fill3DRect(160, 10, 50, 100, true);

		// Creating House Roof
		int[] x = { 10, 110, 210 };
		int[] y = { 100, 20, 100 };
		g2D.setPaint(darkBrown);
		g2D.fillPolygon(x, y, 3);

		// Create the base of the house
		g2D.setPaint(brown);
		g2D.fill3DRect(10, 100, 200, 100, true);

		// Creating door
		g2D.setPaint(lightBrown);
		g2D.fillRect(90, 160, 30, 40);

		// Creating door knob
		g2D.setPaint(darkBrown);
		g2D.fillArc(110, 180, 5, 5, 0, 360);

		// Creating Window Left
		g2D.setPaint(lightBrown);
		g2D.fillRect(20, 120, 40, 40);
		// Creating Grill for Window
		g2D.setPaint(darkBrown);
		g2D.fillRect(35, 120, 5, 40);
		g2D.fillRect(20, 135, 40, 5);

		// Creating Window Right
		g2D.setPaint(lightBrown);
		g2D.fillRect(150, 120, 40, 40);
		// Creating Grill for Window
		g2D.setPaint(darkBrown);
		g2D.fillRect(165, 120, 5, 40);
		g2D.fillRect(150, 135, 40, 5);

	}
}

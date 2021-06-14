package java_graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Slime extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Slime() {
		this.setPreferredSize(new Dimension(233, 222));
	}

	public void paint(Graphics g) {
		Color darkGreen = new Color(0, 153, 0);
		Color lightGreen = new Color(0, 255, 51);
		Color black = new Color(0, 0, 0);

		super.paintComponent(g);
		this.setBackground(darkGreen);

		Graphics2D g2D = (Graphics2D) g;

		// Creating Slime Body
		g2D.setPaint(lightGreen);
		g2D.fillArc(10, 50, 200, 200, 0, 180);

		// Creating Eyes
		g2D.setPaint(black);
		g2D.fillArc(20, 100, 10, 10, 0, 360);
		g2D.fillArc(60, 100, 10, 10, 0, 360);

		// Creating mouth
		g2D.fillOval(30, 120, 10, 20);
	}
}

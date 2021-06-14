package java_graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class MagmaCube extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MagmaCube() {
		this.setPreferredSize(new Dimension(233, 222));
	}

	public void paint(Graphics g) {
		Color orange = new Color(255, 102, 0);
		Color veryDarkRed = new Color(153, 0, 0);
		Color red = new Color(255, 0, 0);
		Color black = new Color(0, 0, 0);

		super.paintComponent(g);
		this.setBackground(orange);

		Graphics2D g2D = (Graphics2D) g;

		// Creating Magma Cube body
		g2D.setPaint(veryDarkRed);
		g2D.fill3DRect(20, 20, 200, 200, true);

		// Creating Inside Body
		g2D.setPaint(red);
		g2D.fill3DRect(40, 40, 160, 160, true);

		// Creating eyes
		g2D.setPaint(black);
		g2D.fillOval(60, 90, 20, 20);
		g2D.fillOval(150, 90, 20, 20);

		// Creating mouth
		g2D.fillOval(95, 110, 40, 20);

	}
}

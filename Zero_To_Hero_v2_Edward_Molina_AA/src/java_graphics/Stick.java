package java_graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Stick extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Stick() {
		this.setPreferredSize(new Dimension(233, 222));
	}

	public void paint(Graphics g) {
		Color lightBlue = new Color(51, 153, 255);
		Color lightBrown = new Color(153, 102, 0);
		Color brown = new Color(102, 51, 0);

		super.paintComponent(g);
		this.setBackground(lightBlue);

		Graphics2D g2D = (Graphics2D) g;

		g2D.setPaint(brown);
		g2D.fillRect(100, 25, 25, 150);

		g2D.setPaint(lightBrown);
		g2D.fillRect(120, 25, 5, 150);

		g2D.setPaint(lightBrown);
		g2D.fillRect(100, 25, 25, 5);
	}

}

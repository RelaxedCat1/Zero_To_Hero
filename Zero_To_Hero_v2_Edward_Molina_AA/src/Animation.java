import java.awt.Rectangle;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

import javax.swing.Timer;

public class Animation {
	int ty = 0;
	int ttime = 50;
	boolean trise = true;
	Timer titleAnimationTimer;

	public void startAnimateTitle(GUI gui) {

		Rectangle tbound = gui.titleNameLabel.getBounds();

		titleAnimationTimer = new Timer(ttime, titleAnimation(gui, tbound));
		titleAnimationTimer.start();

	}

	public void stopAnimateTitle() {
		titleAnimationTimer.stop();
	}
      
	//Animation to move the title screen up and down
	private Action titleAnimation(GUI gui, Rectangle tbound) {
		return new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				gui.titleNameLabel.setBounds(tbound.x, tbound.y + ty, tbound.width, tbound.height);

				if (ty == -10) {
					trise = true;
				}

				if (ty == 10) {
					trise = false;

				}

				if (trise) {
					ty++;
					ttime = 50;
				} else {
					ty--;
					ttime = 200;
				}

			}
		};
	}
}

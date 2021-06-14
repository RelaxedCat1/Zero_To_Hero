import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;

public class CutScene implements ActionListener {

	GUI gui;
	ChoiceActionHandler caHandler;
	boolean doOnce = true;
	ArrayList<String> sequenceList;
	ListIterator<String> sequenceIterator;
	String text = "";
	Timer textTimer;

	public CutScene(GUI gui, ChoiceActionHandler caHandler) {
		this.gui = gui;
		this.caHandler = caHandler;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String command = e.getActionCommand();

		if (doOnce) {
			readSequence();
			doOnce = false;
		}

		if (command.contains("next")) {

			if (sequenceIterator.hasNext()) {
				//Using Java UTIL timer to iterate text characters to simulate animation.
				Timer textTimer = new Timer();
				text = (String) sequenceIterator.next();

				TimerTask textAnimation = new TimerTask() {

					String displayMessage = "";
					int index = 0;

					public void run() {
						gui.csNext.setEnabled(false);
						if (index < text.length()) {
							displayMessage += text.charAt(index);
							gui.csTextArea.setText(displayMessage);
						} else {
							gui.csNext.setEnabled(true);
							textTimer.cancel();
						}
						index++;
					};
				};

				textTimer.scheduleAtFixedRate(textAnimation, 0, 10);

				if (sequenceIterator.nextIndex() == 7) {
					gui.csImage.setIcon(new ImageIcon("images/FORTUNA.gif"));
				}
			}

			if (!sequenceIterator.hasNext()) {
				gui.csNext.setText("Go");
				gui.csNext.addActionListener(caHandler);
				gui.csNext.setActionCommand("go");
			}

		}

	}

	// Reading and storing the Lines of the Cut scene Text
	public void readSequence() {

		sequenceList = new ArrayList<String>();
		String currentSequence = "";

		try {
			BufferedReader sequence = new BufferedReader(new FileReader("Cutscene.txt"));

			while (currentSequence != null) {
				currentSequence = sequence.readLine();

				if (currentSequence == null) {
					break;
				}
				sequenceList.add(currentSequence);
			}

			sequence.close();

			sequenceIterator = sequenceList.listIterator();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

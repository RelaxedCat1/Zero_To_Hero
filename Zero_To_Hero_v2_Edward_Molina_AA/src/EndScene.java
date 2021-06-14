
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

public class EndScene {
	/*
	 * This class uses both Java UTil and Swing Timer; Swing Timer to change the
	 * sequence and UTil Timer to do a basic task of iterating characters to
	 * simulate animation
	 */

	GUI gui;
	ChoiceActionHandler caHandler;

	boolean doOnce = true;
	ArrayList<String> sequenceList;
	ListIterator<String> sequenceIterator;
	Timer textTimer = new Timer(0, null);
	Timer sequenceTimer = new Timer(0, null);
	int counter = 0;
	Sound sound;

	public EndScene(GUI gui, ChoiceActionHandler caHandler, Sound sound) {
		this.gui = gui;
		this.caHandler = caHandler;
		this.sound = sound;
	}

	public void startTimer() {
	    
		sound.setEndingSound();
		sound.startEndingSound(); 
		Timer sequenceTimer = new Timer(0, sequence(gui));
		sequenceTimer.start();
		sequenceTimer.setDelay(7000);

	}

	// Action to proceed to the next sequence
	private Action sequence(GUI gui) {
		return new AbstractAction() {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (doOnce) {
					readSequence();
					doOnce = false;
				}

				if (sequenceIterator.hasNext()) {
					// Swing Timer to Animate Text.
					String text = (String) sequenceIterator.next();
					// gui.esTextArea.setText((String) sequenceIterator.next());
					textTimer = new Timer(100, textAnimation(gui, text));
					textTimer.start();

				}

				if (!sequenceIterator.hasNext()) {
					if (counter < 1) {
						gui.esTextArea.setVisible(false);
						gui.motherFortunaLabel.setVisible(true);
					}

					if (counter == 1) {
						gui.motherFortunaLabel.setVisible(false);
						gui.esTextArea.setVisible(true);
						gui.goToTitleButton.setVisible(true);
						gui.esTextArea.setText(
								"\n\n  Zero To Hero (2021) a game made by Edward Molina\n\n  Made with effort and love. Thank you for playing!");
						sequenceTimer.stop();
					}

					counter++;

				}

			};
		};
	}

	// Action to animate text by iterating characters.
	private Action textAnimation(GUI gui, String text) {
		return new AbstractAction() {

			String displayMessage = "";
			int index = 0;

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {

				if (index < text.length()) {
					displayMessage += text.charAt(index);
					gui.esTextArea.setText(displayMessage);
				} else {
					index = 0;
					displayMessage = "";
					textTimer.stop();
				}

				index++;

			};
		};
	}

	// To read the sequence of Endscene.txt
	public void readSequence() {

		sequenceList = new ArrayList<String>();
		String currentSequence = "";

		try {
			BufferedReader sequence = new BufferedReader(new FileReader("Endscene.txt"));

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

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.*;

public class Sound {

	File file = new File("sounds/Zero To Hero.wav");
	File battleFile = new File("sounds/battle music.wav");
	File endingFile = new File("sounds/Ending Music.wav");
	Clip battleClip;
	Clip endingClip;
	Clip clip;

	// setting background sound for title
	public void setBackgroundSound() {
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioStream);

		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startBSound() {
		clip.start();
	}

	public void stopBSound() {
		clip.close();
	}

	// Setting Background Sound for Battle
	public void setBattleSound() {
		AudioInputStream audioStream;
		try {
			audioStream = AudioSystem.getAudioInputStream(battleFile);
			battleClip = AudioSystem.getClip();
			battleClip.open(audioStream);

		} catch (UnsupportedAudioFileException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void startBattleSound() {
		battleClip.start();
	

	}

	public void stopBattleSound() {
		battleClip.stop();
		battleClip.close();
	}
	
	// Setting Background Sound for Ending
		public void setEndingSound() {
			AudioInputStream audioStream;
			try {
				audioStream = AudioSystem.getAudioInputStream(endingFile);
				endingClip = AudioSystem.getClip();
				endingClip.open(audioStream);

			} catch (UnsupportedAudioFileException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LineUnavailableException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void startEndingSound() {
			endingClip.start();
		

		}

		public void stopEndingSound() {
			endingClip.stop();
			endingClip.close();
		}
	
	
	
	
	

}

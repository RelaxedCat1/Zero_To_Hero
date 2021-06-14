import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoiceActionHandler implements ActionListener {

	ZeroToHeroMain mainGame;
	CutScene cs;
	Sound sound;

	// The Constructor that accepts the ZeroToHeroMain class
	public ChoiceActionHandler(ZeroToHeroMain g, Sound s) {
		mainGame = g;
		sound = s;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Getting the player's choice
		String playerChoice = e.getActionCommand();

		// Creating Logic on where the game progresses

		switch (playerChoice) {
		case "title ending":
			mainGame.screentr.showTitleMenuScreen();
			mainGame.animation.startAnimateTitle(mainGame.gui);
			sound.setBackgroundSound();
			sound.startBSound();
			sound.stopEndingSound();
			break;
		case "title":
			mainGame.screentr.showTitleMenuScreen();
			mainGame.animation.startAnimateTitle(mainGame.gui);
			sound.setBackgroundSound();
			sound.startBSound();
			break;
		case "settings":
			mainGame.screentr.showSettings();
			mainGame.animation.stopAnimateTitle();
			break;
		case "set name":
			mainGame.db.writeStoredData();
			mainGame.db.retrieveStoredData();
			mainGame.screentr.showTitleMenuScreen();
			break;
		case "Start Game":
			mainGame.animation.stopAnimateTitle();
			sound.stopBSound();
			mainGame.screentr.showCutScene();
			break;
		case "go":
			mainGame.screentr.showGameScreen();
			mainGame.story.startingPoint();
			break;
		case "choice1":
			mainGame.story.storyPosition(mainGame.c1NextPosition);
			break;
		case "choice2":
			mainGame.story.storyPosition(mainGame.c2NextPosition);
			break;
		case "choice3":
			mainGame.story.storyPosition(mainGame.c3NextPosition);
			break;
		case "choice4":
			mainGame.story.storyPosition(mainGame.c4NextPosition);
			break;

		}

	}

}

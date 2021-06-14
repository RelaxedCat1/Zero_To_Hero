public class ZeroToHeroMain {

	/*
	 * Created by Edward Molina A Game made with love, effort and hard work Due to
	 * limited time and manpower, the game is not yet great however, it is complete.
	 * An Alternative Assessment for the last quarter
	 */

	// Instantiate Classes
	GUI gui = new GUI();
	Sound sound = new Sound();
	Animation animation = new Animation();
	Database db = new Database(gui);
	ChoiceActionHandler caHandler = new ChoiceActionHandler(this, sound);
	ScreenTransitioner screentr = new ScreenTransitioner(gui);
	CutScene cs = new CutScene(gui, caHandler);
	EndScene es = new EndScene(gui, caHandler, sound);
	Story story = new Story(this, gui, screentr);

	String c1NextPosition, c2NextPosition, c3NextPosition, c4NextPosition;

	public static void main(String[] args) {
		new ZeroToHeroMain();
	}

	public ZeroToHeroMain() {

		sound.setBackgroundSound();
		sound.startBSound();
		gui.createGUI(caHandler, cs);
		animation.startAnimateTitle(gui);
		story.settingDefaults();
		db.retrieveStoredData();
		screentr.showTitleMenuScreen();

	}

}

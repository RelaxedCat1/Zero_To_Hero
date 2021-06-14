
public class ScreenTransitioner {

	GUI gui;

	public ScreenTransitioner(GUI ui) {
		gui = ui;
	}

	public void showDeathScene() {
		// Hiding the components of the title menu
		gui.titlePanel.setVisible(false);
		gui.welcomePanel.setVisible(false);
		gui.titleButtonsPanel.setVisible(false);

		// Hiding Settings Screen
		gui.settingsPanel.setVisible(false);

		// Hiding Cut scene Components
		gui.csTextPanel.setVisible(false);
		gui.csImagePanel.setVisible(false);

		// Hiding Game Component
		gui.dialoguePanel.setVisible(false);
		gui.choiceButtonPanel.setVisible(false);
		gui.playerPanel.setVisible(false);
		gui.imagePanel.setVisible(false);

		// Showing Death Scene
		gui.deathLabel.setVisible(true);
		gui.reasonOfDeathTextArea.setVisible(true);
		gui.deathTimerLabel.setVisible(true);

		// Hiding End Scene
		gui.esTextArea.setVisible(false);
	}

	public void showTitleMenuScreen() {

		// Showing the components of the title menu
		gui.titlePanel.setVisible(true);
		gui.welcomePanel.setVisible(true);
		gui.titleButtonsPanel.setVisible(true);

		// Hiding Settings Screen
		gui.settingsPanel.setVisible(false);

		// Hiding Cut scene Components
		gui.csTextPanel.setVisible(false);
		gui.csImagePanel.setVisible(false);

		// Hiding Game Component
		gui.dialoguePanel.setVisible(false);
		gui.choiceButtonPanel.setVisible(false);
		gui.playerPanel.setVisible(false);
		gui.imagePanel.setVisible(false);

		// Hiding Death Scene
		gui.deathLabel.setVisible(false);
		gui.reasonOfDeathTextArea.setVisible(false);
		gui.deathTimerLabel.setVisible(false);

		// Hiding End Scene
		gui.esTextArea.setVisible(false);
		gui.goToTitleButton.setVisible(false);
		gui.motherFortunaLabel.setVisible(false);

	}

	public void showSettings() {
		// Hiding the components of the title menu
		gui.titlePanel.setVisible(false);
		gui.welcomePanel.setVisible(false);
		gui.titleButtonsPanel.setVisible(false);

		// Showing Settings Screen
		gui.settingsPanel.setVisible(true);

		// Hiding Cut scene Components
		gui.csTextPanel.setVisible(false);
		gui.csImagePanel.setVisible(false);

		// Hiding Game Component
		gui.dialoguePanel.setVisible(false);
		gui.choiceButtonPanel.setVisible(false);
		gui.playerPanel.setVisible(false);
		gui.imagePanel.setVisible(false);

		// Hiding Death Scene
		gui.deathLabel.setVisible(false);
		gui.reasonOfDeathTextArea.setVisible(false);
		gui.deathTimerLabel.setVisible(false);

		// Hiding End Scene
		gui.esTextArea.setVisible(false);

	}

	public void showCutScene() {
		// Hiding the components of the title menu
		gui.titlePanel.setVisible(false);
		gui.welcomePanel.setVisible(false);
		gui.titleButtonsPanel.setVisible(false);

		// Hiding Settings Screen
		gui.settingsPanel.setVisible(false);

		// Showing Cut scene Components
		gui.csTextPanel.setVisible(true);
		gui.csImagePanel.setVisible(true);

		// Hiding Game Component
		gui.dialoguePanel.setVisible(false);
		gui.choiceButtonPanel.setVisible(false);
		gui.playerPanel.setVisible(false);
		gui.imagePanel.setVisible(false);

		// Hiding Death Scene
		gui.deathLabel.setVisible(false);
		gui.reasonOfDeathTextArea.setVisible(false);
		gui.deathTimerLabel.setVisible(false);

		// Hiding End Scene
		gui.esTextArea.setVisible(false);

	}

	public void showGameScreen() {
		// Hiding the components of the title menu
		gui.titlePanel.setVisible(false);
		gui.welcomePanel.setVisible(false);
		gui.titleButtonsPanel.setVisible(false);

		// Hiding Settings Screen
		gui.settingsPanel.setVisible(false);

		// Hiding Cut scene Components
		gui.csTextPanel.setVisible(false);
		gui.csImagePanel.setVisible(false);

		// Showing Game Component
		gui.dialoguePanel.setVisible(true);
		gui.choiceButtonPanel.setVisible(true);
		gui.playerPanel.setVisible(true);
		gui.imagePanel.setVisible(true);

		// Hiding Death Scene
		gui.deathLabel.setVisible(false);
		gui.reasonOfDeathTextArea.setVisible(false);
		gui.deathTimerLabel.setVisible(false);

		// Hiding End Scene
		gui.esTextArea.setVisible(false);

	}

	public void showEndScreen() {
		// Hiding the components of the title menu
		gui.titlePanel.setVisible(false);
		gui.welcomePanel.setVisible(false);
		gui.titleButtonsPanel.setVisible(false);

		// Hiding Settings Screen
		gui.settingsPanel.setVisible(false);

		// Hiding Cut scene Components
		gui.csTextPanel.setVisible(false);
		gui.csImagePanel.setVisible(false);

		// Hiding Game Component
		gui.dialoguePanel.setVisible(false);
		gui.choiceButtonPanel.setVisible(false);
		gui.playerPanel.setVisible(false);
		gui.imagePanel.setVisible(false);

		// Hiding Death Scene
		gui.deathLabel.setVisible(false);
		gui.reasonOfDeathTextArea.setVisible(false);
		gui.deathTimerLabel.setVisible(false);

		// Showing End Scene
		gui.esTextArea.setVisible(true);

	}

	// Setting the images to be displayed in the imagePanel
	public void showFortuna() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(true);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showTree() {
		gui.treeGraphics.setVisible(true);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showStick() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(true);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showBaby() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(true);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showTiyanak() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(true);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showBackBiter() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(true);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showHouse() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(true);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showMonsterHunter() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(true);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showSlime() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(true);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showMagmaCube() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(true);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showForest() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(true);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showTreeMonster() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(true);
		gui.shinigamiRoachLabel.setVisible(false);
	}

	public void showShinigamiRoach() {
		gui.treeGraphics.setVisible(false);
		gui.stickGraphics.setVisible(false);
		gui.fortunaLabel.setVisible(false);
		gui.babyLabel.setVisible(false);
		gui.tiyanakLabel.setVisible(false);
		gui.backBiterGraphics.setVisible(false);
		gui.monsterHunterLabel.setVisible(false);
		gui.houseGraphics.setVisible(false);
		gui.slimeGraphics.setVisible(false);
		gui.magmaCubeGraphics.setVisible(false);
		gui.forestLabel.setVisible(false);
		gui.treeMonsterLabel.setVisible(false);
		gui.shinigamiRoachLabel.setVisible(true);
	}

}

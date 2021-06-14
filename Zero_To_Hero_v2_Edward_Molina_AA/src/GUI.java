import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java_graphics.Backbiter;
import java_graphics.House;
import java_graphics.MagmaCube;
import java_graphics.Slime;
import java_graphics.Stick;
import java_graphics.Tree;
    
public class GUI {
	// Universal Themes
	Font titleFont = new Font("Impact", Font.PLAIN, 90);
	Font subtitleFont = new Font("Impact", Font.PLAIN, 40);
	Font secondaryTitleFont = new Font("Arial Black", Font.PLAIN, 80);
	Font accentFont = new Font("Impact", Font.PLAIN, 28);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);

	Color background = new Color(25, 25, 112);
	Color accent = new Color(0, 0, 51);
	Color secondary = new Color(0, 0, 153);

	JFrame window;
	JPanel titlePanel, titleButtonsPanel, welcomePanel, csTextPanel, csImagePanel, dialoguePanel, choiceButtonPanel,
			playerPanel, imagePanel, settingsPanel, settingsButtonPanel;
	JPanel treeGraphics, stickGraphics, backBiterGraphics, houseGraphics, slimeGraphics, magmaCubeGraphics;
	JLabel titleNameLabel, subtitleNameLabel, welcomeLabel, csImage, hpLabel, weaponLabel, moneyLabel, deathLabel,
			deathTimerLabel, fortunaLabel, babyLabel, tiyanakLabel, monsterHunterLabel, shinigamiRoachLabel,
			forestLabel, treeMonsterLabel, motherFortunaLabel;
	JButton goToTitle, exitButton, changeNameButton, csNext, choice1, choice2, choice3, choice4, enterNameButton,
			backButton, startButton, goToTitleButton;
	JTextField enterNameTextField;
	JTextArea csTextArea, dialogueTextArea, reasonOfDeathTextArea, esTextArea;

	public GUI() {
		// Creating The Window Frame
		window = new JFrame();
		window.setSize(900, 700);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(background);
		window.setLayout(null);
		window.setLocationRelativeTo(null);
		window.setResizable(false);
		window.setTitle("Zero To Hero");

	}

	public void createGUI(ChoiceActionHandler caHandler, CutScene csHandler) {
		// Creating Zero To Hero Title Screen
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 50, 700, 250);
		titlePanel.setBackground(accent);
		titlePanel.setBorder(new LineBorder(new Color(255, 255, 255), 5));

		titleNameLabel = new JLabel("Zero To Hero");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);

		subtitleNameLabel = new JLabel("- Edward Molina - ");
		subtitleNameLabel.setForeground(Color.white);
		subtitleNameLabel.setFont(subtitleFont);

		welcomePanel = new JPanel();
		welcomePanel.setBounds(100, 325, 700, 50);
		welcomePanel.setBackground(accent);

		welcomeLabel = new JLabel("Welcome Player!");
		welcomeLabel.setForeground(Color.white);
		welcomeLabel.setFont(accentFont);

		titleButtonsPanel = new JPanel();
		titleButtonsPanel.setBounds(300, 400, 300, 200);
		titleButtonsPanel.setBackground(background);
		titleButtonsPanel.setLayout(new GridLayout(3, 1, 10, 10));

		startButton = new JButton("Start Game");
		startButton.setBackground(accent);
		startButton.setForeground(Color.white);
		startButton.setFont(accentFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(caHandler);
		startButton.setActionCommand("Start Game");

		changeNameButton = new JButton("Change Name");
		changeNameButton.setBackground(accent);
		changeNameButton.setForeground(Color.white);
		changeNameButton.setFont(accentFont);
		changeNameButton.setFocusPainted(false);
		changeNameButton.addActionListener(caHandler);
		changeNameButton.setActionCommand("settings");

		exitButton = new JButton("Exit Game");
		exitButton.setBackground(accent);
		exitButton.setForeground(Color.white);
		exitButton.setFont(accentFont);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		titlePanel.add(titleNameLabel);
		titlePanel.add(subtitleNameLabel);
		welcomePanel.add(welcomeLabel);
		titleButtonsPanel.add(startButton);
		titleButtonsPanel.add(changeNameButton);
		titleButtonsPanel.add(exitButton);

		window.add(titlePanel);
		window.add(welcomePanel);
		window.add(titleButtonsPanel);

		// Creating The CUTSCENE
		csImagePanel = new JPanel();
		csImagePanel.setBounds(300, 50, 300, 300);
		csImagePanel.setBackground(background);

		csImage = new JLabel();
		csImage.setIcon(new ImageIcon("images/AKIRA.png"));

		csTextPanel = new JPanel();
		csTextPanel.setBounds(100, 400, 700, 150);
		csTextPanel.setBackground(accent);
		csTextPanel.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		csTextPanel.setLayout(null);

		csTextArea = new JTextArea("AKIRA: My Name is Akira");
		csTextArea.setForeground(Color.white);
		csTextArea.setBackground(accent);
		csTextArea.setFont(normalFont);
		csTextArea.setBounds(50, 20, 600, 75);
		csTextArea.setWrapStyleWord(true);
		csTextArea.setLineWrap(true);
		csTextArea.setEditable(false);

		csNext = new JButton("Next");
		csNext.setBounds(575, 100, 100, 40);
		csNext.setForeground(Color.white);
		csNext.setBackground(accent);
		csNext.setFont(normalFont);
		csNext.setFocusPainted(false);
		csNext.addActionListener(csHandler);
		csNext.setActionCommand("next");

		csImagePanel.add(csImage);
		csTextPanel.add(csTextArea);
		csTextPanel.add(csNext);

		window.add(csImagePanel);
		window.add(csTextPanel);

		// Creating Player Settings Panel
		settingsPanel = new JPanel();
		settingsPanel.setBounds(67, 50, 774, 580);
		settingsPanel.setBackground(accent);
		settingsPanel.setLayout(null);

		enterNameTextField = new JTextField();
		enterNameTextField.setForeground(new Color(255, 255, 255));
		enterNameTextField.setBackground(new Color(72, 61, 139));
		enterNameTextField.setHorizontalAlignment(SwingConstants.CENTER);
		enterNameTextField.setBounds(30, 187, 715, 135);
		enterNameTextField.setFont(new Font("Impact", Font.PLAIN, 50));

		enterNameButton = new JButton("ENTER NAME");
		enterNameButton.setFocusPainted(false);
		enterNameButton.setForeground(new Color(255, 255, 255));
		enterNameButton.setBackground(new Color(25, 25, 112));
		enterNameButton.setBounds(265, 359, 242, 66);
		enterNameButton.setFont(accentFont);
		enterNameButton.addActionListener(caHandler);
		enterNameButton.setActionCommand("set name");

		backButton = new JButton("BACK");
		backButton.setFocusPainted(false);
		backButton.setForeground(new Color(255, 255, 255));
		backButton.setBackground(new Color(25, 25, 112));
		backButton.setBounds(10, 11, 163, 66);
		backButton.setFont(accentFont);
		backButton.addActionListener(caHandler);
		backButton.setActionCommand("title");

		settingsPanel.add(enterNameTextField);
		settingsPanel.add(backButton);
		settingsPanel.add(enterNameButton);

		window.add(settingsPanel);

		// Creating Game Panel

		// Panel Where Player Information is displayed
		playerPanel = new JPanel();
		playerPanel.setBounds(25, 15, 845, 100);
		playerPanel.setBackground(background);
		playerPanel.setLayout(new GridLayout(2, 4, 10, 10));

		hpLabel = new JLabel("HP: ");
		hpLabel.setFont(accentFont);
		hpLabel.setForeground(Color.white);

		moneyLabel = new JLabel("Money: ");
		moneyLabel.setFont(accentFont);
		moneyLabel.setForeground(Color.white);

		weaponLabel = new JLabel("Current Weapon: ");
		weaponLabel.setFont(accentFont);
		weaponLabel.setForeground(Color.white);

		// The DialogueBox
		dialoguePanel = new JPanel();
		dialoguePanel.setLayout(null);
		dialoguePanel.setBounds(284, 154, 572, 250);
		dialoguePanel.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		dialoguePanel.setBackground(accent);

		dialogueTextArea = new JTextArea("This is where the Dialogues Go");
		dialogueTextArea.setBounds(10, 11, 552, 228);
		dialogueTextArea.setBackground(accent);
		dialogueTextArea.setForeground(Color.white);
		dialogueTextArea.setFont(normalFont);
		dialogueTextArea.setLineWrap(true);
		dialogueTextArea.setWrapStyleWord(true);
		dialogueTextArea.setEditable(false);

		// Panel Where Choices are displayed
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(284, 451, 367, 184);
		choiceButtonPanel.setBackground(background);
		choiceButtonPanel.setLayout(new GridLayout(4, 1, 10, 10));

		choice1 = new JButton("Choice 1");
		choice1.setBackground(background);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(caHandler);
		choice1.setActionCommand("choice1");

		choice2 = new JButton("Choice 2");
		choice2.setBackground(background);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(caHandler);
		choice2.setActionCommand("choice2");

		choice3 = new JButton("Choice 3");
		choice3.setBackground(background);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(caHandler);
		choice3.setActionCommand("choice3");

		choice4 = new JButton("Choice 4");
		choice4.setBackground(background);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(caHandler);
		choice4.setActionCommand("choice4");

		// This is the visual panel of the story
		imagePanel = new JPanel();
		imagePanel.setBounds(36, 168, 233, 222);
		imagePanel.setBackground(accent);

		// Setting the images to be displayed
		fortunaLabel = new JLabel();
		fortunaLabel.setIcon(new ImageIcon("images/Resized Fortuna.gif"));
		fortunaLabel.setVisible(false);

		babyLabel = new JLabel();
		babyLabel.setIcon(new ImageIcon("images/baby.png"));
		babyLabel.setVisible(false);

		tiyanakLabel = new JLabel();
		tiyanakLabel.setIcon(new ImageIcon("images/TIYANAK.png"));
		tiyanakLabel.setVisible(false);

		monsterHunterLabel = new JLabel();
		monsterHunterLabel.setIcon(new ImageIcon("images/Monster Hunter.png"));
		monsterHunterLabel.setVisible(false);

		shinigamiRoachLabel = new JLabel();
		shinigamiRoachLabel.setIcon(new ImageIcon("images/SHINIGAMI ROACH.gif"));
		shinigamiRoachLabel.setVisible(false);

		forestLabel = new JLabel();
		forestLabel.setIcon(new ImageIcon("images/Forest.png"));
		forestLabel.setVisible(false);

		treeMonsterLabel = new JLabel();
		treeMonsterLabel.setIcon(new ImageIcon("images/Tree Monster.png"));
		treeMonsterLabel.setVisible(false);

		treeGraphics = new Tree();
		treeGraphics.setBounds(0, 0, 233, 222);
		treeGraphics.setVisible(false);

		stickGraphics = new Stick();
		stickGraphics.setBounds(0, 0, 233, 222);
		stickGraphics.setVisible(false);

		backBiterGraphics = new Backbiter();
		backBiterGraphics.setBounds(0, 0, 233, 222);
		backBiterGraphics.setVisible(false);

		houseGraphics = new House();
		houseGraphics.setBounds(0, 0, 233, 222);
		houseGraphics.setVisible(false);

		slimeGraphics = new Slime();
		slimeGraphics.setBounds(0, 0, 233, 222);
		slimeGraphics.setVisible(false);

		magmaCubeGraphics = new MagmaCube();
		magmaCubeGraphics.setBounds(0, 0, 233, 222);
		magmaCubeGraphics.setVisible(false);

		imagePanel.add(fortunaLabel);
		imagePanel.add(babyLabel);
		imagePanel.add(tiyanakLabel);
		imagePanel.add(monsterHunterLabel);
		imagePanel.add(treeGraphics);
		imagePanel.add(stickGraphics);
		imagePanel.add(backBiterGraphics);
		imagePanel.add(houseGraphics);
		imagePanel.add(slimeGraphics);
		imagePanel.add(magmaCubeGraphics);
		imagePanel.add(forestLabel);
		imagePanel.add(treeMonsterLabel);
		imagePanel.add(shinigamiRoachLabel);

		playerPanel.add(hpLabel);
		playerPanel.add(moneyLabel);
		playerPanel.add(weaponLabel);

		dialoguePanel.add(dialogueTextArea);

		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);

		window.add(playerPanel);
		window.add(dialoguePanel);
		window.add(choiceButtonPanel);
		window.add(imagePanel);

		// Creating the scene when user dies
		deathLabel = new JLabel("YOU ARE DEAD!");
		deathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deathLabel.setBackground(background);
		deathLabel.setForeground(Color.WHITE);
		deathLabel.setFont(titleFont);
		deathLabel.setBounds(135, 51, 625, 157);

		reasonOfDeathTextArea = new JTextArea("You Cannot Escape Your Path");
		reasonOfDeathTextArea.setBackground(background);
		reasonOfDeathTextArea.setFont(normalFont);
		reasonOfDeathTextArea.setForeground(Color.white);
		reasonOfDeathTextArea.setBounds(204, 205, 500, 221);
		reasonOfDeathTextArea.setWrapStyleWord(true);
		reasonOfDeathTextArea.setLineWrap(true);
		reasonOfDeathTextArea.setEditable(false);

		deathTimerLabel = new JLabel("Death reversal begins in 5");
		deathTimerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		deathTimerLabel.setForeground(Color.WHITE);
		deathTimerLabel.setBounds(204, 467, 500, 115);
		deathTimerLabel.setFont(normalFont);

		window.add(deathLabel);
		window.add(reasonOfDeathTextArea);
		window.add(deathTimerLabel);
		
		motherFortunaLabel = new JLabel();
		motherFortunaLabel.setBackground(Color.BLUE);
		motherFortunaLabel.setBounds(238, 82, 400, 400);
		motherFortunaLabel.setIcon(new ImageIcon("images/MotherFortuna.png"));
		motherFortunaLabel.setVisible(false);

		goToTitleButton = new JButton("THE END");
		goToTitleButton.setBackground(background);
		goToTitleButton.setForeground(Color.white);
		goToTitleButton.setFont(accentFont);
		goToTitleButton.setFocusPainted(false);
		goToTitleButton.addActionListener(caHandler);
		goToTitleButton.setActionCommand("title ending");
		goToTitleButton.setBounds(330, 503, 216, 43);
        goToTitleButton.setVisible(false);
		
		esTextArea = new JTextArea();
		esTextArea.setBounds(82, 84, 728, 369);
		esTextArea.setFont(normalFont);
		esTextArea.setForeground(Color.white);
		esTextArea.setBackground(background);
		esTextArea.setFont(normalFont);
		esTextArea.setWrapStyleWord(true);
		esTextArea.setLineWrap(true);
		esTextArea.setEditable(false);
		
		
		window.add(esTextArea);
		window.add(goToTitleButton);
		window.add(motherFortunaLabel);

		window.setVisible(true);

	}

}

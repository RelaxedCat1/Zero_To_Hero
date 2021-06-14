import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import game_monsters.MagmaCube;
import game_monsters.Monster;
import game_monsters.ShinigamiRoach;
import game_monsters.Slime;
import game_monsters.Tiyanak;
import game_monsters.TreeMonster;
import game_weapons.Backbiter;
import game_weapons.Enma;
import game_weapons.Fist;
import game_weapons.Laputa;
import game_weapons.PlayerWeapon;
import game_weapons.Riptide;
import game_weapons.Stick;

public class Story {
	ZeroToHeroMain game;
	GUI gui;
	ScreenTransitioner screentr;
	Player player = new Player();
	Monster monster = new Monster();
	boolean isHouse = true, isBattle = false, isPlayOnce = true;

	int time = 5;

	public Story(ZeroToHeroMain g, GUI gu, ScreenTransitioner sc) {
		game = g;
		gui = gu;
		screentr = sc;
	}

	public void settingDefaults() {
		// Setting the default status of Player
		player.hp = 100;
		player.money = 0;
		player.name = "Player";
		player.currentWeapon = new Fist();
		time = 5;
		// Setting UI to these defaults
		gui.hpLabel.setText("HP: " + player.hp);
		gui.moneyLabel.setText("Money: " + player.money);
		gui.weaponLabel.setText("Weapon: " + player.currentWeapon.weaponName);
	}

	// Functions to get the position on where the story is progressing
	public void storyPosition(String nextPosition) {
		switch (nextPosition) {
		case "start":
			startingPoint();
			break;
		case "death":
			death("My Child, your HP was low.... Don't Worry You shall live again");
			break;
		case "win":
			attackWon();
			break;
		case "fight":
			fight();
			break;
		case "attack":
			attack();
			break;
		case "monster attack":
			monsterAttack();
			break;
		case "punch tree":
			punchTree();
			break;
		case "go near":
			tree();
			break;
		case "climb tree":
			climbTree();
			break;
		case "hang yourself":
			death("You cannot escape your path. Suicide is not an option");
			break;

		case "kill baby":
			killBaby();
			break;
		case "carry baby":
			carryBaby();
			break;

		case "house":
			house();
			break;
		case "in house":
			inHouse();
			break;
		case "monster hunter":
			monsterHunter();
			break;
		case "fully healed":
			fullyHealed();
			break;
		case "shop":
			shop();
			break;
		case "forest":
			forest();
			break;
		case "laputa":
			laputaSword();
			break;
		case "riptide":
			riptide();
			break;
		case "enma":
			enma();
			break;
		case "ending":
			ending();
			break;
		}

	}
    //Below are methods for the story
	public void death(String deathReason) {
		if (isBattle) {
			game.sound.stopBattleSound();
			isBattle = false;
			isPlayOnce = true;
		}

		Timer deathReversalTimer = new Timer();
		boolean isShow = true;

		if (isShow) {
			screentr.showDeathScene();
			gui.reasonOfDeathTextArea.setText(deathReason);
			isShow = false;
		}

		TimerTask deathReversalTimerTask = new TimerTask() {
			public void run() {
				if (time >= 0) {
					gui.deathTimerLabel.setText("Death Reversal Begins in " + time);
					time--;
				} else {
					settingDefaults();
					screentr.showGameScreen();
					startingPoint();
					deathReversalTimer.cancel();

				}
			};
		};

		deathReversalTimer.scheduleAtFixedRate(deathReversalTimerTask, 0, 1000);

	}

	public void fight() {
		isBattle = true;

		gui.dialogueTextArea.setText(monster.name + ": Hp: " + monster.hp + "\n\nReady to attack?");
		screentr.showFortuna();
		gui.choice1.setText("Attack");
		gui.choice2.setText("");
		if (!isHouse)
			gui.choice2.setText("Run");
		gui.choice3.setText("");
		gui.choice4.setText("");

		game.c1NextPosition = "attack";
		game.c2NextPosition = "";
		if (!isHouse)
			game.c2NextPosition = "monster hunter";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void attack() {

		if (isPlayOnce) {
			game.sound.setBattleSound();
			game.sound.startBattleSound();
		}

		isPlayOnce = false;

		screentr.showFortuna();
		int damage = new Random().nextInt(player.currentWeapon.weaponDamage + 1);
		monster.hp -= damage;
		gui.dialogueTextArea.setText("You attacked " + monster.name + " and dealt " + damage + " damage");

		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		if (monster.hp > 0) {
			game.c1NextPosition = "monster attack";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";
		} else if (monster.hp < 1) {
			game.c1NextPosition = "win";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";
		}

	}

	public void monsterAttack() {

		if (monster.name.equals("Tiyanak")) {
			screentr.showTiyanak();
		} else if (monster.name.equals("Slime")) {
			screentr.showSlime();
		} else if (monster.name.equals("Magma Cube")) {
			screentr.showMagmaCube();
		} else if (monster.name.equals("Tree Monster")) {
			screentr.showTreeMonster();
		} else if (monster.name.equals("Shinigami Roach")) {
			screentr.showShinigamiRoach();
		}

		int damage = new Random().nextInt(monster.attackDamage + 1);
		player.hp -= damage;
		gui.hpLabel.setText("HP: " + player.hp);

		gui.dialogueTextArea.setText(monster.attackMessage + damage + " damage");

		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		if (player.hp > 0) {
			game.c1NextPosition = "fight";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";
		} else if (player.hp < 1) {
			game.c1NextPosition = "death";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";
		}

	}

	public void attackWon() {
		game.sound.stopBattleSound();
		isPlayOnce = true;
		isBattle = false;

		if (monster.name.equals("Tiyanak")) {
			screentr.showBackBiter();
			player.currentWeapon = new Backbiter();
			gui.dialogueTextArea.setText("You defeated a " + monster.name
					+ "\n\nThe Monster Dropped Backbiter.\n\nLet's travel now my child it is getting late");
			gui.weaponLabel.setText("Weapon: " + player.currentWeapon.weaponName);

			gui.choice1.setText("Go Travel");
			gui.choice2.setText("");
			gui.choice3.setText("");

			game.c1NextPosition = "house";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";
		} else if (monster.name.equals("Slime") || monster.name.equals("Magma Cube")
				|| monster.name.equals("Tree Monster")) {
			// Setting Random Gold
			int randomGoldEarned = new Random().nextInt(monster.moneyEarned) + 25;
			String previousMoney = gui.moneyLabel.getText().replace("Money: ", "");
			int moneyEarned = Integer.parseInt(previousMoney) + randomGoldEarned;

			screentr.showMonsterHunter();

			gui.dialogueTextArea.setText(
					"You defeated a " + monster.name + "!" + " I will give you " + randomGoldEarned + " gold.");
			gui.moneyLabel.setText("Money: " + moneyEarned);

			gui.choice1.setText("Continue");
			gui.choice2.setText("");
			gui.choice3.setText("");

			game.c1NextPosition = "monster hunter";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";
		} else if (monster.name.equals("Shinigami Roach")) {
			gui.dialogueTextArea
					.setText("My Child I can see you! You are near... One more step and You can see me now.");

			gui.choice1.setText("Take a step further");
			gui.choice2.setText("");
			gui.choice3.setText("");

			game.c1NextPosition = "ending";
			game.c2NextPosition = "";
			game.c3NextPosition = "";
			game.c4NextPosition = "";

		}

	}

	public void startingPoint() {

		// The player starts at a tree.
		screentr.showTree();
		gui.dialogueTextArea.setText(
				"My Child, This is the tree where all things start.\n\nIt may be a simple tree, but it links the future and the past.");
		gui.choice1.setText("Punch tree");
		gui.choice2.setText("Go Near");
		gui.choice3.setText("Climb tree");
		gui.choice4.setText("Hang yourself");

		game.c1NextPosition = "punch tree";
		game.c2NextPosition = "go near";
		game.c3NextPosition = "climb tree";
		game.c4NextPosition = "hang yourself";

	}

	public void punchTree() {
		gui.dialogueTextArea.setText("Child... You are wasting your time.");
		screentr.showFortuna();
		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		game.c1NextPosition = "start";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void climbTree() {
		screentr.showStick();
		player.currentWeapon = new Stick();
		gui.weaponLabel.setText("Weapon: " + player.currentWeapon.weaponName);
		gui.dialogueTextArea.setText("My Child You Found A Stick!\n\nThis Weapon is better than your fist.");
		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		game.c1NextPosition = "start";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void tree() {
		screentr.showBaby();
		gui.dialogueTextArea.setText("A cute little baby is lying beside the tree.\nI wonder who are his parents");
		gui.choice1.setText("Carry Baby");
		gui.choice2.setText("Kill Baby");
		gui.choice3.setText("Go Back");
		gui.choice4.setText("");

		game.c1NextPosition = "carry baby";
		game.c2NextPosition = "kill baby";
		game.c3NextPosition = "start";
		game.c4NextPosition = "";
	}

	public void killBaby() {
		screentr.showFortuna();
		gui.dialogueTextArea.setText("My child... Good thing you killed it.\n\nIts true nature was a Tiyanak!");
		gui.choice1.setText("Go Travel");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		game.c1NextPosition = "house";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void carryBaby() {

		screentr.showTiyanak();
		monster = new Tiyanak();

		gui.dialogueTextArea.setText("The baby was actually a TIYANAK!!!\n\nBe Ready to Fight My Child.");
		gui.choice1.setText("Fight");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		game.c1NextPosition = "fight";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void house() {
		screentr.showHouse();
		gui.dialogueTextArea.setText(
				"We have traveled far... It is late.\n\nLook a house to stay!\n\nDo we stop by or continue to our journey finding your family?");
		gui.choice1.setText("Stop By");
		gui.choice2.setText("Continue Travelling");
		gui.choice3.setText("");
		gui.choice4.setText("");
		game.c1NextPosition = "in house";
		game.c2NextPosition = "forest";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void inHouse() {
		screentr.showMonsterHunter();
		gui.dialogueTextArea.setText(
				"Ah, A traveller! Just what I wanted.\n\nYou can stay for the night. I will also give you food for you to recuperate.");
		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");
		game.c1NextPosition = "fully healed";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void fullyHealed() {
		player.hp = 100;
		gui.hpLabel.setText("HP: " + player.hp);
		screentr.showFortuna();

		gui.dialogueTextArea
				.setText("You have been fully healed My child! Thanks to the friendly man.\n\nHP fully restored.");
		gui.choice1.setText("Thanks!");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");

		if (isHouse) {
			game.c1NextPosition = "monster hunter";
		} else {
			game.c1NextPosition = "forest";
		}

		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";

	}

	public void monsterHunter() {

		int chances = new Random().nextInt(101);

		if (chances >= 50) {
			monster = new Slime();
		} else if (chances <= 49 && chances >= 11) {
			monster = new MagmaCube();
		} else if (chances >= 0 && chances <= 10) {
			monster = new TreeMonster();
		}

		isHouse = false;

		screentr.showMonsterHunter();
		gui.dialogueTextArea.setText(
				"Here's the deal. I am a monster hunter so you can kill monsters for me in exhange for gold. You can use that gold to buy swords in my store.\n\nAnd if you are ready, You can heal for a while and continue your travels");
		gui.choice1.setText("Fight Monsters");
		gui.choice2.setText("Buy Swords");
		gui.choice3.setText("Continue Travelling");
		gui.choice4.setText("");

		gui.choice1.setEnabled(true);
		gui.choice2.setEnabled(true);
		gui.choice3.setEnabled(true);

		game.c1NextPosition = "fight";
		game.c2NextPosition = "shop";
		game.c3NextPosition = "fully healed";
		game.c4NextPosition = "";
	}

	// Weapons in the shop
	PlayerWeapon weapon1 = new Laputa();
	PlayerWeapon weapon2 = new Riptide();
	PlayerWeapon weapon3 = new Enma();

	public void shop() {

		int currentMoney = Integer.parseInt(gui.moneyLabel.getText().replace("Money: ", ""));

		screentr.showMonsterHunter();
		gui.dialogueTextArea.setText("My finest swords in the finest price!\n\nWhat Do You want to buy?");
		gui.choice1.setText(weapon1.weaponName + ": " + weapon1.weaponPrice + " gold");
		gui.choice2.setText(weapon2.weaponName + ": " + weapon2.weaponPrice + " gold");
		gui.choice3.setText(weapon3.weaponName + ": " + weapon3.weaponPrice + " gold");
		gui.choice4.setText("Go Back");

		if (currentMoney >= weapon1.weaponPrice) {
			gui.choice1.setEnabled(true);
		} else {
			gui.choice1.setEnabled(false);
		}

		if (currentMoney >= weapon2.weaponPrice) {
			gui.choice2.setEnabled(true);
		} else {
			gui.choice2.setEnabled(false);
		}

		if (currentMoney >= weapon3.weaponPrice) {
			gui.choice3.setEnabled(true);
		} else {
			gui.choice3.setEnabled(false);
		}

		game.c1NextPosition = "laputa";
		game.c2NextPosition = "riptide";
		game.c3NextPosition = "enma";
		game.c4NextPosition = "monster hunter";

	}

	// Transaction Logic
	public void transaction(int weaponPrice, String weaponName) {
		String previousMoney = gui.moneyLabel.getText().replace("Money: ", "");
		int currentMoney = Integer.parseInt(previousMoney) - weaponPrice;
		gui.moneyLabel.setText("Money: " + currentMoney);
		gui.weaponLabel.setText("Weapon: " + weaponName);
	}

	public void laputaSword() {
		// Show Laputa's Sword

		transaction(weapon1.weaponPrice, weapon1.weaponName);

		gui.dialogueTextArea.setText("Good Choice! An amazing sword from the sky! Laputa's Sword\n\n"
				+ "Attack Damage: " + weapon1.weaponDamage);
		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");
		game.c1NextPosition = "monster hunter";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void riptide() {
		// Show Riptide

		transaction(weapon2.weaponPrice, weapon2.weaponName);

		gui.dialogueTextArea
				.setText("The sword of the hero who killed Kronos. Percy Jackson's Riptide! Take Good Care.\n\n"
						+ "Attack Damage: " + weapon2.weaponDamage);
		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");
		game.c1NextPosition = "monster hunter";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void enma() {
		// show enma

		transaction(weapon3.weaponPrice, weapon3.weaponName);

		gui.dialogueTextArea.setText(
				"One of the legendary sword of Wano - Enma! My most powerful sword in my store. You earned it.\n\n"
						+ "Attack Damage: " + weapon3.weaponDamage);
		gui.choice1.setText("Continue");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");
		game.c1NextPosition = "monster hunter";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}

	public void forest() {
		monster = new ShinigamiRoach();
		screentr.showForest();
		gui.dialogueTextArea.setText(
				"I can sense your family in the forest... NO! DARK POWERS.... A CREATURE THAT LURKS IN THE DARK IS HERE!\n\nIf you continue you might find your family, but you have to fight this creature. Be prepared my child.");
		gui.choice1.setText("Continue to the Forest");
		gui.choice2.setText("");
		gui.choice3.setText("");
		gui.choice4.setText("");
		game.c1NextPosition = "fight";
		game.c2NextPosition = "";
		game.c3NextPosition = "";
		game.c4NextPosition = "";
	}
	
	public void ending() {
		screentr.showEndScreen();
		game.es.startTimer();
	}


}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Database {

	GUI gui;
	public String filePath = "D://ZeroToHero GameData.txt";

	public Database(GUI g) {
		gui = g;
	}

	// Function to Write Data
	void writeStoredData() {
		try {
			File data = new File(filePath);

			if (data.canWrite()) {
				BufferedWriter dataWriter = new BufferedWriter(new FileWriter(data));
				dataWriter.write(gui.enterNameTextField.getText());
				dataWriter.close();

			} else {
				JOptionPane.showMessageDialog(gui.window, "Cannot Write Data!");
			}

		} catch (IOException error) {
			JOptionPane.showMessageDialog(gui.window, "An Error Occured!");
			error.printStackTrace();
		}

	}

	// Function to read data
	void retrieveStoredData() {
		try {
			File data = new File(filePath);
			if (data.canRead()) {
				char[] content = new char[100];

				BufferedReader dataReader = new BufferedReader(new FileReader(data));
				dataReader.read(content);
				String name = String.valueOf(content).trim();

				gui.welcomeLabel.setText("Welcome " + name + "!");
				dataReader.close();
			} else {
				// Creates File with default data if File does not exist.
				data.createNewFile();
				BufferedWriter dataWriter = new BufferedWriter(new FileWriter(data));
				dataWriter.write("Player");
				dataWriter.close();
			}

		} catch (IOException error) {
			JOptionPane.showMessageDialog(gui.window, "An Error Occured!");
			error.printStackTrace();
		}

	}

}

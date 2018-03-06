package de.diamondCoding.scribbler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.*;

import javakarol.Roboter;
import javakarol.Welt;

public class Scribbler {

	//	/Users/florian/Development/temp/speicher.txt
	
	//Messages
	//ENG
	static String ENGnoAnswer = "This is not a valid answer.";
	static String ENGisSearchng = /* FileName */" is being searched...";
	static String ENGwasFound = /* FileName */" was found.";
	static String ENGFileMinimum1 = "The file is emty. Please choose an other one or type something into the file and enter the path again.";
	static String ENGFileMaximum64 = "The message in the file is too long. Please choose an other one or shorten the message in the file and enter the path again.";
	static String ENGFilewasntFount = /* FileName */" couldn't be found.";
	static String ENGdirectMinmal1 = "Your message needs to have at least one character.";
	static String ENGdirectMaximal64 = "Your message can only have 64 characters or less.";
	static String ENGgotMessage = "This message was faund: "/* Massage */;
	static String ENGFileOrDirect = "Please choose between using a File = F or entering the message directly = E";
	static String ENGenterDirectory = "Please enter the path of your file: ";
	static String ENGenterMessage = "Please enter the message: ";
	static String ENGfinishedWriting = "Finished writing.";
	static String ENGendingIn = "Programm ending in: "/* Sekunden */;
	static String ENGendingNow = "Programm ending now.";
	//DE
	static String DEnoAnswer = "Ungueltiche Antwort.";
	static String DEisSearchng = /* FileName */" wird gesucht...";
	static String DEwasFound = /* FileName */" wurde gefunden.";
	static String DEFileMinimum1 = "Die Datei ist leer. Bitte waehle eine andere Datei oder fuelle die Datei und gebe den den selben Speicherort erneut an.";
	static String DEFileMaximum64 = "Der Satz in der Datei darf maximal 64 Zeichen haben. Bitte waehle eine andere Datei oder kuerze den Satz und gebe den den selben Speicherort erneut an.";
	static String DEFilewasntFount = /* FileName */" konnte nicht gefunden werden! Bitte gebe einen gueltige Dateipfad an.";
	static String DEdirectMinmal1 = "Deine Nachricht muss mindestens ein Zeichen haben.";
	static String DEdirectMaximal64 = "Deine Nachricht darf maximal 64 Zeichen haben.";
	static String DEgotMessage = "Folgende Nachricht wurde erkannt: "/* Massage */;
	static String DEFileOrDirect = "Bitte waehle zwischen der Angabe eines Files = F oder der direkten Eingabe = E";
	static String DEenterDirectory = "Speicherort angeben: ";
	static String DEenterMessage = "Satz eingeben: ";
	static String DEfinishedWriting = "Schreiben fertig.";
	static String DEendingIn = "Programm wird beendet in: "/* Sekunden */;
	static String DEendingNow = "Programm wird jetzt beendet.";
	//Running
	static String noAnswer = "";
	static String isSearchng = /* FileName */"";
	static String wasFound = /* FileName */"";
	static String FileMinimum1 = "";
	static String FileMaximum64 = "";
	static String FilewasntFount = /* FileName */"";
	static String directMinmal1 = "";
	static String directMaximal64 = "";
	static String gotMessage = ""/* Massage */;
	static String FileOrDirect = "";
	static String enterDirectory = "";
	static String enterMessage = "";
	static String finishedWriting = "";
	static String endingIn = "";
	static String endingNow = "";
	
	static Welt welt;
	static Roboter Karol;
	
	static String message;
	static String[] carecters;
	static List<Buchstabe> buchstaben = new ArrayList<Buchstabe>();
	
	public static int size = 1;
	public static int buildingSize = 2;
	public static int buildingLine;
	
	public static void main(String[] args) {
  	
		System.out.println(" __                     ");
		System.out.println("(_  _  __ o |_  |_  |  _  __ v0.3");
		System.out.println("__)(_  |  | |_) |_) | (/_ | by Florian Fuhrmann and Sacha Conrads");
		System.out.println(" ");
		
		//playSound("music.wav");
		
		Scanner scanner = new Scanner(System.in);
		
		String language = waitForLanguage(scanner).toLowerCase();
		
		while (!(language.equalsIgnoreCase("e") || language.equalsIgnoreCase("d"))) {
			System.out.println("ENG: This is no Answer.");
			System.out.println("DE: Ungueltiche Antwoert.");
			language = waitForLanguage(scanner);
		}
		
		if(language.equalsIgnoreCase("e")) {
			noAnswer = ENGnoAnswer;
			isSearchng = ENGisSearchng;
			wasFound = ENGwasFound;
			FileMinimum1 = ENGFileMinimum1;
			FileMaximum64 = ENGFileMaximum64;
			FilewasntFount = ENGFilewasntFount;
			directMinmal1 = ENGdirectMinmal1;
			directMaximal64 = ENGdirectMaximal64;
			gotMessage = ENGgotMessage;
			FileOrDirect = ENGFileOrDirect;
			enterDirectory = ENGenterDirectory;
			enterMessage = ENGenterMessage;
			finishedWriting = ENGfinishedWriting;
			endingIn = ENGendingIn;
			endingNow = ENGendingNow;
		}
		else if(language.equalsIgnoreCase("d")) {
			noAnswer = DEnoAnswer;
			isSearchng = DEisSearchng;
			wasFound = DEwasFound;
			FileMinimum1 = DEFileMinimum1;
			FileMaximum64 = DEFileMaximum64;
			FilewasntFount = DEFilewasntFount;
			directMinmal1 = DEdirectMinmal1;
			directMaximal64 = DEdirectMaximal64;
			gotMessage = DEgotMessage;
			FileOrDirect = DEFileOrDirect;
			enterDirectory = DEenterDirectory;
			enterMessage = DEenterMessage;
			finishedWriting = DEfinishedWriting;
			endingIn = DEendingIn;
			endingNow = DEendingNow;
		} else {
			
		}
		
		String methode = waitForFile(scanner).toLowerCase();

		while (!(methode.equalsIgnoreCase("f") || methode.equalsIgnoreCase("e"))) {
			System.out.println(noAnswer);
			methode = waitForFile(scanner);
		}

		//FileWriter wf;
		File Datei = new File("");

		String fileName = "";
		
		boolean gettingDatei = true;
		while(methode.equalsIgnoreCase("f") && gettingDatei) {
			fileName = waitForFileName(scanner);
			Datei = new File(fileName);
			try {
				System.out.println(fileName + isSearchng);
				Scanner sc = new Scanner(Datei);
				while (sc.hasNextLine()) {
					String crLine = sc.nextLine();
					message = crLine.toLowerCase();
				}
				gettingDatei = false;
				System.out.println(fileName + wasFound);
				if(message.length() < 1) {
					gettingDatei = true;
					System.out.println(FileMinimum1);
				}
				if(message.length() > 64) {
					gettingDatei = true;
					System.out.println(FileMaximum64);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				System.out.println(fileName + FilewasntFount);
				gettingDatei = true;
			}
		}
		
		boolean gettingSentence = true;
		while(methode.equalsIgnoreCase("e") && gettingSentence) {
			String sentence = waitForSentence(scanner);
			message = sentence.toLowerCase();
			gettingSentence = false;
			if(sentence.length() < 1) {
				System.out.println(directMinmal1);
				gettingSentence = true;
			}
			if(sentence.length() > 64) {
				System.out.println(directMaximal64);
				gettingSentence = true;
			}
		}
		
		System.out.println(gotMessage + message);
		
		carecters = message.split("(?!^)");
		
		for(String car : carecters) {
			Buchstabe bust = new Buchstabe(car, null);
			buchstaben.add(bust);
		}
		
		for(Buchstabe bust : buchstaben) {
			size = size + bust.getWith();
		}
		
		welt = new Welt(size, 8, 8);
		Karol = new Roboter(welt);
		
		for(Buchstabe bust : buchstaben) {
			bust.setWorld(welt);
			bust.giveRoboter(Karol);
			bust.positionRoboter();
			bust.buildLetter();
			buildingSize+= bust.getWith();
		}
		
		System.out.println(finishedWriting);
		for(int i = 10; i > 0; i--) {
			System.out.println(endingIn + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("[Error] " + e.getMessage());
			}
		}
		System.out.println(endingNow);
		System.exit(-1);
		
	}
	
	public static String waitForLanguage(Scanner scanner ) {
		System.out.println("ENG: Please enter E for English.");
		System.out.println("DE: Bitte gebe fuer Deutsch D ein.");
		System.out.print("> ");
		String eingabe = scanner.nextLine();
		return eingabe;
	}
	
	public static String waitForFile(Scanner scanner ) {
		System.out.println(FileOrDirect);
		System.out.print("> ");
		String eingabe = scanner.nextLine();
		return eingabe;
	}
	
	public static String waitForFileName(Scanner scanner ) {
		System.out.println(enterDirectory);
		System.out.print("> ");
		String eingabe = scanner.nextLine();
		return eingabe;
	}
	
	public static String waitForSentence(Scanner scanner ) {
		System.out.println(enterMessage);
		System.out.print("> ");
		String eingabe = scanner.nextLine();
		return eingabe;
	}
	
	public static synchronized void playSound(final String url) {
		new Thread(new Runnable() {
			public void run() {
				try {
					Clip clip = AudioSystem.getClip();
					AudioInputStream inputStream;
					// inputStream = getClass().getResourceAsStream(url);
					inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(url));
					clip.open(inputStream);
					clip.start();
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}).start();
	}
	
}

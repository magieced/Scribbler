package de.diamondCoding.scribbler;

import javakarol.Roboter;
import javakarol.Welt;

public class Buchstabe {
	
	Roboter roboter;
	
	public Buchstabe(String letter, Welt world) {
		this.letter = letter;
		this.world = world;
	}
	
	String letter;
	Welt world;
	int line;
	int number;
	
	String getLetter() {
		return letter;
	}
	
	void setWorld(Welt world) {
		this.world = world;
	}
	
	void giveRoboter(Roboter robot) {
		roboter = robot;
		roboter.VerzoegerungSetzen(100);
	}
	
	void positionRoboter() {
		while(!roboter.IstBlickNorden()) {
			roboter.LinksDrehen();
		}
		while(!roboter.IstWand()) {
			roboter.Schritt();
		}
		roboter.LinksDrehen();
		roboter.LinksDrehen();
		while(roboter.PositionXGeben() != Scribbler.buildingSize) {
			if(roboter.PositionXGeben() < Scribbler.buildingSize) {
				roboter.LinksDrehen();
				while(roboter.PositionXGeben() != Scribbler.buildingSize) {
					roboter.Schritt();
				}
				roboter.RechtsDrehen();
			}
			if(roboter.PositionXGeben() > Scribbler.buildingSize) {
				roboter.RechtsDrehen();
				while(roboter.PositionXGeben() != Scribbler.buildingSize) {
					roboter.Schritt();
				}
				roboter.LinksDrehen();
			}
		}
	}
	
	Roboter getRoboter() {
		return roboter;
	}
	
	int getWith() {
		//Wer:          F F F F F F F S F  F S  F  F  F  S  F  F  F  S  S  S  S  F S  S   S  F  F  F  F  F  F  S                          F  F   
		//Nummer:       1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43     
		//Buchstabe:    a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z  .  !  ?  :  ,  1  2  3  4  5  6  7  8  9  0  /  =
		//Tatsaechlich: a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z  .  !  ?  :  ,  1                             /
		//Komentar(\/):                                                                                                            
		//P = Problem, I = In Arbeit
		if(letter.equals(" ")) {
			return 2;
		}
		else if(letter.equals(".")) {
			return 2;
		}
		else if(letter.equals(",")) {
			return 2;
		}
		else if(letter.equals(":")) {
			return 2;
		}
		else if(letter.equals("?")) {
			return 5;
		}
		else if(letter.equals("!")) {
			return 2;
		}
		else if(letter.equals("/")) {
			return 4;
		}
		else if(letter.equals("a")) {
			return 5;
		}
		else if(letter.equals("b")) {
			return 5;
		}
		else if(letter.equals("c")) {
			return 4;
		}
		else if(letter.equals("d")) {
			return 5;
		}
		else if(letter.equals("e")) {
			return 4;
		}
		else if(letter.equals("f")) {
			return 4;
		}
		else if(letter.equals("g")) {
			return 5;
		}
		else if(letter.equals("h")) {
			return 5;
		}
		else if(letter.equals("i")) {
			return 2;
		}
		else if(letter.equals("j")) {
			return 5;
		}
		else if(letter.equals("k")) {
			return 5;
		}
		else if(letter.equals("l")) {
			return 4;
		}
		else if(letter.equals("m")) {
			return 8;
		}
		else if(letter.equals("n")) {
			return 6;
		}
		else if(letter.equals("o")) {
			return 5;
		}
		else if(letter.equals("p")) {
			return 4;
		}
		else if(letter.equals("q")) {
			return 5;
		}
		else if(letter.equals("r")) {
			return 5;
		}
		else if(letter.equals("s")) {
			return 4;
		}
		else if(letter.equals("t")) {
			return 6;
		}
		else if(letter.equals("u")) {
			return 5;
		}
		else if(letter.equals("v")) {
			return 6;
		}
		else if(letter.equals("w")) {
			return 10;
		}
		else if(letter.equals("x")) {
			return 6;
		}
		else if(letter.equals("y")) {
			return 6;
		}
		else if(letter.equals("z")) {
			return 5;
		}
		else if(letter.equals("1")) {
			return 4;
		}
		return 0;
	}
	
	void buildLetter() {
		if(letter.equals(" ")) {

		}
		else if(letter.equals(".")) {
			for(int i = 4; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.Hinlegen();
		}
		else if(letter.equals(",")) {
			for(int i = 4; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals(":")) {
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("?")) {
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			for(int i = 4; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.RechtsDrehen();
			for(int i = 2; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.RechtsDrehen();
			for(int i = 2; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 2; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
		}
		else if(letter.equals("!")) {
			for(int i = 3; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("/")) {
			for(int i = 6; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			
			roboter.Hinlegen();
			roboter.Schritt();
			
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
		}
		else if(letter.equals("a")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("b")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Aufheben();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("c")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			for(int i = 4; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("d")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("e")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.RechtsDrehen();
				roboter.Hinlegen();
				roboter.Schritt();
				roboter.Hinlegen();
				roboter.LinksDrehen();
				roboter.LinksDrehen();
				roboter.Schritt();
				roboter.RechtsDrehen();
				roboter.Schritt();
				if(!(i == 1)) {
					roboter.Schritt();
				}
			}
		}
		else if(letter.equals("f")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if(letter.equals("g")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Hinlegen();
			for(int i = 2; i > 0; i--) {
				roboter.LinksDrehen();
				roboter.Schritt();
				roboter.RechtsDrehen();
				roboter.Hinlegen();
			}
		}
		else if (letter.equals("h")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
		}
		else if (letter.equals("i")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
		}
		else if (letter.equals("j")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
		}
		else if (letter.equals("k")) {
			for (int i = 0; i < 5; i++) {

				roboter.Hinlegen();
				roboter.Schritt();

			}

			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if (letter.equals("l")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 2; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
		}
		else if (letter.equals("m")) {

//			for (int i = 0; i < 5; i++) {
//
//				roboter.Hinlegen();
//				roboter.Schritt();
//
//			}
//
//			roboter.LinksDrehen();
//			roboter.Schritt();
//			roboter.Hinlegen();
//			roboter.LinksDrehen();
//			roboter.Schritt();
//			roboter.RechtsDrehen();
//			roboter.Hinlegen();
//			roboter.LinksDrehen();
//			roboter.Hinlegen();
//			roboter.Schritt();
//			roboter.Hinlegen();
//			roboter.Schritt();
//			roboter.RechtsDrehen();
//			roboter.Schritt();
//			roboter.Hinlegen();
//			roboter.RechtsDrehen();
//			roboter.Schritt();
//			roboter.LinksDrehen();
//			roboter.Hinlegen();
//			roboter.LinksDrehen();
//			roboter.Schritt();
//			roboter.Schritt();
//			roboter.Schritt();
//			roboter.RechtsDrehen();
//			roboter.Schritt();
//			roboter.Schritt();
//			roboter.RechtsDrehen();
//
//			for (int i = 0; i < 5; i++) {
//
//				roboter.Hinlegen();
//				roboter.Schritt();
//
//			}
			
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.LinksDrehen();
			for(int i = 6; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			
			roboter.LinksDrehen();
			
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Hinlegen();
			
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			
		}
		else if (letter.equals("n")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.LinksDrehen();
			for(int i = 4; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if (letter.equals("o")) {
			for (int i = 0; i < 5; i++) {

				roboter.Hinlegen();
				roboter.Schritt();

			}

			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();

			for (int i = 0; i < 4; i++) {

				roboter.Hinlegen();
				roboter.Schritt();

			}

			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
		}
		else if (letter.equals("p")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			for(int i = 2; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 2; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
		}
		else if (letter.equals("q")) {
			roboter.Schritt();
			for(int i = 2; i > 0; i--) {
				for(	int i2 = 4; i2 > 0; i2--) {
					roboter.Hinlegen();
					roboter.Schritt();
				}
				roboter.LinksDrehen();
				for(	int i2 = 3; i2 > 0; i2--) {
					roboter.Hinlegen();
					roboter.Schritt();
				}
				roboter.LinksDrehen();
			}
			for(int i = 4; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.RechtsDrehen();
			roboter.Hinlegen();
		}
		else if(letter.equals("r")) {
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Aufheben();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if (letter.equals("s")) {
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if (letter.equals("t")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			for (int i = 0; i < 4; i++) {

				roboter.Hinlegen();
				roboter.Schritt();

			}

			roboter.RechtsDrehen();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();

			for (int i = 0; i < 4; i++) {

				roboter.Hinlegen();
				roboter.Schritt();

			}

		}
		else if (letter.equals("u")) {
	          for(int i=0;i<5;i++)    {
	              
	              roboter.Hinlegen();
	              roboter.Schritt();
	              
	          }

	          roboter.LinksDrehen();
	          roboter.Hinlegen();
	          roboter.Schritt();
	          roboter.Hinlegen();
	          roboter.Schritt();
	          roboter.Hinlegen();
	          roboter.Schritt();
	          roboter.LinksDrehen();
	          
	          for(int i=0;i<4;i++) {
	              
	              roboter.Hinlegen();
	              roboter.Schritt();
	              
	          }
		}
		else if (letter.equals("v")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
		}
		else if (letter.equals("w")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
		}
		else if (letter.equals("x")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
		}
		else if (letter.equals("y")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.RechtsDrehen();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
		}
		else if (letter.equals("z")) {
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();

			for (int i = 0; i < 3; i++) {

				roboter.Hinlegen();
				roboter.Schritt();

			}

			roboter.LinksDrehen();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.RechtsDrehen();

			for (int i = 0; i < 3; i++) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
		}
		else if (letter.equals("1")) {
			for(int i = 6; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 3; i > 0; i--) {
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			for(int i = 5; i > 0; i--) {
				roboter.Hinlegen();
				roboter.Schritt();
			}
			roboter.LinksDrehen();
			roboter.Hinlegen();
			roboter.Schritt();
			roboter.LinksDrehen();
			roboter.Schritt();
			roboter.RechtsDrehen();
			roboter.Hinlegen();
		}
	}
	
}

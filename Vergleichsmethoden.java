package com.htlinn.pokeroop.winkler_pregenzer;

public class Vergleichsmethoden {

	public static void haeufigkeitCheck(int[] haeufigkeit, Karte[] karten, Karte[] gezogen) {
		if(counterMethode(1, karten, gezogen)) {
			haeufigkeit[0]++;
			if(twoPair(karten, gezogen)) {
				haeufigkeit[1]++;
			}
			if(counterMethode(2, karten, gezogen)) {
				haeufigkeit[2]++;
				if(fullHouse(karten, gezogen)) {
					haeufigkeit[5]++;
				}
				if(counterMethode(3, karten, gezogen)) {
					haeufigkeit[6]++;
					haeufigkeit[1]++;
				}
			}
		}
		if(flush(karten, gezogen)) {
			haeufigkeit[4]++;
		}
		if(straight(karten, gezogen)) {
			haeufigkeit[3]++;
			if(straightFlush(karten, gezogen)) {
				haeufigkeit[7]++;
				if(royalFlush(karten, gezogen)) {
					haeufigkeit[8]++;
				}
			}
		}
	}
	
	public static boolean counterMethode(int countervalue, Karte[] karten, Karte[] gezogen) {
		int card1;
		int card2;
		int counter = 0;

		for(int i = 0; i<gezogen.length; i++) {
			counter = 0;
			card1 = gezogen[i].getWert();
			for(int j = i+1; j<gezogen.length; j++) {
				card2 = gezogen[j].getWert();
				if(card1 == card2) {
					counter++;
					if(counter == countervalue) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean twoPair(Karte[] karten, Karte[] gezogen) {
		int pair = -1;
		for(int i = 0; i<gezogen.length; i++) {
			for(int j = i+1; j<gezogen.length; j++) {
				if(gezogen[i].getWert() == gezogen[j].getWert()) {
					pair = gezogen[i].getWert();
				}
			}
		}
		for(int i = 0; i<gezogen.length; i++) {
			for(int j = i+1; j<gezogen.length; j++) {
				if(gezogen[i].getWert() == gezogen[j].getWert() && gezogen[j].getWert() != pair) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean straight(Karte[] karten, Karte[] gezogen) {
		int lowestcard = 0;
		int highestcard = 0;

		if(counterMethode(1, karten, gezogen)) {
			return false;
		}
		for(int i = 0; i < gezogen.length; i++) {
			if(gezogen[i].getWert() < gezogen[lowestcard].getWert()) {
				lowestcard = i;
			}
			if(gezogen[i].getWert() > gezogen[highestcard].getWert()) {
				highestcard = i;
			}
		}
		if(lowestcard+4 == highestcard) {
			return true;
		}
		return false;
	}
	public static boolean flush(Karte[] karten, Karte[] gezogen) {
		int counter = 0;
		for(int i = 0; i<gezogen.length; i++) {
			counter = 0;
			for(int j = i+1; j<gezogen.length; j++) {
				if(gezogen[i].getFarbe() == gezogen[j].getFarbe()) {
					counter++;
					if(counter == 4) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public static boolean fullHouse(Karte[] karten, Karte[] gezogen) {
		if(twoPair(karten, gezogen)) {
			return true;
		}
		return false;
	}
	public static boolean straightFlush(Karte[] karten, Karte[] gezogen) {
		if(flush(karten,gezogen)) {
			return true;
		}
		return false;
	}
	public static boolean royalFlush(Karte[] karten, Karte[] gezogen) {

		int highestcard = 0;

		for(int i = 0; i < gezogen.length; i++) {
			if(gezogen[i].getWert() > gezogen[highestcard].getWert()) {
				highestcard = i;
			}
		}
		if(gezogen[highestcard].getWert() == ((karten.length/4)-1)) {
			return true;
		}
		return false;
	}
}

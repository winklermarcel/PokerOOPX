package com.htlinn.pokeroop.winkler_pregenzer;

import java.util.Random;

/**
 * 
 * @author Thomas Pregenzer & Marcel Winkler
 *
 */

public class Poker {

	public static void main(String[] args) {
		int runden = 0;
		Karte[] karten = new Karte[52];
		Karte[] gezogen = new Karte[5];
		int[] haeufigkeit = new int[9];
		for(int i = 0; i<1000000; i++, runden++) {
			arrayBefullen(karten, gezogen);
			kartenZiehen(karten, gezogen);

			Vergleichsmethoden.haeufigkeitCheck(haeufigkeit, karten, gezogen);
		}
		printHaeufigkeit(haeufigkeit, runden);

	}

	public static void arrayBefullen(Karte[] karten, Karte[] gezogen) {
		for(int i = 0; i<karten.length; i++) {
			Karte card = new Karte(i, karten);
			karten[i] = card;
		}
		for(int i = 0; i<gezogen.length; i++) {
			gezogen[i] = null;
		}
	}
	public static void kartenZiehen(Karte[] karten, Karte[] gezogen) {
		Karte temp;
		int rndgezogen;
		Random rnd = new Random();

		for(int i = 0; i<gezogen.length; i++) {
			rndgezogen = rnd.nextInt((karten.length-1)-i);
			temp = karten[rndgezogen];
			gezogen[i] = karten[rndgezogen];
			karten[rndgezogen] = karten[(karten.length-1) - i];
			karten[(karten.length-1) - i] = temp;
		}
	}
	public static void printHaeufigkeit(int[] haeufigkeit, int runden) {
		System.out.println("Warscheinlichkeit (bei "+runden+" Runden):");
		System.out.println("1 Paar: \t"+(double)haeufigkeit[0]/runden*100+"%");
		System.out.println("2 Paar: \t"+(double)haeufigkeit[1]/runden*100+"%");
		System.out.println("Drilling: \t"+(double)haeufigkeit[2]/runden*100+"%");
		System.out.println("Straße: \t"+(double)haeufigkeit[3]/runden*100+"%");
		System.out.println("Flush: \t\t"+(double)haeufigkeit[4]/runden*100+"%");
		System.out.println("FullHouse: \t"+(double)haeufigkeit[5]/runden*100+"%");
		System.out.println("Vierling: \t"+(double)haeufigkeit[6]/runden*100+"%");
		System.out.println("StraightFlush: \t"+(double)haeufigkeit[7]/runden*100+"%");
		System.out.println("RoyalFlush: \t"+(double)haeufigkeit[8]/runden*100+"%");
	}

}

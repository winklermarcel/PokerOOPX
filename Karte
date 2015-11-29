package com.htlinn.pokeroop.winkler_pregenzer;

public class Karte {

	private int farbe;
	private int wert;
	
	public Karte(int kartenzahl, Karte[] karten) {
		farbe = (int)kartenzahl/(karten.length/(karten.length/13));
		wert = (int)kartenzahl%(karten.length/(karten.length/13));
	}
	public int getFarbe() {
		return farbe;
	}	
	public int getWert() {
		return wert;
	}
	
}

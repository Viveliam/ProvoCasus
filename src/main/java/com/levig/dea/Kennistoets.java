package com.levig.dea;

import java.util.ArrayList;

public class Kennistoets {

	private String naamToets;
	private int tijdslimiet;
	private ArrayList<Vraag> vragen;

	public Kennistoets(String naamToets, int tijdslimiet) {
		this.naamToets = naamToets;
		this.tijdslimiet = tijdslimiet;
		vragen = new ArrayList<>();
	}

	public void voegVraagToe(String soortVraag, String vraag, String antwoord) {
		switch (soortVraag){
			case "kortantwoord":
				vragen.add(new Kortantwoordvraag(vraag, antwoord));
				break;
			case "meerkeuze":
				vragen.add(new Meerkeuzevraag(vraag, antwoord));
				break;
			case "juistonjuist":
				vragen.add(new Juistonjuistvraag(vraag, antwoord));
				break;
		}
	}

	public String getNaamToets(){
		return naamToets;
	}

	public void voegAntwoordToe(int vraagNr, String antwoord) {
		Kortantwoordvraag v = (Kortantwoordvraag) vragen.get(vraagNr); // TODO: Controleren of gekregen vraag wel een kortantwoordvraag is.
		v.voegAntwoordToe(antwoord);
	}
}

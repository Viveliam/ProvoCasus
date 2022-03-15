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

	public void voegVraagToe(String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
		vragen.add(new Meerkeuzevraag(vraag, antwoorden, juistAntwoord));
	}

	public void voegVraagToe(String vraag, ArrayList<String> antwoorden) {
		vragen.add(new Kortantwoordvraag(vraag, antwoorden));
	}

	public void voegVraagToe(String vraag, String antwoord) {
		vragen.add(new Juistonjuistvraag(vraag, antwoord));
	}

	public String getNaamToets(){
		return naamToets;
	}

	public Vraag getVraag(int vraagNr) {
		return vragen.get(vraagNr);
	}

	public void toonVraag(int vraagNr) {
		Vraag vraag = vragen.get(vraagNr);
		vraag.toonVraag();
	}


}

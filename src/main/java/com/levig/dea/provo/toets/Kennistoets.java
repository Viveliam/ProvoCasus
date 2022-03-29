package com.levig.dea.provo.toets;

import java.util.ArrayList;

public class Kennistoets {

	private String naamToets;
	private int tijdslimiet;
	private ArrayList<Vraag> vragen;
	private VraagFactory vraagFactory;

	public Kennistoets(String naamToets, int tijdslimiet) {
		this.naamToets = naamToets;
		this.tijdslimiet = tijdslimiet;
		vragen = new ArrayList<>();
		vraagFactory = new VraagFactory();
	}

	public void voegVraagToe(String soortVraag, String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
		vragen.add(vraagFactory.createVraag(soortVraag, vraag, antwoorden, juistAntwoord));
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

	public int getAantalVragen() {
		return vragen.size();
	}
}

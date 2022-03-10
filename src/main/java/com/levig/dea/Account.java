package com.levig.dea;

import java.util.ArrayList;

public class Account {

	private String mailadres;
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	private String organisatie;
	private String accounttype;
	private String docentcode;
	private ArrayList<Kennistoets> kennistoetsen;

	public Account(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		this.mailadres = mailadres;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.organisatie = organisatie;
		this.accounttype = accounttype;
		this.docentcode = genereerDocentCode();
		kennistoetsen = new ArrayList<>();
	}

	public String genereerDocentCode() {
		return null;
	}


	public void pasGegevensAan(String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.organisatie = organisatie;
		this.accounttype = accounttype;
	}

	public void toggleAccountType() {
		if (accounttype == "Basis"){
			accounttype = "Premium";
		} else accounttype = "Basis";
	}

	public void maakKennistoetsAan(String naamToets, int tijdslimiet) {
		kennistoetsen.add(new Kennistoets(naamToets, tijdslimiet));
	}

	public void voegVraagToe(String naamToets, String soortVraag, String vraag, String antwoord) {
		Kennistoets k = getKennistoets(naamToets);
		k.voegVraagToe(soortVraag, vraag, antwoord);
	}

	public String getMailadres(){
		return mailadres;
	}

	public Kennistoets getKennistoets(String naamToets){
		for (Kennistoets kennistoets: kennistoetsen) {
			if (kennistoets.getNaamToets() == naamToets) {
				return kennistoets;
			}
		}
		return null; // TODO: Exception maken wanneer toets niet gevonden wordt.
	}

	public void voegAntwoordToe(String naamToets, int vraagNr, String antwoord) {
		Kennistoets k = getKennistoets(naamToets);
		k.voegAntwoordToe(vraagNr, antwoord);
	}
}

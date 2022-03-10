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
	private ArrayList<Lokaal> lokalen;

	public Account(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		this.mailadres = mailadres;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.organisatie = organisatie;
		this.accounttype = accounttype;
		this.docentcode = genereerDocentCode();
		kennistoetsen = new ArrayList<>();
		lokalen = new ArrayList<>();
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

	public void startKennisToets(String naamToets) {
		Lokaal l = nieuwLokaal();
		lokalen.add(l);
		l.startKennisToets(getKennistoets(naamToets));
	}

	private Lokaal nieuwLokaal(){
		if (accounttype == "Basis" && lokalen.size() == 0) {
			return new Lokaal();
		} else if (accounttype == "Premium" &&  lokalen.size() < 8) {
			return new Lokaal();
		}
		return null; // TODO: Throw exception.
	}

	public void maakOverzicht() {
		if (lokalen.size() > 0) {
			Lokaal l = lokalen.get(0);
			l.maakOverzicht();
		}
	}

	public void joinLokaal(String studentNaam, int lokaalNr) {
		Lokaal l = getLokaal(lokaalNr);
		l.joinLokaal(studentNaam);
	}

	public String getDocentcode() {
		return docentcode;
	}

	private Lokaal getLokaal(int lokaalNr) {
		return lokalen.get(lokaalNr);
	}
}

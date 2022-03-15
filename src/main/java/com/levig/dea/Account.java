package com.levig.dea;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

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
	private static AtomicLong idCounter = new AtomicLong();

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
		return String.valueOf(idCounter.getAndIncrement());
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

	public void voegVraagToe(String naamToets, String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
		Kennistoets k = getKennistoets(naamToets);
		k.voegVraagToe(vraag, antwoorden, juistAntwoord);
	}

	public void voegVraagToe(String naamToets, String vraag, ArrayList<String> antwoorden) {
		Kennistoets k = getKennistoets(naamToets);
		k.voegVraagToe(vraag, antwoorden);
	}

	public void voegVraagToe(String naamToets, String vraag, String antwoord) {
		Kennistoets k = getKennistoets(naamToets);
		k.voegVraagToe(vraag, antwoord);
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

	public void maakOverzicht(int lokaalNr) {
		if (lokalen.size() > 0) {
			Lokaal l = lokalen.get(lokaalNr);
			System.out.println("Docent = " + voornaam + " " + achternaam + " Lokaal = " + lokaalNr);
			l.maakOverzicht();
		}
	}

	public String joinLokaal(String studentNaam, int lokaalNr, Provo provo, PuntenTelling puntenTelling) {
		Lokaal l = getLokaal(lokaalNr);
		return l.joinLokaal(studentNaam, provo, puntenTelling);
	}

	public String getDocentcode() {
		return docentcode;
	}

	private Lokaal getLokaal(int lokaalNr) {
		return lokalen.get(lokaalNr);
	}

	public String getStudentID(int lokaalNr, String studentNaam) {
		return lokalen.get(lokaalNr).getStudentID(studentNaam);
	}
}

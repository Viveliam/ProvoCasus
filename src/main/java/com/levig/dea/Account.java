package com.levig.dea;

public class Account {

	private String mailadres;
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	private String organisatie;
	private String accounttype;
	private String docentcode;

	public Account(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		this.mailadres = mailadres;
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.organisatie = organisatie;
		this.accounttype = accounttype;
		this.docentcode = genereerDocentCode();
	}

	public String genereerDocentCode() {
		return null;
	}

	public void toggleAccountType() {

	}

	public void pasGegevensAan(String mailadres, String voornaam, String achternaam, String organisatie, String accounttype) {

	}

	public void maakKennistoetsAan(String toetsnaam, int tijdslimiet) {

	}

	public void voegVraagToe(String soortVraag, String antwoord) {

	}

}

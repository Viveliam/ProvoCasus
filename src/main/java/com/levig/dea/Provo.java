package com.levig.dea;

import sun.swing.SwingAccessor;

import java.util.ArrayList;

public class Provo {
	private ArrayList<Account> accounts = new ArrayList<>();
	private ArrayList<Deelnemer> deelnemers = new ArrayList<>();

	public void voerGegevensIn(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		accounts.add(new Account(mailadres, voornaam, achternaam, wachtwoord, organisatie, accounttype));
	}

	public Account getAccount(String mailadres) {
		for (Account account: accounts) {
			if (account.getMailadres() == mailadres) {
				return account;
			}
		}
		return null; // TODO: Exception maken wanneer account niet gevonden wordt.
	}

	public void pasGegevensAan(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		Account a = getAccount(mailadres);
		a.pasGegevensAan(voornaam, achternaam, wachtwoord, organisatie, accounttype);
	}

	public void voerBetaalgegevensIn(String bankNaam, String mailadres) {

	}

	public void maakKennisToetsAan(String mailadres, String naamToets, int tijdslimiet) {
		Account a = getAccount(mailadres);
		a.maakKennistoetsAan(naamToets, tijdslimiet);
	}

	public void voegVraagToe(String mailadres, String naamToets, String soortVraag, String vraag, String antwoord) {
		Account a = getAccount(mailadres);
		a.voegVraagToe(naamToets, soortVraag, vraag, antwoord);
	}

	public void voegAntwoordToe(String mailadres, String naamToets, int vraagNr, String antwoord) {
		Account a = getAccount(mailadres);
		a.voegAntwoordToe(naamToets, vraagNr, antwoord);
	}

	public void startKennisToets(String naamToets, int lokaalNr) {

	}

	public void maakOverzicht(int lokaalNr) {

	}

	public void joinLokaal(String docentCode, String studentNaam, int lokaalNr) {

	}

	public void beantwoordVraag(int vraagNr, String antwoord) {

	}

	public void bekijkResultaat() {

	}



	public void voegVraagToe(String soortVraag, String antwoord) {

	}

}

package com.levig.dea;

import sun.swing.SwingAccessor;

import java.util.ArrayList;

public class Provo {
	private ArrayList<Account> accounts = new ArrayList<>();
	private ArrayList<Deelnemer> actieveDeelnemers = new ArrayList<>();

	public void voerGegevensIn(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, String accounttype) {
		accounts.add(new Account(mailadres, voornaam, achternaam, wachtwoord, organisatie, accounttype));
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

	public void startKennisToets(String mailadres, String naamToets, int lokaalNr) {
		Account a = getAccount(mailadres);
		a.startKennisToets(naamToets);
	}

	public void maakOverzicht(String mailadres) {
		Account a = getAccount(mailadres);
		a.maakOverzicht();
	}

	public void joinLokaal(String docentCode, String studentNaam, int lokaalNr) {
		Account d = getDocent(docentCode);
		d.joinLokaal(studentNaam, lokaalNr);
	}

	public void beantwoordVraag(String studentID, int vraagNr, String antwoord) {
		Deelnemer student = getStudent(studentID);
		student.beantwoordVraag(vraagNr, antwoord);
	}

	public void bekijkResultaat() {

	}

	public Account getAccount(String mailadres) {
		for (Account account: accounts) {
			if (account.getMailadres() == mailadres) {
				return account;
			}
		}
		return null; // TODO: Exception maken wanneer account niet gevonden wordt.
	}

	private Account getDocent(String docentcode) {
		for (Account account: accounts) {
			if (account.getDocentcode() == docentcode) {
				return account;
			}
		}
		return null; // TODO: Exception maken wanneer account niet gevonden wordt.
	}

	private Deelnemer getStudent(String studentID){
		for (Deelnemer student : actieveDeelnemers) {
			if (student.getStudentID() == studentID) {
				return student;
			}
		}
		return null; // TODO: Exception maken wanneer student niet gevonden wordt.
	}

}

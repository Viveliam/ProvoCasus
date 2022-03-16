package com.levig.dea;

import java.util.ArrayList;

public class Provo {
	private ArrayList<Account> accounts = new ArrayList<>();
	private ArrayList<Deelnemer> actieveDeelnemers = new ArrayList<>();

	public void voerGegevensIn(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, IAccounttypeStrategy accounttype) {
		accounts.add(new Account(mailadres, voornaam, achternaam, wachtwoord, organisatie, accounttype));
	}

	public void pasGegevensAan(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, IAccounttypeStrategy accounttype) {
		Account a = getAccount(mailadres);
		a.pasGegevensAan(voornaam, achternaam, wachtwoord, organisatie, accounttype);
	}

	public void voerBetaalgegevensIn(String bankNaam, String mailadres) {
		boolean paymentAccepted = true;
		if (!paymentAccepted) {
			Account a = getAccount(mailadres);
			a.toggleAccountType();
		} // TODO: Geld incasseren.

	}

	public void maakKennisToetsAan(String mailadres, String naamToets, int tijdslimiet) {
		Account a = getAccount(mailadres);
		a.maakKennistoetsAan(naamToets, tijdslimiet);
	}

	public void voegVraagToe(String mailadres, String naamToets, String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
		Account a = getAccount(mailadres);
		a.voegVraagToe(naamToets, vraag, antwoorden, juistAntwoord);
	}

	public void voegVraagToe(String mailadres, String naamToets, String vraag, ArrayList<String> antwoorden) {
		Account a = getAccount(mailadres);
		a.voegVraagToe(naamToets, vraag, antwoorden);
	}

	public void voegVraagToe(String mailadres, String naamToets, String vraag, String antwoord) {
		Account a = getAccount(mailadres);
		a.voegVraagToe(naamToets, vraag, antwoord);
	}

	public void startKennisToets(String mailadres, String naamToets) {
		Account a = getAccount(mailadres);
		a.startKennisToets(naamToets);
	}

	public void maakOverzicht(String mailadres, int lokaalNr) {
		Account a = getAccount(mailadres);
		a.maakOverzicht(lokaalNr);
	}

	public String joinLokaal(String docentCode, String studentNaam, int lokaalNr, PuntenTelling puntenTelling) {
		Account a = getDocent(docentCode);
		Deelnemer d = a.joinLokaal(studentNaam, lokaalNr, puntenTelling);
		actieveDeelnemers.add(d);
		return d.getStudentID();
	}

	public void toonVraag(String studentID, int vraagNr) {
		Deelnemer student = getStudent(studentID);
		student.toonVraag(vraagNr);
	}

	public void beantwoordVraag(String studentID, int vraagNr, String antwoord) {
		Deelnemer student = getStudent(studentID);
		student.beantwoordVraag(vraagNr, antwoord);
	}

	public void bekijkResultaat(String studentID) {
		Deelnemer d = getStudent(studentID);
		d.printResultaat();
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

	public String getDocentCode(String mailadres) {
		Account a = getAccount(mailadres);
		return a.getDocentcode();
	}

}

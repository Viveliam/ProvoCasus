package com.levig.dea.provo;

import com.levig.dea.provo.account.Account;
import com.levig.dea.provo.account.IAccounttypeStrategy;
import com.levig.dea.provo.uitvoering.Deelnemer;
import com.levig.dea.provo.uitvoering.IPuntenTelling;
import com.levig.dea.provo.uitvoering.TijdPuntenTelling;

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

	public void voegVraagToe(String mailadres, String naamToets, String soortVraag, String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
		Account a = getAccount(mailadres);
		a.voegVraagToe(naamToets, soortVraag, vraag, antwoorden, juistAntwoord);
	}

	public int startKennisToets(String mailadres, String naamToets) {
		Account a = getAccount(mailadres);
		return a.startKennisToets(naamToets);
	}

	public void maakOverzicht(String mailadres, int lokaalNr) {
		Account a = getAccount(mailadres);
		a.maakOverzicht(lokaalNr);
	}

	public String joinLokaal(String docentCode, String studentNaam, int lokaalNr, IPuntenTelling puntenTelling) {
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
		} throw new ProvoException("Account kon niet gevonden worden.");
	}

	private Account getDocent(String docentcode) {
		for (Account account: accounts) {
			if (account.getDocentcode() == docentcode) {
				return account;
			}
		} throw new ProvoException("Docent kon niet gevonden worden.");
	}

	private Deelnemer getStudent(String studentID){
		for (Deelnemer student : actieveDeelnemers) {
			if (student.getStudentID() == studentID) {
				return student;
			}
		} throw new ProvoException("Student kon niet gevonden worden.");
	}

	public String getDocentCode(String mailadres) {
		Account a = getAccount(mailadres);
		return a.getDocentcode();
	}

	public int getAantalVragen(String studentID) {
		Deelnemer student = getStudent(studentID);
		return student.getAantalVragen();
	}

}

package com.levig.dea.provo.account;

import com.levig.dea.provo.ProvoException;
import com.levig.dea.provo.uitvoering.Deelnemer;
import com.levig.dea.provo.toets.Kennistoets;
import com.levig.dea.provo.uitvoering.IPuntenTelling;
import com.levig.dea.provo.uitvoering.Lokaal;
import com.levig.dea.provo.uitvoering.TijdPuntenTelling;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Account {

	private String mailadres;
	private String voornaam;
	private String achternaam;
	private String wachtwoord;
	private String organisatie;
	private IAccounttypeStrategy accounttype;
	private String docentcode;
	private ArrayList<Kennistoets> kennistoetsen;
	private ArrayList<Lokaal> lokalen;
	private static AtomicLong idCounter = new AtomicLong();

	public Account(String mailadres, String voornaam, String achternaam, String wachtwoord, String organisatie, IAccounttypeStrategy accounttype) {
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

	public void pasGegevensAan(String voornaam, String achternaam, String wachtwoord, String organisatie, IAccounttypeStrategy accounttype) {
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		this.wachtwoord = wachtwoord;
		this.organisatie = organisatie;
		this.accounttype = accounttype;
	}

	public void toggleAccountType() {
		if (accounttype instanceof PremiumAccounttypeStrategy){
			accounttype = new BasisAccounttypeStrategy();
		} else accounttype = new PremiumAccounttypeStrategy();
	}

	public void maakKennistoetsAan(String naamToets, int tijdslimiet) {
		kennistoetsen.add(new Kennistoets(naamToets, tijdslimiet));
	}

	public void voegVraagToe(String naamToets, String soortVraag, String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
		Kennistoets k = getKennistoets(naamToets);
		k.voegVraagToe(soortVraag, vraag, antwoorden, juistAntwoord);
	}


	public String getMailadres(){
		return mailadres;
	}

	public Kennistoets getKennistoets(String naamToets){
		for (Kennistoets kennistoets: kennistoetsen) {
			if (kennistoets.getNaamToets() == naamToets) {
				return kennistoets;
			}
		} throw new ProvoException("De gegeven toets kon niet gevonden worden");
	}

	public int startKennisToets(String naamToets) {
		Lokaal l = accounttype.nieuwLokaal(lokalen.size());
		lokalen.add(l);
		l.startKennisToets(getKennistoets(naamToets));
		return lokalen.indexOf(l);
	}

	public void maakOverzicht(int lokaalNr) {
		if (lokalen.size() > 0) {
			Lokaal l = lokalen.get(lokaalNr);
			System.out.println("Docent = " + voornaam + " " + achternaam + " Lokaal = " + lokaalNr);
			l.maakOverzicht();
		}
	}

	public Deelnemer joinLokaal(String studentNaam, int lokaalNr, IPuntenTelling puntenTelling) {
		Lokaal l = getLokaal(lokaalNr);
		return l.joinLokaal(studentNaam, puntenTelling);
	}

	public String getDocentcode() {
		return docentcode;
	}

	private Lokaal getLokaal(int lokaalNr) {
		return lokalen.get(lokaalNr);
	}

}

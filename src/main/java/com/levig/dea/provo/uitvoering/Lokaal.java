package com.levig.dea.provo.uitvoering;

import com.levig.dea.provo.toets.Kennistoets;
import com.levig.dea.provo.toets.Vraag;

import java.util.ArrayList;

public class Lokaal {

	private Kennistoets kennistoets;
	private ArrayList<Deelnemer> deelnemers;

	public Lokaal() {
		deelnemers = new ArrayList<>();
	}

	public void startKennisToets(Kennistoets kennistoets) {
		this.kennistoets = kennistoets;
	}

	public void maakOverzicht() {
		for (Deelnemer d : deelnemers) {
			d.printResultaat();
		}
	}

	public Deelnemer joinLokaal(String studentNaam, IPuntenTelling puntenTelling) {
		Deelnemer deelnemer = new Deelnemer(studentNaam, this, puntenTelling);
		deelnemers.add(deelnemer);
		return deelnemer;
	}

	public Vraag getVraag(int vraagNr) {
		return kennistoets.getVraag(vraagNr);
	}

	public void toonVraag(int vraagNr) {
		kennistoets.toonVraag(vraagNr);
	}

	public int getAantalVragen() {
		return kennistoets.getAantalVragen();
	}
}

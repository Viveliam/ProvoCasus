package com.levig.dea;

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
			System.out.println("Student: " + d.getStudentnaam() + " aantal correct = " + d.getAantalCorrect() + "Score" + d.getPunten());
		}
	}

	public void joinLokaal(String studentNaam) {
		deelnemers.add(new Deelnemer(studentNaam, this));
	}

	public Vraag getVraag(int vraagNr) {
		return kennistoets.getVraag(vraagNr);
	}
}

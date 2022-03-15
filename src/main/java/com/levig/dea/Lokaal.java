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
			d.printResultaat();
		}
	}

	public String joinLokaal(String studentNaam, Provo provo, PuntenTelling puntenTelling) {
		Deelnemer deelnemer = new Deelnemer(studentNaam, this, provo, puntenTelling);
		deelnemers.add(deelnemer);
		return deelnemer.getStudentID();
	}

	public Vraag getVraag(int vraagNr) {
		return kennistoets.getVraag(vraagNr);
	}

	public void toonVraag(int vraagNr) {
		kennistoets.toonVraag(vraagNr);
	}

	public String getStudentID(String studentNaam) {
		for (Deelnemer deelnemer : deelnemers) {
			if (deelnemer.getNaam() == studentNaam){
				return deelnemer.getStudentID();
			}
		} return ""; // TODO: Throw exception.
	}

}

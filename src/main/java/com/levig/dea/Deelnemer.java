package com.levig.dea;

import java.util.ArrayList;

public class Deelnemer {

	private String studentNaam;
	private String studentID;
	private int aantalCorrect;
	private int verstrekenTijd;
	private Punt puntenTelling;
	private Lokaal lokaal;
	private ArrayList<Antwoord> antwoorden;

	public Deelnemer(String studentNaam, Lokaal lokaal) {
		this.studentNaam = studentNaam;
		this.lokaal = lokaal;
		antwoorden = new ArrayList<>();
	}

	public int getAantalCorrect() {
		berekenAantalCorrect();
		return aantalCorrect;
	}

	private void berekenAantalCorrect() {
		aantalCorrect = 0;
		for (Antwoord a : antwoorden) {
			if (a.controleerAntwoord()){
				aantalCorrect++;
			}
		}
	}

	public String getStudentnaam() {
		return studentNaam;
	}

	public String getPunten() {
		return "20"; // TODO: puntentelling.
	}

	public String getStudentID(){
		return studentID;
	}

	public void beantwoordVraag(int vraagNr, String antwoord) {
		Vraag v = lokaal.getVraag(vraagNr);
		antwoorden.add(new Antwoord(this, v, antwoord));
	}
}

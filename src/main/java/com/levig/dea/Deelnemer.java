package com.levig.dea;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Deelnemer {

	private String studentNaam;
	private String studentID;
	private int aantalCorrect;
	private int resterendeTijd;
	private Punt puntenTelling;
	private Lokaal lokaal;
	private ArrayList<Antwoord> antwoorden;
	private static AtomicLong idCounter = new AtomicLong();

	public Deelnemer(String studentNaam, Lokaal lokaal, Provo provo) {
		this.studentNaam = studentNaam;
		this.lokaal = lokaal;
		antwoorden = new ArrayList<>();
		puntenTelling = new Punt(10, 5);
		genereerStudentID();
		provo.voegDeelnemerToe(this);
	}

	private void genereerStudentID() {
		studentID = String.valueOf(idCounter.getAndIncrement());
	}

	public void printResultaat() {
		berekenAantalCorrect();
		System.out.println(	"Student: " + studentNaam +
							" Aantal Correct = " + aantalCorrect +
							" Score = " + puntenTelling.getPunten(aantalCorrect, resterendeTijd));
	}

	private void berekenAantalCorrect() {
		aantalCorrect = 0;
		for (Antwoord a : antwoorden) {
			if (a.controleerAntwoord()){
				aantalCorrect++;
			}
		}
	}

	public void toonVraag(int vraagNr) {
		lokaal.toonVraag(vraagNr);
	}

	public void beantwoordVraag(int vraagNr, String antwoord) {
		Vraag v = lokaal.getVraag(vraagNr);
		antwoorden.add(new Antwoord(this, v, antwoord));
	}

	public String getStudentID(){
		return studentID;
	}

    public String getNaam() {
		return studentNaam;
    }

}

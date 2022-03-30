package com.levig.dea.provo.uitvoering;

import com.levig.dea.provo.toets.Antwoord;
import com.levig.dea.provo.toets.Vraag;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

public class Deelnemer {

	private String studentNaam;
	private String studentID;
	private int aantalCorrect;
	private int resterendeTijd;
	private IPuntenTelling puntenTelling;
	private Lokaal lokaal;
	private ArrayList<Antwoord> antwoorden;
	private static AtomicLong idCounter = new AtomicLong();

	public Deelnemer(String studentNaam, Lokaal lokaal, IPuntenTelling puntenTelling) {
		this.studentNaam = studentNaam;
		this.lokaal = lokaal;
		this.puntenTelling = puntenTelling;
		antwoorden = new ArrayList<>();
		genereerStudentID();
	}

	private void genereerStudentID() {
		studentID = String.valueOf(idCounter.getAndIncrement());
	}

	public void printResultaat() {
		ArrayList<String> resultaten = puntenTelling.berekenResultaten(antwoorden, resterendeTijd);
		System.out.println(	"Student: " + studentNaam +
							" Aantal Correct = " + resultaten.get(0) +
							" Score = " + resultaten.get(1));
	}

	public void toonVraag(int vraagNr) {
		lokaal.toonVraag(vraagNr);
	}

	public void beantwoordVraag(int vraagNr, String antwoord) {
		Vraag v = lokaal.getVraag(vraagNr);
		antwoorden.add(new Antwoord(this, v, antwoord));
		printResultaat();
	}

	public String getStudentID(){
		return studentID;
	}

	public int getAantalVragen() {
		return lokaal.getAantalVragen();
	}
}

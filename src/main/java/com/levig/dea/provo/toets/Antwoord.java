package com.levig.dea.provo.toets;

import com.levig.dea.provo.uitvoering.Deelnemer;

public class Antwoord {

	private String antwoord;
	private Deelnemer deelnemer;
	private Vraag vraag;

	public Antwoord(String antwoord) {
		this.antwoord = antwoord;
	}

	public Antwoord(Deelnemer deelnemer, Vraag vraag, String antwoord) {
		this.deelnemer = deelnemer;
		this.vraag = vraag;
		this.antwoord = antwoord;
	}

    public boolean controleerAntwoord() {
		return vraag.controleerAntwoord(antwoord);
    }

	public String getAntwoord() {
		return antwoord;
	}

	public void toonAntwoord() {
		System.out.println(antwoord);
	}
}

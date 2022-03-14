package com.levig.dea;

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
		if (vraag instanceof Juistonjuistvraag){
			Juistonjuistvraag j = (Juistonjuistvraag) vraag;
			return j.controleerAntwoord(antwoord);
		} else if (vraag instanceof Meerkeuzevraag){
			Meerkeuzevraag m = (Meerkeuzevraag) vraag;
			return m.controleerAntwoord(antwoord);
		} else if (vraag instanceof Kortantwoordvraag){
			Kortantwoordvraag k = (Kortantwoordvraag) vraag;
			return k.controleerAntwoord(antwoord);
		} return false; // TODO: Exception maken.
    }

	public String getAntwoord() {
		return antwoord;
	}

	public void toonAntwoord() {
		System.out.println(antwoord);
	}
}

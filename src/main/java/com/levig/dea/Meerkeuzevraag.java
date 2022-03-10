package com.levig.dea;

public class Meerkeuzevraag extends Vraag {

    private Antwoord juistAntwoord;

    public Meerkeuzevraag(String vraag, String antwoord) {
        super(vraag);
        juistAntwoord = new Antwoord(antwoord);
    }

    public boolean controleerAntwoord(String antwoord) {
        if (antwoord == juistAntwoord.getAntwoord()) {
            return true;
        } return false;
    }
}

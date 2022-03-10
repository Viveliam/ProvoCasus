package com.levig.dea;

public class Meerkeuzevraag extends Vraag {

    private Antwoord juistAntwoord;

    public Meerkeuzevraag(String vraag, String antwoord) {
        super(vraag);
        juistAntwoord = new Antwoord(antwoord);
    }
}

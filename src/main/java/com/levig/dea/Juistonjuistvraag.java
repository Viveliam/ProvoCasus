package com.levig.dea;

public class Juistonjuistvraag extends Vraag {

    private Antwoord juistAntwoord;

    public Juistonjuistvraag(String vraag, String antwoord) {
        super(vraag);
        juistAntwoord = new Antwoord(antwoord);
    }
}

package com.levig.dea;

public class Juistonjuistvraag extends Vraag {

    private Antwoord juistAntwoord;

    public Juistonjuistvraag(String vraag, String antwoord) {
        super(vraag);
        juistAntwoord = new Antwoord(antwoord);
    }

    public boolean controleerAntwoord(String antwoord) {
        if (antwoord == juistAntwoord.getAntwoord()) {
            return true;
        } return false;
    }

    public void toonVraag() {
        System.out.println(vraag);
        System.out.println("Juist");
        System.out.println("Onjuist");
    }
}

package com.levig.dea.provo.toets;

public class Juistonjuistvraag extends Vraag {

    private Antwoord juistAntwoord;

    public Juistonjuistvraag(String vraag, String antwoord) {
        super(vraag);
        juistAntwoord = new Antwoord(antwoord);
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        if (antwoord == juistAntwoord.getAntwoord()) {
            return true;
        } return false;
    }

    @Override
    public void toonVraag() {
        System.out.println(vraag);
        System.out.println("Juist");
        System.out.println("Onjuist");
    }
}

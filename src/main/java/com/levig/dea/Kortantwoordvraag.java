package com.levig.dea;

import java.util.ArrayList;

public class Kortantwoordvraag extends Vraag {

    private ArrayList<Antwoord> juisteAntwoorden;

    public Kortantwoordvraag(String vraag, String antwoord) {
        super(vraag);
        juisteAntwoorden.add(new Antwoord(antwoord));
    }

    public void voegAntwoordToe(String antwoord) {
        juisteAntwoorden.add(new Antwoord(antwoord));
    }

    public boolean controleerAntwoord(String antwoord) {
        for (Antwoord juistAntwoord : juisteAntwoorden) {
            if (antwoord == juistAntwoord.getAntwoord()) {
                return true;
            }
        }
        return false;
    }
}

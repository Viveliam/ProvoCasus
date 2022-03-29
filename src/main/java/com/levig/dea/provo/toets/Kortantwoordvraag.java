package com.levig.dea.provo.toets;

import java.util.ArrayList;

public class Kortantwoordvraag extends Vraag {

    private ArrayList<Antwoord> juisteAntwoorden;

    public Kortantwoordvraag(String vraag, ArrayList<String> antwoorden) {
        super(vraag);
        juisteAntwoorden = new ArrayList<>();
        for (String antwoord : antwoorden){
            juisteAntwoorden.add(new Antwoord(antwoord));
        }
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        for (Antwoord juistAntwoord : juisteAntwoorden) {
            if (antwoord == juistAntwoord.getAntwoord()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void toonVraag() {
        System.out.println(vraag);
    }
}

package com.levig.dea.provo.toets;

import java.util.ArrayList;
import java.util.Objects;

public class Meerkeuzevraag extends Vraag {

    private int juistAntwoord;
    private ArrayList<Antwoord> antwoorden;

    public Meerkeuzevraag(String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
        super(vraag);
        this.juistAntwoord = juistAntwoord;
        this.antwoorden = new ArrayList<>();
        for (String antwoord : antwoorden) {
            this.antwoorden.add(new Antwoord(antwoord));
        }
    }

    @Override
    public boolean controleerAntwoord(String antwoord) {
        return Objects.equals(antwoord, antwoorden.get(juistAntwoord).getAntwoord());
    }

    @Override
    public void toonVraag() {
        System.out.println(vraag);
        for (Antwoord antwoord : antwoorden) {
            antwoord.toonAntwoord();
        }
    }
}

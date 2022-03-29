package com.levig.dea.provo.toets;

import java.util.ArrayList;

public class VraagFactory {

    public Vraag createVraag(String soortVraag, String vraag, ArrayList<String> antwoorden, int juistAntwoord) {
        switch(soortVraag) {
            case "meerkeuze":
                return new Meerkeuzevraag(vraag, antwoorden, juistAntwoord);
            case "juistonjuist":
                return new Juistonjuistvraag(vraag, antwoorden.get(0));
            case "kortantwoord":
                return new Kortantwoordvraag(vraag, antwoorden);
        }
        return null;
    }

}

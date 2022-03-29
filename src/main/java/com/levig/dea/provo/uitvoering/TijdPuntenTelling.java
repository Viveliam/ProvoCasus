package com.levig.dea.provo.uitvoering;

import com.levig.dea.provo.toets.Antwoord;

import java.util.ArrayList;
import java.util.Arrays;

public class TijdPuntenTelling implements IPuntenTelling {

    private int puntenPerCorrectAntwoord;
    private int puntenPerResterendeTijd;

    public TijdPuntenTelling() {
        puntenPerCorrectAntwoord = 100;
        puntenPerResterendeTijd = 1;
    }

    public TijdPuntenTelling(int puntenPerCorrectAntwoord, int puntenPerResterendeTijd){
        this.puntenPerCorrectAntwoord = puntenPerCorrectAntwoord;
        this.puntenPerResterendeTijd = puntenPerResterendeTijd;
    }

    public ArrayList<String> berekenResultaten(ArrayList<Antwoord> antwoorden, int resterendeTijd) {
        int totaalPunten = 0;
        int aantalCorrect = 0;
        for (Antwoord antwoord : antwoorden) {
            if (antwoord.controleerAntwoord()){
                totaalPunten += puntenPerCorrectAntwoord;
                aantalCorrect++;
            }
        }
        totaalPunten += resterendeTijd * puntenPerResterendeTijd;
        return new ArrayList<>(Arrays.asList("" + aantalCorrect, "" + totaalPunten));
    }
}

package com.levig.dea.provo.uitvoering;

import com.levig.dea.provo.toets.Antwoord;

import java.util.ArrayList;
import java.util.Arrays;

public class StreakPuntenTelling implements IPuntenTelling {

    private int puntenPerCorrectAntwoord;
    private int puntenPerCorrecteStreak;

    public StreakPuntenTelling() {
        puntenPerCorrectAntwoord = 100;
        puntenPerCorrecteStreak = 10;
    }

    public StreakPuntenTelling(int puntenPerCorrectAntwoord, int puntenPerCorrecteStreak) {
        this.puntenPerCorrectAntwoord = puntenPerCorrectAntwoord;
        this.puntenPerCorrecteStreak = puntenPerCorrecteStreak;
    }

    @Override
    public ArrayList<String> berekenResultaten(ArrayList<Antwoord> antwoorden, int resterendeTijd) {
        int totaalPunten = 0;
        int aantalCorrect = 0;
        int streak = 0;
        for (Antwoord antwoord : antwoorden) {
            if (antwoord.controleerAntwoord()){
                totaalPunten += puntenPerCorrectAntwoord + puntenPerCorrecteStreak * streak;
                aantalCorrect++;
                streak++;
            } else {
                streak = 0;
            }
        }
        return new ArrayList<>(Arrays.asList("" + aantalCorrect, "" + totaalPunten));
    }

}

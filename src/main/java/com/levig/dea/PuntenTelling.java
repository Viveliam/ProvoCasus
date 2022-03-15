package com.levig.dea;

public class PuntenTelling {

    private int puntenPerCorrectAntwoord;
    private int puntenPerResterendeTijd;

    public PuntenTelling(int puntenPerCorrectAntwoord, int puntenPerResterendeTijd){
        this.puntenPerCorrectAntwoord = puntenPerCorrectAntwoord;
        this.puntenPerResterendeTijd = puntenPerResterendeTijd;
    }

    public String getPunten(int aantalCorrect, int resterendeTijd) {
        int punten = aantalCorrect * puntenPerCorrectAntwoord + resterendeTijd *puntenPerResterendeTijd;
        return "" + punten;
    }
}

package com.levig.dea;

public class PremiumAccounttypeStrategy implements IAccounttypeStrategy {

    private int maxAantalLokalen = 8;

    @Override
    public Lokaal nieuwLokaal(int huidigeAantalLokalen) {
        if (huidigeAantalLokalen < maxAantalLokalen){
            return new Lokaal();
        }
        return null; // TODO: Exception gooien
    }
}

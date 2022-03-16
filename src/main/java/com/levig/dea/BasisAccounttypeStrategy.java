package com.levig.dea;

public class BasisAccounttypeStrategy implements IAccounttypeStrategy {

    private int maxAantalLokalen = 1;

    @Override
    public Lokaal nieuwLokaal(int huidigeAantalLokalen) {
        if (huidigeAantalLokalen < maxAantalLokalen) {
            return new Lokaal();
        }
        return null; // TODO: Exception gooien
    }
}

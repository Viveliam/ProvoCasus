package com.levig.dea.provo.account;

import com.levig.dea.provo.ProvoException;
import com.levig.dea.provo.uitvoering.Lokaal;

public class BasisAccounttypeStrategy implements IAccounttypeStrategy {

    private int maxAantalLokalen = 1;

    @Override
    public Lokaal nieuwLokaal(int huidigeAantalLokalen) {
        if (huidigeAantalLokalen < maxAantalLokalen) {
            return new Lokaal();
        } else throw new ProvoException("Het maximale aantal lokalen is al bereikt.");
    }
}

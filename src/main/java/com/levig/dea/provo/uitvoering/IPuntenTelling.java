package com.levig.dea.provo.uitvoering;

import com.levig.dea.provo.toets.Antwoord;

import java.util.ArrayList;

public interface IPuntenTelling {

    public ArrayList<String> berekenResultaten(ArrayList<Antwoord> antwoorden, int resterendeTijd);

}

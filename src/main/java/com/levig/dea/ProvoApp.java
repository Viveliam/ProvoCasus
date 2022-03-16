package com.levig.dea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ProvoApp {

    public static void main(String[] args) {
        Provo provo = new Provo();

        String docentMail = "SjaakSnel@gmail.com";
        String naamToets = "VoorbeeldToets";

        // Maak toets
        provo.voerGegevensIn(docentMail, "Sjaak", "Snel", "abcdef", "HAN", new BasisAccounttypeStrategy());
        provo.maakKennisToetsAan(docentMail, naamToets, 1800);
        provo.voegVraagToe(docentMail, naamToets,
                "Welke van de begrippen needs, features en requirements horen bij het solution domain?",
                new ArrayList<>(Arrays.asList("needs, features en requirements", "needs en requirements", "features en requirements",
                        "alleen requirements")), 2);
        provo.voegVraagToe(docentMail, naamToets,
                "Wat wordt bedoeld met 'elicit needs from stakeholders'?",
                new ArrayList<>(Arrays.asList("Het boven tafel krijgen van de needs van belanghebbenden",
                        "Het documenteren van de needs van belanghebbenden", "Het valideren van de needs van belanghebbenden",
                        "Het vertalen van de needs van belanghebbende naar software features")),0);
        provo.voegVraagToe(docentMail, naamToets,"Wat leg je vast m.b.v. use cases?",
                new ArrayList<>(Arrays.asList("needs", "features", "functional requirements", "non-functional requirements"))
                ,2);
        provo.voegVraagToe(docentMail, naamToets,
                "Welke term wordt gebruikt voor 'the ability to describe and follow the life of a requirement, in both forwards and backwards direction'?",
                new ArrayList<>(Arrays.asList("traceability", "Traceability")));
        provo.voegVraagToe(docentMail, naamToets,
                "Op welke momenten in een project kunnen de requirements gewijzigd worden?",
                new ArrayList<>(Arrays.asList("Op elk gewenst moment", "Na elke iteratie", "Niet meer, de requirements liggen vast"))
        , 1);
        provo.voegVraagToe(docentMail, naamToets,
                "De volgende eis valt in de categorie Usability: Het systeem moet 75% van de webpagina's binnen 2 seconden tonen.",
                "Onjuist");

        // Start toets
        String docentCode = provo.getDocentCode(docentMail);
        int lokaalNr = 0;
        provo.startKennisToets(docentMail, naamToets);

        // Join toets
        String studentNaam = "Klaasjan123";
        PuntenTelling puntenTelling = new PuntenTelling(10, 5);
        String studentID = provo.joinLokaal(docentCode, studentNaam, lokaalNr, puntenTelling);
        int vraagNr = 0;

        // Volg toets
        Scanner input = new Scanner(System.in);
        do {
            provo.toonVraag(studentID, vraagNr);
            String antwoord = input.nextLine();

            provo.beantwoordVraag(studentID, vraagNr, antwoord);
            vraagNr++;
        } while (vraagNr < 6);
        input.close();

        provo.maakOverzicht(docentMail, lokaalNr);
    }

}

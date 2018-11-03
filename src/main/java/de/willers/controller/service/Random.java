package de.willers.controller.service;

import de.willers.view.Text;

/**
 * Von Dennis Willers (A13A316) am 02.11.2018 erstellt
 */
public class Random {
    public Random(){

    }

    public String getBelastendAntwort(){
        String[] belastendText = Text.BELASTEND_ANTWORT;
        return belastendText[getRandomBelastend(belastendText)];
    }

    public String getNameBelastendAntwort(){
        String[] belastendText = Text.NAME_BELASTEND;
        return belastendText[getRandomBelastend(belastendText)];
    }

    private int getRandomBelastend(String[] belastendAntworten){
        java.util.Random zufall = new java.util.Random();
        int zufallsZahl = zufall.nextInt(belastendAntworten.length);
        return zufallsZahl;
    }
}

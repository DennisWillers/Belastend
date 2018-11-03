package de.willers.view;

/**
 * Von Dennis Willers (A13A316) am 04.10.2018 erstellt
 */
public interface Text {

    String HELP          = "ZU BEARBEITEN";
    String STOP          = "ZU BEARBEITEN";
    String FALLBACK      = "ZU BEARBEITEN";

    String[] BELASTEND_ANTWORT = {
            "Du denkst dein Tag war belastend? Mir wurde heute ein Hammer in die Hand gedrückt und ich sollte damit schrauben drehen. ",
            "Wenn du wüsstest, was mich die Leute tagtäglich alles fragen. Absolut belastend ",
            "Sollte letztens jemanden wecken - Habe selbst verschlafen. Belastend. "
    };

    String FRAGE_BELASTUNG = "Wer ist eine Belastung? ";
    String[] NAME_BELASTEND = {
            ", du bist belastend! ",
            ", du bist eine einzige Belastung! ",
            ", du belastest mich! ",
            ", ich glaube ich spreche im Namen aller. - Du bist eine Belastung! "
    };

    //SSML Aussprache

    /**TODO
     * SSML Text bearbeiten
     */
    String HELP_SSML          = "ZU BEARBEITEN";
    String STOP_SSML          = "ZU BEARBEITEN";
    String FALLBACK_SSML      = "ZU BEARBEITEN";
}

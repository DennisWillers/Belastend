package de.willers.controller.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Intent;
import com.amazon.ask.model.IntentRequest;
import com.amazon.ask.model.Response;
import de.willers.model.Intentnamen;
import de.willers.model.Parameter;
import de.willers.view.Card;
import de.willers.view.Text;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * Von Dennis Willers (A13A316) am 28.10.2018 erstellt
 */
public class BelastendIntentHandler implements RequestHandler
{
    @Override
    public boolean canHandle(HandlerInput input) {
    return input.matches(intentName(Intentnamen.STARTGAMEINTENT));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return fehlerNachricht(input);
    }

    //*************
    //HILFSMETHODEN
    //*************


    /*
     * RESPONSE MÖGLICHKEITEN
     */

    private Optional<Response> fehlerNachricht (HandlerInput input){
        String fehler = "Es ist ein Fehler passiert";
        return input.getResponseBuilder()
                .withSpeech(fehler)
                .withSimpleCard("Fehler", fehler)
                .build();
    }
}
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
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

/**
 * Von Dennis Willers (A13A316) am 28.10.2018 erstellt
 */
public class PersonIntentHandler implements RequestHandler
{
    @Override
    public boolean canHandle(HandlerInput input) {
    return input.matches(intentName(Intentnamen.PERSONINTENT));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Intent requestIntent = ((IntentRequest) input.getRequestEnvelope().getRequest()).getIntent();
        //Frage nach Name der Belastung
        if(requestIntent.getSlots().get(Parameter.NAME).getValue() == null || requestIntent.getSlots().get(Parameter.NAME).getValue().equals("?"))
        {
            return frageSpielerNamen(input,requestIntent);
        }
        else {
            return belastendNameAntwort(input, requestIntent.getSlots().get(Parameter.NAME).getValue());
        }
    }

    //*************
    //HILFSMETHODEN
    //*************

    /*
     * RESPONSE MÖGLICHKEITEN
     */

    private Optional<Response> belastendNameAntwort (HandlerInput input, String name){
        de.willers.controller.service.Random random = new de.willers.controller.service.Random();
        String antwort = name + random.getNameBelastendAntwort();
        return input.getResponseBuilder()
                .withSpeech(antwort)
                .withSimpleCard(Card.TITEL, antwort)
                .build();
    }

    private Optional<Response> frageSpielerNamen(HandlerInput input, Intent requestIntent){
        return input.getResponseBuilder()
                .withSpeech(Text.FRAGE_BELASTUNG)
                .addElicitSlotDirective(Parameter.NAME, requestIntent)
                .build();
    }
}
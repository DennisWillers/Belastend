package de.willers.controller.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import de.willers.model.Intentnamen;
import de.willers.view.Card;
import de.willers.view.Text;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

// 2018-July-09: AMAZON.FallackIntent is only currently available in en-US locale.
//              This handler will not be triggered except in that locale, so it can be
//              safely deployed for any locale.
public class FallbackIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(Intentnamen.FALLBACKINTENT));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(Text.FALLBACK_SSML)
                .withSimpleCard(Card.TITEL, Text.FALLBACK)
                .withReprompt(Text.FALLBACK_SSML)
                .build();
    }

}

package de.willers.controller.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import de.willers.model.Intentnamen;
import de.willers.view.Card;
import de.willers.view.Text;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class CancelandStopIntentHandler implements RequestHandler {
    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName(Intentnamen.STOPINTENT).or(intentName(Intentnamen.CANCELINTENT)));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        return input.getResponseBuilder()
                .withSpeech(Text.STOP_SSML)
                .withSimpleCard(Card.TITEL, Text.STOP)
                .build();
    }
}

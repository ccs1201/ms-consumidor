package br.com.ccs.msconsumidor.handler;

import br.com.messagedispatcher.annotation.Event;
import br.com.messagedispatcher.annotation.MessageListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MessageListener
public class EventHandler {

    @SuppressWarnings("ClassEscapesDefinedScope")
    @Event
    public void handleEvent(EventPayload eventPayload) {
        log.info("Processado em {}.handleEvent | Mensagem consumida: {}", getClass().getSimpleName(), eventPayload);
    }

    private record EventPayload(Integer idade) {
    }
}

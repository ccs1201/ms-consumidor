package br.com.ccs.msconsumidor.handler;

import br.com.messagedispatcher.annotation.Event;
import br.com.messagedispatcher.annotation.MessageListener;
import lombok.extern.slf4j.Slf4j;

@SuppressWarnings("ClassEscapesDefinedScope")
@Slf4j
@MessageListener
public class EventHandler {

    @Event
    public void handleEvent(EventPayload eventPayload) {
        log.info("Processado em {}.handleEvent | Mensagem consumida: {}", getClass().getSimpleName(), eventPayload);
    }

    @Event
    public void handleError(EventErrorPayload eventPayload) {
        log.info("Processado em {}.handleError | Mensagem consumida: {}", getClass().getSimpleName(), eventPayload);
    throw new RuntimeException("handleError proposital testar DLQ");
    }

    private record EventPayload(Integer idade) {
    }

    private record EventErrorPayload() {
    }
}

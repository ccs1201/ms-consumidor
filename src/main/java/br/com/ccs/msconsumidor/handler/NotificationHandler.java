package br.com.ccs.msconsumidor.handler;

import br.com.messagedispatcher.annotation.MessageListener;
import br.com.messagedispatcher.annotation.Notification;
import br.com.messagedispatcher.publisher.MessagePublisher;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@MessageListener
public class NotificationHandler {

    private final MessagePublisher publisher;

    @Notification
    public void handleNotification(@Valid SucessoRecord payload) {
        log.info("Processado em {}.handleNotification | Mensagem consumida: {}", getClass().getSimpleName(), payload);
//        publisher.sendNotification(MsProdutor.MS_PRODUTOR_RK, payload);
    }

    @Notification
    public void erro(@Valid ExceptionRecord payload) {
        throw new UnsupportedOperationException("Método sendNotificationError não implementado");
    }

    public record SucessoRecord(@NotNull int id) {
    }

    public record ExceptionRecord(@NotBlank String mensagem) {
    }
}

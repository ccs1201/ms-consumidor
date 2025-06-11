package br.com.ccs.msconsumidor.listener;

import br.com.messagedispatcher.MessageDispatcherListener;
import br.com.messagedispatcher.router.impl.AnnotatedMessageRouter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
//@Component
@RequiredArgsConstructor
public class EventMessageListener implements MessageDispatcherListener {

    private static final String QUEUE_NAME = "ms-consumidor.event.inbox";
    private static final String EXCHANGE_NAME = "message.dispatcher.ex";
    private static final String ERROR_HANDLER = "messageDispatcherErrorHandler";
    private static final String TRUE = "true";
    private static final String FALSE = "false";

    private final AnnotatedMessageRouter messageRouter;

    @Override
    @RabbitListener(
            bindings =
            @QueueBinding(
                    value = @Queue(
                            value = QUEUE_NAME,
                            durable = TRUE,
                            autoDelete = FALSE,
                            exclusive = FALSE),
                    exchange = @Exchange(
                            value = EXCHANGE_NAME,
                            type = ExchangeTypes.TOPIC,
                            ignoreDeclarationExceptions = TRUE
                    ),
                    key = QUEUE_NAME
            ),
            concurrency = "#{@messageDispatcherProperties.concurrency}",
            returnExceptions = FALSE,
            errorHandler = ERROR_HANDLER
    )
    public Object onMessage(Message message) {
        log.info("Mensagem consumida pelo listener: {} message: {}", getClass().getSimpleName(), message);
        return messageRouter.routeMessage(message);
    }
}

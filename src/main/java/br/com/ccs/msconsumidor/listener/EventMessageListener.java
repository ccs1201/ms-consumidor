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
@Component
@RequiredArgsConstructor
public class EventMessageListener implements MessageDispatcherListener {

    private static final String QUEUE_NAME = "ms-consumidor.event.inbox";
    private final AnnotatedMessageRouter messageRouter;

    @Override
    @RabbitListener(
            bindings =
            @QueueBinding(
                    value = @Queue(
                            value = QUEUE_NAME,
                            durable = "true"),
                    exchange = @Exchange(
                            value = "message.dispatcher.ex",
                            type = ExchangeTypes.TOPIC,
                            durable = "true",
                            ignoreDeclarationExceptions = "true"
                    ),
                    key = "ms-consumidor.event.inbox"
            ),
            concurrency = "#{@messageDispatcherProperties.concurrency}",
            returnExceptions = "false",
            errorHandler = "messageDispatcherErrorHandler"
    )
    public Object onMessage(Message message) {
        log.info("Mensagem consumida pelo listener: {} message: {}", getClass().getSimpleName(), message);
        return messageRouter.routeMessage(message);
    }
}

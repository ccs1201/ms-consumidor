package br.com.ccs.msconsumidor.handler;

import br.com.messagedispatcher.annotation.Command;
import br.com.messagedispatcher.annotation.MessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@RequiredArgsConstructor
@MessageListener
public class CommandHandler {

    @SuppressWarnings("ClassEscapesDefinedScope")
    @Command
    public DoCommandSuccess handleCommand(DoCommandSuccess commandSuccess) {
        log.info("Processado em {}.handleCommand | Mensagem consumida: {}", getClass().getSimpleName(), commandSuccess);
        return commandSuccess;
    }

    record DoCommandSuccess(String nome, int idade, char sexo, LocalDate dataNascimento, String path) {
    }
}

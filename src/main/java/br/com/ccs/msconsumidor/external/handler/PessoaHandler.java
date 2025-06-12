package br.com.ccs.msconsumidor.external.handler;

import br.com.ccs.msconsumidor.external.entity.Pessoa;
import br.com.ccs.msconsumidor.service.PessoaService;
import br.com.messagedispatcher.annotation.Event;
import br.com.messagedispatcher.annotation.MessageListener;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MessageListener
@RequiredArgsConstructor
public class PessoaHandler {

    private final PessoaService pessoaService;

    @Event
    public void handlePessoa(Pessoa pessoa) {
       log.info("Pessoa recebida: " + pessoa.toString());
       pessoaService.save(pessoa);

    }
}

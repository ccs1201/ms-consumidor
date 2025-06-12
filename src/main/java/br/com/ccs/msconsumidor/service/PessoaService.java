package br.com.ccs.msconsumidor.service;

import br.com.ccs.msconsumidor.external.entity.Pessoa;
import br.com.ccs.msconsumidor.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public void save(Pessoa pessoa) {
        pessoaRepository.save(pessoa);
    }
}

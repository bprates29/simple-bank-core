package br.com.bprates.core_bank.controller;

import br.com.bprates.core_bank.model.domain.Transacao;
import br.com.bprates.core_bank.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping(value = "listar")
    public Iterable<Transacao> obterLista(){
        return transacaoService.obterLista();
    }

    @GetMapping(value = "{id}")
    public Transacao obterPorId(@PathVariable Integer id) {
        return transacaoService.obterPorId(id);
    }

    @PostMapping(value = "incluir")
    public String incluir(@RequestBody Transacao conta) {

        transacaoService.incluir(conta);

        return "A inclusão da " + conta + " foi realizada com sucesso!!!";
    }

    @DeleteMapping(value = "{id}")
    public String excluir(@PathVariable Integer id) {
        transacaoService.excluir(id);
        return "A exclusão do id " + id + " foi realizada com sucesso!!!";
    }
}

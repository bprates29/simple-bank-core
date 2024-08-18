package br.com.bprates.core_bank.controller;

import br.com.bprates.core_bank.model.domain.Cliente;
import br.com.bprates.core_bank.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "listar")
    public Iterable<Cliente> obterLista(){
        return clienteService.obterLista();
    }

    @GetMapping(value = "{id}")
    public Cliente obterPorId(@PathVariable Integer id) {
        return clienteService.obterPorId(id);
    }

    @PostMapping(value = "incluir")
    public String incluir(@RequestBody Cliente cliente) {

        clienteService.incluir(cliente);

        return "A inclusão do " + cliente + " foi realizada com sucesso!!!";
    }

    @DeleteMapping(value = "{id}")
    public String excluir(@PathVariable Integer id) {
        clienteService.excluir(id);
        return "A exclusão do id " + id + " foi realizada com sucesso!!!";
    }
}

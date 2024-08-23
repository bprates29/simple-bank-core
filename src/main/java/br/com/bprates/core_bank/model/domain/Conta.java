package br.com.bprates.core_bank.model.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Toda conta deve inicializar com um valor")
    private Double saldo;

    @NotBlank(message = "O número da conta não pode estar vazio")
    private String numeroConta;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "conta", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Transacao> transacoes = new ArrayList<>();

    public Conta() {}

    public Conta(Double saldo, String numeroConta, Cliente cliente) {
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", saldo=" + saldo +
                ", numeroConta='" + numeroConta + '\'' +
                ", cliente=" + (cliente != null ? cliente.getNome() : "Sem cliente") +
                ", transacoes=" + (transacoes != null ? transacoes.size() : 0) +
                '}';
    }
}

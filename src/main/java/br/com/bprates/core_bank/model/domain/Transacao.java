package br.com.bprates.core_bank.model.domain;

public class Transacao {
    private Integer id;
    private Double valor;
    private String descricao;
    private TipoTransacao tipo;
    private Conta conta;

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", tipo=" + tipo +
                ", conta=" + (conta != null ? conta.getNumeroConta() : "sem conta") +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }
}

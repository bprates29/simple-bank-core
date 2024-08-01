package br.com.bprates.core_bank.model.domain;

import java.util.List;

public class Cliente extends Pessoa {
    private String email;
    private Boolean isAtivo;

    private List<Conta> contas;

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nome='" + getNome() + '\'' +
                ", email='" + email + '\'' +
                ", isAtivo=" + isAtivo +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAtivo() {
        return isAtivo;
    }

    public void setAtivo(Boolean ativo) {
        isAtivo = ativo;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
}

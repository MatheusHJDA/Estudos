package com.example.cadastrocliente;

import java.util.Objects;

public class Cliente {
    private String nome;
    private Long cpf;
    private String endereco;
    private String numero;

    public Cliente(String nome, String cpf, String endereco, String numero){
        this.nome = nome;
        this.cpf = Long.valueOf(cpf.trim());
        this.endereco = endereco;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente cliente)) return false;
        return Objects.equals(getCpf(), cliente.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCpf());
    }

    @Override
    public String toString() {
        return "Cliente : {" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}

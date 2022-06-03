package org.wyden.pdao.model;

import java.io.Serializable;


public class Pessoa implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String primeiroNome;
    private String ultimoNome;
    private int idade;
    private Telefone telefone;

    public Pessoa() {
        super();
    }

    public Pessoa(String primeiroNome, String ultimoNome, int idade, Telefone telefone) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.idade = idade;
        this.telefone = telefone;
    }
    public Pessoa(String id, String primeiroNome, String ultimoNome, int idade, Telefone telefone) {
        this.id = id;
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.idade = idade;
        this.telefone = telefone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", primeiroNome='" + primeiroNome + '\'' +
                ", ultimoNome='" + ultimoNome + '\'' +
                ", idade=" + idade +
                ", telefone=" + telefone +
                '}';
    }
}

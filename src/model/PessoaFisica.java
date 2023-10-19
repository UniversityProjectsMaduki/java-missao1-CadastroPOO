package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa implements Serializable {
    private String cpf;
    private int idade;

    public PessoaFisica(int id, String nome, String cpf, int idade) {
        super(id, nome);
        this.cpf = cpf;
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public void exibir() {
        System.out.println("ID: " + getId() + ", Nome: " + getNome() + ", CPF: " + cpf + ", Idade: " + idade);
    }


    @Override
    public String toString() {
        return "ID: " + getId() + ", Nome: " + getNome() + ", CPF: " + cpf + ", Idade: " + idade;
    }

}

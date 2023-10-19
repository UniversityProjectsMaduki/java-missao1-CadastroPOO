package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<>();

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }
    public void alterar(PessoaFisica pessoaFisica) {
        for (int i =0; i < pessoasFisicas.size(); i++) {
            if (pessoasFisicas.get(i).getId() == pessoaFisica.getId()) {
                pessoasFisicas.set(i, pessoaFisica);
                break;
            }
        }
    }
    public void excluir(int id) {
        pessoasFisicas.removeIf(p -> p.getId() == id);
    }

    public PessoaFisica obter(int id) {
        for (PessoaFisica p : pessoasFisicas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public ArrayList<PessoaFisica> obeterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String nomeArquivo) throws IOException {
        try {
            FileOutputStream fileOut = new FileOutputStream(nomeArquivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pessoasFisicas);
            out.close();
            fileOut.close();
            System.out.println("Dados de Pessoa Física Armazenados");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void recuperar(String nomeArquivo) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fileIn = new FileInputStream(nomeArquivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Dados de Pessoa Física Recuperados");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

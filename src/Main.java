import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PessoaFisicaRepo repoFisica = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoJuridica = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("===============================");
            System.out.println("1 - Incluir Pessoa");
            System.out.println("2 - Alterar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("4 - Buscar pelo Id");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Persistir Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar Programa");
            System.out.println("===============================");
            System.out.print("Digite uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipo = sc.nextLine().charAt(0);
                    System.out.println("Digite o id da pessoa: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Isira os dados...");
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    if (tipo == 'F' || tipo == 'f') {
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        repoFisica.inserir(new PessoaFisica(id, nome, cpf, idade));
                    } else if (tipo == 'J' || tipo == 'j') {
                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();
                        repoJuridica.inserir(new PessoaJuridica(id, nome, cnpj));
                    }
                    break;

                case 2:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipoAlterar = sc.nextLine().charAt(0);
                    System.out.println("Digite o id da pessoa que deseja alterar:");
                    int idAlterar = sc.nextInt();
                    sc.nextLine();

                    if (tipoAlterar == 'F' || tipoAlterar == 'f') {
                        PessoaFisica pfAtual = repoFisica.obter(idAlterar);
                        if (pfAtual != null) {
                            System.out.println("Dados atuais:");
                            pfAtual.exibir();
                            System.out.println("Insira os novos dados...");
                            System.out.print("Nome: ");
                            String novoNome = sc.nextLine();
                            System.out.print("CPF: ");
                            String novoCpf = sc.nextLine();
                            System.out.print("Idade: ");
                            int novaIdade = sc.nextInt();
                            PessoaFisica pfAlterada = new PessoaFisica(idAlterar, novoNome, novoCpf, novaIdade);
                            repoFisica.alterar(pfAlterada);
                        } else {
                            System.out.println("Pessoa Física com ID " + idAlterar + " não encontrada.");
                        }
                    } else if (tipoAlterar == 'J' || tipoAlterar == 'j') {
                        PessoaJuridica pjAtual = repoJuridica.obter(idAlterar);
                        if (pjAtual != null) {
                            System.out.println("Dados atuais:");
                            pjAtual.exibir();
                            System.out.println("Insira os novos dados...");
                            System.out.print("Nome: ");
                            String novoNomeJ = sc.nextLine();
                            System.out.print("CNPJ: ");
                            String novoCnpj = sc.nextLine();
                            PessoaJuridica pjAlterada = new PessoaJuridica(idAlterar, novoNomeJ, novoCnpj);
                            repoJuridica.alterar(pjAlterada);
                        } else {
                            System.out.println("Pessoa Jurídica com ID " + idAlterar + " não encontrada.");
                        }
                    }
                    break;

                case 3:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipoExcluir = sc.nextLine().charAt(0);
                    System.out.println("Digite o id da pessoa que deseja excluir:");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();

                    if (tipoExcluir == 'F' || tipoExcluir == 'f') {
                        PessoaFisica pfExcluir = repoFisica.obter(idExcluir);
                        if (pfExcluir != null) {
                            repoFisica.excluir(idExcluir);
                            System.out.println("Pessoa Física com ID " + idExcluir + " excluída com sucesso.");
                        } else {
                            System.out.println("Pessoa Física com ID " + idExcluir + " não encontrada.");
                        }
                    } else if (tipoExcluir == 'J' || tipoExcluir == 'j') {
                        PessoaJuridica pjExcluir = repoJuridica.obter(idExcluir);
                        if (pjExcluir != null) {
                            repoJuridica.excluir(idExcluir);
                            System.out.println("Pessoa Jurídica com ID " + idExcluir + " excluída com sucesso!");
                        } else {
                            System.out.println("Pessoa Jurídica com ID " + idExcluir + " não encontrada.");
                        }
                    }
                    break;

                case 4:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipoBuscar = sc.nextLine().charAt(0);
                    System.out.println("Digite o id da pessoa que deseja buscar:");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    if (tipoBuscar == 'F' || tipoBuscar == 'f') {
                        PessoaFisica pfBuscar = repoFisica.obter(idBuscar);
                        if (pfBuscar != null) {
                            pfBuscar.exibir();
                        } else {
                            System.out.println("Pessoa Física com ID " + idBuscar + " não encontrada.");
                        }
                    } else if (tipoBuscar == 'J' || tipoBuscar == 'j') {
                        PessoaJuridica pjBuscar = repoJuridica.obter(idBuscar);
                        if (pjBuscar != null) {
                            pjBuscar.exibir();
                        } else {
                            System.out.println("Pessoa Jurídica com ID " + idBuscar + " não encontrada.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipoExibir = sc.nextLine().charAt(0);
                    if (tipoExibir == 'F' || tipoExibir == 'f') {
                        System.out.println("Pessoas Físicas: ");
                        for (PessoaFisica pf : repoFisica.obterTodos()) {
                            System.out.println(pf);  // Isso chama o método toString() da instância pf
                        }
                    } else if (tipoExibir == 'J' || tipoExibir == 'j') {
                        System.out.println("Pessoas Jurídicas: ");
                        for (PessoaJuridica pj : repoJuridica.obterTodos()) {
                            System.out.println(pj);  // Isso chama o método toString() da instância pj
                        }
                    }
                    break;

                case 6:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipoPersistir = sc.nextLine().charAt(0);

                    System.out.println("Digite o prefixo para o nome do arquivo: ");
                    String prefixo = sc.nextLine();

                    if (tipoPersistir == 'F' || tipoPersistir == 'f') {
                        try {
                            repoFisica.persistir(prefixo + ".fisica.bin");
                            System.out.println("Dados de Pessoa Física persistidos com sucesso!" + prefixo + ".fisica.bin");
                        } catch (IOException e) {
                            System.out.println("Erro ao persistir dados de Pessoa Física: " + e.getMessage());
                        }
                    } else if (tipoPersistir == 'J' || tipoPersistir == 'j') {
                        try {
                            repoJuridica.persistir(prefixo + ".juridica.bin");
                            System.out.println("Dados de Pessoas Jurídica persistidos com sucesso" + prefixo + ".juridica.bin");
                        } catch (IOException e) {
                            System.out.println("Erro ao persistir dados de Pessoa Juridica: ");
                        }
                    }
                    break;

                case 7:
                    System.out.println("Digite F para Pessoa Física ou J para Pessoa Jurídica");
                    char tipoRecuperar = sc.nextLine().charAt(0);

                    System.out.println("Digite o prefixo do nome do arquivo para recuperar os dados:");
                    String prefixoRecuperar = sc.nextLine();

                    if (tipoRecuperar == 'F' || tipoRecuperar == 'f') {
                        try {
                            repoFisica.recuperar(prefixoRecuperar + ".fisica.bin");
                            System.out.println("Dados de Pessoa Física recuperados com sucesso de " + prefixoRecuperar + ".fisica.bin");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar dados de Pessoa Física: " + e.getMessage());
                        }
                    } else if (tipoRecuperar == 'J' || tipoRecuperar == 'j') {
                        try {
                            repoJuridica.recuperar(prefixoRecuperar + ".juridica.bin");
                            System.out.println("Dados de Pessoa Jurídica recuperados com sucesso de " + prefixoRecuperar + ".juridica.bin");
                        } catch (IOException | ClassNotFoundException e) {
                            System.out.println("Erro ao recuperar dados de Pessoa Jurídica: " + e.getMessage());
                        }
                    }
                    break;

                case 0:
                    System.out.println("Finalizando o programa");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

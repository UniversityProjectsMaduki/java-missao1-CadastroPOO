import model.PessoaFisica;
import model.PessoaFisicaRepo;
import model.PessoaJuridica;
import model.PessoaJuridicaRepo;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try {
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();

            repo1.inserir(new PessoaFisica(1, "Ana", "111.111.111-11", 25));
            repo1.inserir(new PessoaFisica(2, "Carlos", "222.222.222-22", 52));

            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();

            repo2.recuperar("pessoasFisicas.dat");
            for (PessoaFisica pf : repo2.obeterTodos()) {
                System.out.println(pf);
            }

            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();

            repo3.inserir(new PessoaJuridica(3, "XPTO Sales", "33.333.333/0001-33"));
            repo3.inserir(new PessoaJuridica(4, "XPTO Solutions", "44.444.444/0001-44"));

            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();

            repo4.recuperar("pessoasJuridicas.dat");

            for (PessoaJuridica pj : repo4.obterTodos()) {
                System.out.println(pj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

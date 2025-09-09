import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioComum extends Usuario {
    private ArrayList<Emprestimo> historico = new ArrayList<>(); 

    public UsuarioComum(int id, String nome, String email, String numero) {
        super(id, nome, email, numero); // chama o construtor da classe mãe
    }

    public void pegarLivro(Livro exemplar){
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataRetorno = dataEmprestimo.plusDays(15);
        // Livro livroEmprestado = new Livro("Dom Casmurro", 360360445, "Machado de Assis", 2);
        
        if (exemplar.quantidadeDisponivel <= 0){
            System.out.println("Livro não disponivel para troca");
        }
        else
        {
            historico.add(new Emprestimo(dataEmprestimo, dataRetorno, exemplar));
            exemplar.setQuantidadeDisponivel(exemplar.quantidadeDisponivel - 1);
        }

    }
    public void retornarLivro(Livro exemplar){
        // procura o livro no historica de emprestimo
        // se não achar o livro -> erro´
        // se achar -> soma 1 na quantidade e verifica multa 

        //LocalDate dataDevolução = LocalDate.now();
        //historico.devolucao.verificaAtraso(dataDevolução);
        
    }

}

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
        boolean livroEncontrado = false;
        for (Emprestimo emprestimo : this.historico){
            if (emprestimo.getLivroEmprestado().equals(exemplar)){
                exemplar.setQuantidadeDisponivel(exemplar.quantidadeDisponivel + 1);
                emprestimo.devolvido = true;
                livroEncontrado = true;
                
                LocalDate dataDevolucao = LocalDate.now();
                emprestimo.verificaAtraso(dataDevolucao);
                break;
            }        
        }
        if (!livroEncontrado)
            System.out.println("LIvro não encontrado");
    }

}

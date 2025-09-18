package gerenciadorBiblioteca;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca{
    public List<Livro> acervo = new ArrayList<>();
    public List<Usuario> usuarios = new ArrayList<>();
    
    public Biblioteca(){

    }
    
    public void adicionarLivro(Livro novoLivro, List<Livro> livros){
        livros.add(novoLivro);
        System.out.println("Novo livro adicionado: " + novoLivro.getTitulo());
    }
    public void removerLivro(int idLivro, List<Livro> livros){
        livros.removeIf(l-> l.getId() == idLivro);
        System.out.println("livro removido do acervo: (id: " + idLivro + ")");
    }
    public void adicionarUsuario(List<Usuario> usuarios, UsuarioComum novoUsuario){
        usuarios.add(novoUsuario);
        System.out.println("Novo usuario comum: " + novoUsuario.getNome());

    }
    public void removerUsuario(List<Usuario> usuarios, int idUser){
        usuarios.removeIf(l-> l.getId() == idUser);
        System.out.println("usuario removido do sistema: (id: " + idUser + ")");
    }

    public void pegarLivro(UsuarioComum user, Livro exemplar){
        LocalDate dataEmprestimo = LocalDate.now();
        LocalDate dataRetorno = dataEmprestimo.plusDays(15);
        // Livro livroEmprestado = new Livro("Dom Casmurro", 360360445, "Machado de Assis", 2);
        
        if (exemplar.getQuantidadeDisponivel() <= 0){
            System.out.println("Livro não disponivel para troca");
        }
        else
        {
            user.getHistorico().add(new Emprestimo(dataEmprestimo, dataRetorno, exemplar, false));
            exemplar.setQuantidadeDisponivel(exemplar.getQuantidadeDisponivel() - 1);
            exemplar.setQuantidadeEmprestada(exemplar.getQuantidadeEmprestada() + 1);
        }

    }
    public void retornarLivro(UsuarioComum user, Livro exemplar){
        boolean livroEncontrado = false;
        for (Emprestimo emprestimo : user.getHistorico()){
            if (emprestimo.getLivroEmprestado().equals(exemplar)){
                exemplar.setQuantidadeDisponivel(exemplar.getQuantidadeDisponivel() + 1);
                exemplar.setQuantidadeEmprestada(exemplar.getQuantidadeEmprestada() - 1);
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

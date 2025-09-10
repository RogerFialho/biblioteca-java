import java.util.List;

public class Bibliotecario extends Usuario{
    public Bibliotecario(int id , String nome, String email, String numero){
        super(id, nome, email, numero);
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
    public void adicionarUsuario(List<Usuario> usuarios, Bibliotecario novoUsuario){
        usuarios.add(novoUsuario);
        System.out.println("Novo Bibliotecário: " + novoUsuario.getNome());
    }
    public void removerUsuario(List<Usuario> usuarios, int idUser){
        usuarios.removeIf(l-> l.getId() == idUser);
        System.out.println("usuario removido do sistema: (id: " + idUser + ")");
    }
}

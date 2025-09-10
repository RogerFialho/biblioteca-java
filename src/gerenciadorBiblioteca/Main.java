package gerenciadorBiblioteca;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Inicializa as listas para os livros e usuários
        List<Livro> acervo = new ArrayList<>();
        List<Usuario> usuarios = new ArrayList<>();
        
        // Nomes dos arquivos CSV
        String arquivoLivros = "acervo.csv";
        String arquivoUsuarios = "usuarios.csv";

        // Carrega os dados dos arquivos CSV para a memória
        acervo = Memoria.carregaLivros(arquivoLivros);
        usuarios = Memoria.carregaUsuarios(arquivoUsuarios);
        
        System.out.println("Sistema de Biblioteca iniciado.");

        // Exemplo de interação com o sistema
        System.out.println("\n--- Exemplo de uso ---");

        // Acessa um usuário e um livro
        UsuarioComum ana = (UsuarioComum) usuarios.get(0);
        Bibliotecario carlos = (Bibliotecario) usuarios.get(1);
        Livro livro1 = acervo.get(0);
        Livro livro2 = acervo.get(2);

        System.out.println("Olá, " + ana.getNome() + "!");
        System.out.println("O livro '" + livro1.getTitulo() + "' tem " + livro1.getQuantidade() + " cópias disponíveis.");

        // Usuário comum pega um livro
        ana.pegarLivro(livro1);
        System.out.println("\nAna pegou o livro: " + livro1.getTitulo());
        System.out.println("Agora, o livro '" + livro1.getTitulo() + "' tem " + livro1.getQuantidade() + " cópias disponíveis.");
        
        // Usuário comum tenta pegar um livro indisponível
        System.out.println("\nAna tenta pegar o livro: " + livro2.getTitulo());
        ana.pegarLivro(livro2);
        System.out.println("O livro '" + livro2.getTitulo() + "' tem " + livro2.getQuantidade() + " cópias disponíveis.");
        
        // Bibliotecário adiciona um novo livro
        System.out.println("\n--- Ações do Bibliotecário ---");
        Livro novoLivro = new Livro("O Alquimista", 5, "Paulo Coelho", 10);
        carlos.adicionarLivro(novoLivro, acervo);

        // Bibliotecário remove um livro
        carlos.removerLivro(3, acervo);
        
        // Salva as alterações de volta nos arquivos CSV
        Memoria.salvarLivros(arquivoLivros, acervo);
        Memoria.salvarUsuarios(arquivoUsuarios, usuarios);
        
        System.out.println("\nDados atualizados e salvos nos arquivos CSV.");
    }
}
package gerenciadorBiblioteca;


public class Main {
    public static void main(String[] args) {
        String pathAcervo = "data/acervo.csv";
        String pathUser = "data/usuarios.csv";
        String pathHistorico = "data/historico.csv";
        Biblioteca bbtc = new Biblioteca(Memoria.carregaLivros(pathAcervo), Memoria.carregaUsuarios(pathUser));
        Memoria.carregaHistoricos(pathHistorico, bbtc.usuarios, bbtc.acervo);
       
        bbtc.exibeLivrosDisponiveis();
        bbtc.exibeLivrosEmprestados();
        System.out.println("Dados dos csv carregados");
        
        Livro novoLivro1 = new Livro("Dom Quixote", 176,  "Miguel de Cervantes",1786, 3, 0);
        bbtc.adicionarLivro(novoLivro1);
        
        UsuarioComum novoUsuario1 = new UsuarioComum(7, "joaozinho", "jo.ao@email.com", "+5512345678");
        bbtc.adicionarUsuario(novoUsuario1);

        Livro livro1984 = bbtc.acervo.get(2); 
        UsuarioComum usuarioAlice = bbtc.usuarios.get(0); 

        bbtc.pegarLivro(usuarioAlice, livro1984);
        System.out.println("Livro 1984 emprestado para Alice");
        
        System.out.println("\nRelatório pós empréstimo");
        bbtc.exibeLivrosDisponiveis();
        bbtc.exibeLivrosEmprestados();


        bbtc.retornarLivro(usuarioAlice, livro1984);
        System.out.println("\nalice devolveu o livro 1984");
        
        System.out.println("\nRelatório pós devolução");
        bbtc.exibeLivrosDisponiveis();
        bbtc.exibeLivrosEmprestados();
        
        Memoria.salvarLivros(pathAcervo, bbtc.acervo);
        Memoria.salvarUsuarios(pathUser, bbtc.usuarios);
        Memoria.salvaHistoricos(pathHistorico, bbtc.usuarios);
        
        System.out.println("\nDados salvos no csv");
    }
}

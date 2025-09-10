import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = Memoria.carregaUsuarios("usuarios.csv");
        List<Livro> livros =   Memoria.carregaLivros("acervo.csv");

        usuarios.forEach(u -> System.out.println(u.getNome() + " - " + u.getEmail()));
        livros.forEach(l-> System.out.println(l.getTitulo() + ", " + l.getAutor()));

        UsuarioComum new_user = new UsuarioComum(69, "Adalberto", "test.com", "466");

        usuarios.add(new_user);
        Memoria.salvarUsuarios("usuarios.csv", usuarios);
    }
}

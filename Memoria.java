import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class Memoria {
    // salva uma lista de livros no arquivo acervo
    public static void salvarLivros(String nomearquivo, List<Livro> livros){
        try (BufferedWriter bw  = new BufferedWriter(new FileWriter(nomearquivo))){
            for (Livro l : livros){
                bw.write(l.getId() + "," + l.getTitulo() + "," + l.getAutor() + "," + l.getQuantidade());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // lê o arquivo de acerto e deixa na memória
    public static List<Livro> carregaLivros(String nomearquivo){
        List<Livro> livros = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(nomearquivo))){
            String linha;
            while ((linha = bf.readLine()) != null){
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String titulo = dados[1];
                String autor = dados[2];
                int quantidade = Integer.parseInt(dados[3]);
                livros.add(new Livro(titulo, id,  autor, quantidade));
            }
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado, iniciando acervo como lista vazia");
        }
        return livros;
    }
    // salva os dados dos usuários no arquivo usuarios
    public static void salvarUsuarios(String nomearquivo, List<Usuario> usuarios){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomearquivo))){
            for (Usuario u : usuarios){
                String tipo = (u instanceof UsuarioComum) ? "COMUM" : "BIBLIOTECARIO";
                bw.write(tipo + "," + u.getId() + "," + u.getNome() + "," + u.getEmail() + "," + u.getNumero());
                bw.newLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("arquivo de usuarios salvo");
    }

    public static List<Usuario> carregaUsuarios(String nomearquivo){
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader bf = new BufferedReader(new FileReader(nomearquivo))){
            String linha;
            while ((linha = bf.readLine()) != null ){
                String[] dados = linha.split(",");
                String tipo = dados[0];
                int id = Integer.parseInt(dados[1]);
                String nome = dados[2];
                String email = dados[3];
                String numero = dados[4];

                if ("COMUM".equalsIgnoreCase(tipo)){
                    usuarios.add(new UsuarioComum(id, nome, email, numero));
                } else if ("BIBLIOTECARIO".equalsIgnoreCase(tipo)){
                    usuarios.add(new Bibliotecario(id, nome, email, numero));
                } else {
                    System.out.println("Usuario " + nome + "com tipo indefinido");
                }
            } 
        }catch (IOException e){
                System.out.println("Arquivo de usuarios não encontrado");
        }
        return usuarios;
        
    }
}

package gerenciadorBiblioteca;
import java.io.*;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Memoria {
    // salva uma lista de livros no arquivo acervo
    public static void salvarLivros(String nomearquivo, List<Livro> livros){
        try (BufferedWriter bw  = new BufferedWriter(new FileWriter(nomearquivo))){
            for (Livro l : livros){
                bw.write(l.getId() + "," + l.getTitulo() + "," + l.getAutor() + "," + l.getQuantidadeDisponivel() + "," + l.getQuantidadeEmprestada());
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
                int quantidadeDisp = Integer.parseInt(dados[3]);
                int quantidadeEmp = Integer.parseInt(dados[4]);
                livros.add(new Livro(titulo, id,  autor, quantidadeDisp, quantidadeEmp));
            }
        } catch (Exception e) {
            System.out.println("Arquivo não encontrado, iniciando acervo como lista vazia");
        }
        return livros;
    }
    // salva os dados dos usuários no arquivo usuarios
    public static void salvarUsuarios(String nomearquivo, List<UsuarioComum> usuarios){
    try(BufferedWriter bw = new BufferedWriter(new FileWriter(nomearquivo))){
        for (UsuarioComum u : usuarios){
            bw.write(u.getId() + "," + u.getNome() + "," + u.getEmail() + "," + u.getNumero());
            bw.newLine();
        }
    } catch (IOException e){
        e.printStackTrace();
    }
    System.out.println("Arquivo de usuários salvo.");   
    }

    public static List<UsuarioComum> carregaUsuarios(String nomearquivo){
    List<UsuarioComum> usuarios = new ArrayList<>();
    try (BufferedReader bf = new BufferedReader(new FileReader(nomearquivo))){
        String linha;
        while ((linha = bf.readLine()) != null ){
            String[] dados = linha.split(",");
            int id = Integer.parseInt(dados[0]);
            String nome = dados[1];
            String email = dados[2];
            String numero = dados[3];

            usuarios.add(new UsuarioComum(id, nome, email, numero));
        }
    } catch (IOException e){
        System.out.println("Arquivo de usuários não encontrado.");
    }
    return usuarios;
    }

    public static void salvaHistoricos(String nomearquivo, List<UsuarioComum> usuarios){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nomearquivo))){
            for (UsuarioComum u : usuarios){
                ArrayList<Emprestimo> historico = u.getHistorico();
                for (Emprestimo e : historico){
                    bw.write(u.getId() + "," + e.getLivroEmprestado().getId() + "," + e.getDataInicial() + "," + e.getDataFinal() + "," + e.getDevolvido());
                    bw.newLine();
                }
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
    }

    private static UsuarioComum encontraUserPoriD(List<UsuarioComum> users, int idUser){
        for (UsuarioComum u : users){
            if (u.getId() == idUser){
                return u;
            }
        }
        return null;
    }

    private static Livro encontraLivroPorID(List<Livro> acervo, int idLivro){ 
        for (Livro l : acervo)
        {
            if(l.getId() == idLivro){
                return l;
            }
        }
        return null;

    }


    public static void carregaHistoricos(String nomearquivo, List<UsuarioComum> usuarios, List<Livro> acervo){
        try (BufferedReader bf = new BufferedReader(new FileReader(nomearquivo))){
            String linha;
            while ((linha = bf.readLine()) != null){
                String[] dados = linha.split(",");
                int idUsuario = Integer.parseInt(dados[0]);
                int idLivro = Integer.parseInt(dados[1]);
                LocalDate dataInicial = LocalDate.parse(dados[2]);
                LocalDate dataFinal = LocalDate.parse(dados[3]);
                boolean devolvido = Boolean.parseBoolean(dados[4]);

                UsuarioComum usuario = encontraUserPoriD(usuarios, idUsuario);
                Livro livro = encontraLivroPorID(acervo, idLivro);

                if (usuario != null && livro != null){
                    Emprestimo novoEmprestimo = new Emprestimo(dataInicial, dataFinal, livro, devolvido);
                    usuario.getHistorico().add(novoEmprestimo);
                } else {
                    System.out.println("Usuário ou livro não encontrado para o registro de histórico: " + linha);
                }
            }
        } catch (IOException e){
            System.out.println("Arquivo de histórico não encontrado, iniciando com histórico vazio.");
        }
    }

}

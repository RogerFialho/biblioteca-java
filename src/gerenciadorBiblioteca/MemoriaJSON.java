package gerenciadorBiblioteca;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class MemoriaJson{
  private static final ObjectMapper = new ObjectMapper();
  
  static {
    MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
  }


  public static boolean salvaLivrosJSON(List<Livro> livros, String nomearquivo){
    try {
      File saida = new File(nomearquivo);
      MAPPER.writeValue(nomearquivo, livros);
      System.out.println("Salvo em JSON com sucesso");
      return true;
    } catch(IOException e){
      System.err.println("Erro ao salvar livros em JSON em", nomearquivo, e);
      e.printStackTrace();
      return false;
    }
  }

  public static boolean salvaUsersJSON(List<UsuarioComum> users, String nomearquivo){
    try {
      File saida = new File(nomearquivo);
      MAPPER.writeValue(nomearquivo, users);
      System.out.println("Salvo em JSON com sucesso");
      return true;
    } catch(IOException e){
      System.err.println("Erro ao salvar usuários em JSON em", nomearquivo, e);
      e.printStackTrace();
      return false;
    }
  }

  public static List<UsuarioComum> parseUsers(String jsonString){
    try {
      return MAPPER.readValue(jsonString, new TypeReference<List<Usuario>>() {});
    } catch (IOException){
      System.err.println("Erro ao ler JSON de usuários");
      e.printStackTrace();
      return List.of();
    }
  }

  public static List<Livro> parseLivros(String jsonString){
    try {
      return MAPPER.readValue(jsonString, new TypeReference<List<Livro>>);
    }
    catch (IOException){
      System.err.println("Erro ao carregar acervo");
      e.printStackTrace();
      return List.of();
    }
  }

  public static String carregaJson(String nomearquivo) throws IOException{
    try (InputStream inputStream = JsonParserEstatico.class.getClassLoader().getResourceAsStream(nomeArquivo)){
      if (inputStream == null){
        throw new IOException("Arquivo não encontrado " + nomearquivo, e);
      }
      return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    } catch (IOException e){
      throw new IOException("Erro ao ler o arquivo " + nomearquivo, e);
    }
          
  }
}

package gerenciadorBiblioteca;
public class Livro {
    public String titulo;
    public int id;
    public String autor;
    public int quantidadeDisponivel;

    public Livro(String titulo, int id, String autor, int quantidadeDisponivel){
        this.titulo = titulo;
        this.id = id;
        this.autor = autor;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public int getId(){
        return this.id;
    }
    public String getAutor (){
        return this.autor;
    }
    public int getQuantidade(){
        return this.quantidadeDisponivel;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setId(int id){
        this.id = id;
    } 
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setQuantidadeDisponivel(int novaQuantidade){
        this.quantidadeDisponivel = novaQuantidade;
    }
}

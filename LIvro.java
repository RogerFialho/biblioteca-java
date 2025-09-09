public class Livro {
    private String titulo;
    private int id;
    private String autor;
    private int quantidadeDisponivel;

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
    public void setQuantidadeDisponivel(int novaQuantidade){
        this.quantidadeDisponivel = novaQuantidade;
    }
}

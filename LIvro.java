public class LIvro {
    private Strinng titulo;
    private int id;
    private String autor;
    private int quantidadeDisponivel;

    public String getTitulo(){
        return this.titulo;
    }
    public int getId(){
        return this.id;
    }
    public int setQuantidadeDisponivel(int novaQuantidade){
        this.quantidadeDisponivel = novaQuantidade;
    }
}

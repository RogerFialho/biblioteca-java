package gerenciadorBiblioteca;
public class Livro {
    private String titulo;
    private int id;
    private String autor;
    private int ano;
    private int quantidadeDisponivel;
    private int quantidadeEmprestada;

    public Livro(String titulo, int id, String autor, int ano, int quantidadeDisponivel, int quantidadeEmprestada){
        this.titulo = titulo;
        this.id = id;
        this.autor = autor;
        this.ano = ano;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeEmprestada = quantidadeEmprestada;
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
    public int getAno() {
        return ano;
    }
    public int getQuantidadeDisponivel(){
        return this.quantidadeDisponivel;
    }
    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAno(int ano) {
        this.ano = ano;
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
    public void setQuantidadeEmprestada(int quantidadeEmprestada) {
        this.quantidadeEmprestada = quantidadeEmprestada;
    }
}

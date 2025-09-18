package gerenciadorBiblioteca;
import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    public Livro livroEmprestado;
    public boolean devolvido;
    
    public Emprestimo(LocalDate dataInicial, LocalDate dataFinal, Livro livroEmprestado, boolean devolvido){
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.livroEmprestado = livroEmprestado;
        this.devolvido = devolvido;
    }
    
    public LocalDate getDataFinal() {
        return dataFinal;
    }
    public LocalDate getDataInicial() {
        return dataInicial;
    }
    public Livro getLivroEmprestado() {
        return livroEmprestado;
    }
    public boolean getDevolvido(){
        return devolvido;
    }

    public void verificaAtraso(LocalDate dataRecebimento){
        if (dataFinal.isBefore(dataRecebimento)){
            System.out.println("Multa aplicada");
        }
        else{
            System.out.println("Sem multa");
        }
    }
}

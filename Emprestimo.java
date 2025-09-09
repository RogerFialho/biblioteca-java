import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    public Livro livroEmprestado;
    public boolean devolvido = false;
    
    public Emprestimo(LocalDate dataInicial, LocalDate dataFinal, Livro livroEmprestado){
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.livroEmprestado = livroEmprestado;
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

    public void verificaAtraso(LocalDate dataRecebimento){
        if (dataFinal.isBefore(dataRecebimento)){
            System.out.println("Multa aplicada");
        }
        else{
            System.out.println("Sem multa");
        }
    }
}

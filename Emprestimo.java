import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    public Livro livroEmprestado;
    
    public Emprestimo(LocalDate dataInicial, LocalDate dataFinal, Livro livroEmpLivro){
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.livroEmprestado = livroEmprestado;
    }

    public int calcularAtraso(LocalDate dataRecebimento){
        if (dataFinal.isBefore(dataRecebimento)){
            System.out.println("Multa aplicada");

        }
        else{
            System.out.println("Sem multa");
        }
    }
}

import java.time.LocalDate;

public class Emprestimo {
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    
    public Emprestimo(LocalDate dataInicial, LocalDate dataFinal){
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public int calcularAtraso(LocalDate dataRecebimento){
        (dataRecebimento > dataFinal) ? return dataRecebimento - dataFinal : return 0;
    }
}

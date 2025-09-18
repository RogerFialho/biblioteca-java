package gerenciadorBiblioteca;
import java.util.ArrayList;

public class UsuarioComum extends Usuario {
    private ArrayList<Emprestimo> historico = new ArrayList<>(); 

    public UsuarioComum(int id, String nome, String email, String numero) {
        super(id, nome, email, numero); 
    }

    public void exibirHistorico(){
        for(Emprestimo e : this.historico){
            System.out.print(e.getLivroEmprestado().getTitulo() + ", emprestado em " + e.getDataInicial());
            if (!e.getDevolvido()){
                System.out.println("e devolvido em " + e.getDataFinal() + ".");
            }        
            else{
                System.out.println(" e não devolvido até então.");
            } 
        }
    }

    public ArrayList<Emprestimo> getHistorico() {
        return historico;
    }

}

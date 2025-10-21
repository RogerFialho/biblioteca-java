package gerenciadorBiblioteca;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String numero;

    public Usuario(){
    }
 
    public Usuario(int id , String nome, String email, String numero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }  
    public int getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getNumero() {
        return numero;
    } 
     
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
}

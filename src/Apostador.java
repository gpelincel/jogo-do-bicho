public class Apostador {
    private int id_apostador;
    private String nome;
    private String telefone;

    public int getId() {
        return id_apostador;
    }

    public void setId_apostador(int id_apostador) {
        this.id_apostador = id_apostador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Apostador(){}
    public Apostador(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String toString() {
        return "Apostador{" +
                "id_apostador:" + id_apostador +
                ", nome:'" + nome + '\'' +
                '}';
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

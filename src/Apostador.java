public class Apostador {
    private int id_apostador;
    private String nome;

    public int getId_apostador() {
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

    public Apostador(int id_apostador, String nome) {
        this.id_apostador = id_apostador;
        this.nome = nome;
    }

    public String toString() {
        return "Apostador{" +
                "id_apostador:" + id_apostador +
                ", nome:'" + nome + '\'' +
                '}';
    }
}

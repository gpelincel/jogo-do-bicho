public class Aposta {
    private int id_aposta;
    private String numero_aposta;
    private Apostador apostador;

    public int getId_aposta() {
        return id_aposta;
    }

    public void setId_aposta(int id_aposta) {
        this.id_aposta = id_aposta;
    }

    public String getNumero_aposta() {
        return numero_aposta;
    }

    public void setNumero_aposta(String numero_aposta) {
        this.numero_aposta = numero_aposta;
    }

    public int getApostador() {
        return apostador.getId();
    }

    public void setApostador(Apostador apostador) {
        this.apostador = apostador;
    }

    public Aposta(int id_aposta, String numero_aposta, Apostador apostador){
        this.id_aposta = id_aposta;
        this.numero_aposta = numero_aposta;
        this.apostador = apostador;
    }

    public String toString(){
        return "ID Aposta: "+this.id_aposta+"\nMilhar: "+this.numero_aposta+"\n";
    }
}

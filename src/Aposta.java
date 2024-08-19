public class Aposta {
    private int id_aposta;
    private String numero_aposta;
    private Apostador apostador;

    public function Aposta(int id_aposta, String numero_aposta, Apostador apostador){
        this.id_aposta = id_aposta;
        this.numero_aposta = numero_aposta;
        this.apostador = apostador;
    }
}

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

    public String[] getBichos(){
        String[] dezenas = {"", ""};
        String[] bichos = {"Avestruz", "Aguia", "Burro", "Borboleta", "Cachorro", "Cabra", "Carneiro", "Camelo", "Cobra", "Coelho", "Cavalo", "Elefante", "Galo", "Gato", "Jacare", "Leao", "Macaco", "Porco", "Pavao", "Peru", "Touro", "Tigre", "Urso", "Veado", "Vaca"};
        String[] bichos_sorteados = {"", ""};

        for (int i = 0; i < 2; i++) {
            dezenas[i] = String.valueOf(this.numero_aposta.charAt(i));
            dezenas[i] += this.numero_aposta.charAt(i + 1);
        }

        int grupo = 1;
        for (int i = 1; i <= 100; i += 4, grupo++) {
            for (int j = 0; j < 2; j++) {
                if (Integer.valueOf(dezenas[j]) > i && Integer.valueOf(dezenas[j]) < i + 4) {
                    bichos_sorteados[j] = bichos[grupo-1];
                    grupo = 0;
                    break;
                }
            }
        }

        return bichos_sorteados;
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

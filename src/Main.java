import java.util.List;
import java.util.Scanner;
import java.util.random.RandomGenerator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("===== JOGO DO BICHO ======");
            System.out.println("1 - Apostar");
            System.out.println("2 - Cadastrar apostador");
            System.out.println("3 - Sortear milhar");
            System.out.println("0 - Sair");
            System.out.println("\n");
            System.out.print("Sua opcao: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n");
                    System.out.println("===== CADASTRAR APOSTA =====");
                    formAposta();

                case 2:
                    System.out.println("===== CADASTRAR APOSTADOR =====");
                    formApostador();

                case 3:
                    System.out.println("===== FAZER SORTEIO =====");
                    sortear();
            }

            System.out.print("Deseja continuar no sistema? (1 - Sim / 0 - Nao): ");
            option = scanner.nextInt();

        } while (option != 0);
    }

    public static void sortear() {
        String milhar = String.valueOf(RandomGenerator.getDefault().nextInt(1000, 9999));
        String[] dezenas = {"", ""};
        String[] bichos = {"Avestruz", "Aguia", "Burro", "Borboleta", "Cachorro", "Cabra", "Carneiro", "Camelo", "Cobra", "Coelho", "Cavalo", "Elefante", "Galo", "Gato", "Jacare", "Leao", "Macaco", "Porco", "Pavao", "Peru", "Touro", "Tigre", "Urso", "Veado", "Vaca"};
        String[] bichos_sorteados = {"", ""};

        for (int i = 0; i < 2; i++) {
            dezenas[i] = String.valueOf(milhar.charAt(i));
            dezenas[i] += milhar.charAt(i + 1);
        }

        System.out.println(dezenas[0]);
        System.out.println(dezenas[1]);

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

        System.out.println("Milhar sorteado: "+milhar);
        System.out.println("Bicho 1: "+bichos_sorteados[0]);
        System.out.println("Bicho 2: "+bichos_sorteados[1]);
    }

    public static void formAposta() {
        Apostador apostador = new Apostador("", "");
        Aposta aposta = new Aposta(0, "", apostador);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o apostador:");
        System.out.println("=========================================");

        List<Apostador> apostadores = JDBC.getAll(apostador);

        for (Apostador apostador_each : apostadores) {
            System.out.println(apostador_each.getId() + " - " + apostador_each.getNome());
        }

        System.out.println("=========================================");
        System.out.print("Sua escolha: ");
        int apostador_id = scanner.nextInt();
        for (Apostador apostador_select : apostadores) {
            if (apostador_select.getId() == apostador_id) {
                aposta.setApostador(apostador_select);
            }
        }
        System.out.print("\nMilhar (aposta):");
        aposta.setNumero_aposta(scanner.nextLine());

        JDBC.insert(aposta);
    }

    public static void formApostador() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = (scanner.nextLine());
        System.out.print("\nTelefone: ");
        String telefone = (scanner.nextLine());

        Apostador apostador = new Apostador(nome, telefone);

        JDBC.insert(apostador);
    }
}
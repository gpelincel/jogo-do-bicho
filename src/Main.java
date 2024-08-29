import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        JDBC.testJDBC();

        int option;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("===== JOGO DO BICHO ======");
            System.out.println("1 - Apostar em um grupo");
            System.out.println("2 - Cadastrar apostador");
            System.out.println("0 - Sair");
            System.out.println("\n");
            System.out.print("Sua opcao: ");
            option = scanner.nextInt();

            switch (option){
                case 1:
                    System.out.println("\n");
                    System.out.println("===== CADASTRAR APOSTA =====");
                    formAposta();
                    break;

                case 2:
                    System.out.println("===== CADASTRAR APOSTADOR =====");
                    formApostador();
                    break;
            }
        } while (option == 0);
    }

    public static void formAposta(){
        Apostador apostador = new Apostador("", "");
        Aposta aposta = new Aposta(0, "", apostador);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o apostador:");
        System.out.println("=========================================");

        List<Apostador> apostadores = JDBC.getAll(apostador);

        for (Apostador apostador_each : apostadores){
            System.out.println(apostador_each.getId_apostador() + " - "+ apostador_each.getNome());
        }

        System.out.println("=========================================");
        System.out.print("Milhar: ");
        aposta.setNumero_aposta(scanner.next());
        System.out.println(aposta);
    }

    public static void formApostador(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = (scanner.next());
        System.out.print("Telefone: ");
        String telefone = (scanner.next());

        Apostador apostador = new Apostador(nome, telefone);

        JDBC.insert(apostador);
    }
}
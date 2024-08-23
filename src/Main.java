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
        Apostador apostador = null;
        Aposta aposta = new Aposta(0, "", apostador);
        Scanner scanner = new Scanner(System.in);

        System.out.print("Milhar: ");
        aposta.setNumero_aposta(scanner.next());
        System.out.println(aposta);
    }

    public static void formApostador(){
        Apostador apostador = new Apostador(0, "");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do apostador: ");
        apostador.setNome(scanner.next());
        System.out.println(apostador);
    }
}
import java.util.Scanner;


public class TelaInicial {

    // Método para exibir a tela inicial
    public void exibirTelaInicial() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Echo of Silence ===");
        System.out.println("Bem-vindo ao jogo!");
        System.out.println("[1] Jogar");
        System.out.print("Pressione 1 para começar: ");

        int opcao = scanner.nextInt();

        if (opcao == 1) {
            Login login = new Login();
            login.exibirTelaLogin();
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            exibirTelaInicial();
        }
    }
}
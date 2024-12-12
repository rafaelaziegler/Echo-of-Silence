import java.util.Scanner;

public class Menu {
    private final Morgana protagonista;

    public Menu() {
        protagonista = new Morgana("Morgana", 100, 50);
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Iniciar Jogo");
            System.out.println("2. Continuar Jogo");
            System.out.println("3. Ler Pistas Coletadas");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> iniciarJogo();
                case 2 -> continuarJogo();
                case 3 -> lerPistas();
                case 4 -> System.out.println("Saindo do jogo...");
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 4);
    }

    private void iniciarJogo() {
        System.out.println("Iniciando o jogo...");
        System.out.println("Você está na entrada da Escola West Ville...");
        protagonista.interagir();
    }

    private void continuarJogo() {
        System.out.println("Carregando progresso...");
    }

    private void lerPistas() {
        System.out.println("Pistas coletadas até agora:");
        System.out.println("- Bilhete com mensagens de bullying");
        System.out.println("- Diário de Cassandra");
    }
}

import java.util.Scanner;

public class JogoPrincipal implements InterfaceJogo {
    private final Morgana protagonista; 
    private final Cassandra criatura;  
    private boolean jogoEmAndamento;

    public JogoPrincipal() {
        protagonista = new Morgana("Morgana", 100, 50);
        criatura = new Cassandra("Cassandra", 100, true); 
        jogoEmAndamento = true;
    }

    @Override
    public void iniciar() {
        exibirTelaInicial(); 

        System.out.println("Bem-vindo ao jogo!");
        Login login = new Login(); 
          login.exibirTelaLogin();


        exibirIntroducao();
        iniciarLabirinto();
    }

    private void exibirTelaInicial() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Echo of Silence ===");
            System.out.println("Bem-vindo ao jogo!");
            System.out.println("[1] Jogar");
            System.out.print("Pressione 1 para começar: ");

            int opcao = scanner.nextInt();
            if (opcao == 1) break;

            System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private void exibirIntroducao() {
        System.out.println("Você é Morgana, uma jovem em busca de respostas sobre a morte de sua melhor amiga, Cassandra.");
        System.out.println("Sua investigação a leva à Escola West Ville, um lugar sombrio e cheio de segredos.");
        System.out.println("Seu objetivo é descobrir o que aconteceu com Cassandra e sair deste lugar.");
    }

    private void iniciarLabirinto() {
        Scanner scanner = new Scanner(System.in);

        while (jogoEmAndamento) {
            System.out.println("\nVocê está no labirinto da Escola West Ville...");
            System.out.println("Escolha sua ação:");
            System.out.println("1. Avançar");
            System.out.println("2. Procurar pistas");
            System.out.println("3. Fugir da criatura");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1 -> avancar();
                case 2 -> procurarPistas();
                case 3 -> fugir();
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void avancar() {
        System.out.println("Você avança pelos corredores escuros...");
        criatura.interagir();
        if (criatura.isAgressiva()) {
            System.out.println("A criatura se aproxima rapidamente!");
            if (protagonista.getEnergia() > 0) {
                protagonista.reduzirEnergia(20);
                System.out.println("Você conseguiu escapar, mas perdeu energia! Energia atual: " + protagonista.getEnergia());
            } else {
                System.out.println("Você não conseguiu escapar. Fim de jogo.");
                jogoEmAndamento = false;
            }
        } else {
            System.out.println("O espírito de Cassandra observa você de longe...");
        }
        verificarFimDeJogo();
    }

    private void procurarPistas() {
        System.out.println("Você encontra uma pista:");
        System.out.println("- Bilhete com mensagens de bullying contra Cassandra.");
        protagonista.aumentarCoragem(10);
        System.out.println("Sua coragem aumenta! Coragem atual: " + protagonista.getCoragem());
        verificarFimDeJogo();
    }

    private void fugir() {
        System.out.println("Você tenta fugir...");
        if (Math.random() > 0.5) {
            System.out.println("Você conseguiu se esconder da criatura!");
        } else {
            System.out.println("A criatura encontrou você!");
            protagonista.reduzirEnergia(30);
            System.out.println("Você perdeu energia! Energia atual: " + protagonista.getEnergia());
        }
        verificarFimDeJogo();
    }

    private void verificarFimDeJogo() {
        if (protagonista.getEnergia() <= 0) {
            System.out.println("Você não conseguiu sobreviver. Fim de jogo.");
            jogoEmAndamento = false;
        }

        if (protagonista.getCoragem() >= 100) {
            descobrirVerdade();
        }
    }

    private void descobrirVerdade() {
        System.out.println("\nVocê encontra uma carta no final do labirinto...");
        System.out.println("\"Querida Morgana,");
        System.out.println("Eu não aguentava mais a dor e o sofrimento. Elas me atacavam todos os dias, verbalmente e fisicamente. Eu sentia que não havia saída. Por isso, decidi que era melhor desaparecer.\"");
        System.out.println("A carta menciona os nomes das garotas que praticaram bullying contra Cassandra. Elas eram cruéis e insensíveis, ignorando completamente os sentimentos dela.");
        System.out.println("\nAo ler a carta, você sente uma onda de compreensão e tristeza profunda.");
        System.out.println("A alma de Cassandra é libertada, e você finalmente encontra a saída do labirinto.");
        System.out.println("\nParabéns, você terminou o jogo e descobriu a verdade.");
        jogoEmAndamento = false;
    }

    @Override
    public void salvarProgresso() {
        System.out.println("Progresso salvo com sucesso!");
    }

    @Override
    public void carregarProgresso() {
        System.out.println("Progresso carregado.");
    }

    public static void main(String[] args) {
        JogoPrincipal jogo = new JogoPrincipal();
        jogo.iniciar();
    }
}

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Login {

    public boolean autenticar(String login, String senha) {
        try (Scanner leitor = new Scanner(new File("usuarios.txt"))) {
            while (leitor.hasNextLine()) {
                String[] credenciais = leitor.nextLine().split(",");
                if (credenciais[0].equals(login) && credenciais[1].equals(senha)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao acessar arquivo de usuários: " + e.getMessage());
        }
        return false; // Retorna false se não encontrar as credenciais
    }
    


    public void exibirTelaLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Tela de Login ===");
        System.out.print("Digite seu login: ");
        String login = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        if (autenticar(login, senha)) {
            System.out.println("Login bem-sucedido. Bem-vindo!");
        } else {
            System.out.println("Credenciais inválidas. Deseja se cadastrar? (S/N)");
            String resposta = scanner.nextLine().toUpperCase();
            if (resposta.equals("S")) {
                cadastrarUsuario();
            } else {
                System.out.println("Tente novamente.");
                exibirTelaLogin();
            }
        }
    }

    public void cadastrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n=== Cadastro de Usuário ===");
        System.out.print("Digite seu nome de usuário: ");
        String usuario = scanner.nextLine();
    
        String senha, confirmacaoSenha;
        do {
            System.out.print("Digite sua senha: ");
            senha = scanner.nextLine();
            System.out.print("Confirme sua senha: ");
            confirmacaoSenha = scanner.nextLine();
    
            if (!senha.equals(confirmacaoSenha)) {
                System.out.println("As senhas não coincidem. Tente novamente.");
            }
        } while (!senha.equals(confirmacaoSenha));
    
        try (FileWriter escritor = new FileWriter("usuarios.txt", true)) {
            escritor.write(usuario + "," + senha + "\n");
            System.out.println("Usuário cadastrado com sucesso!");
            exibirTelaLogin();
        } catch (Exception e) {
            System.out.println("Erro ao salvar o cadastro: " + e.getMessage());
        }
    }
}
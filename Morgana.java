public class Morgana extends Personagem {
    private int coragem;

    public Morgana(String nome, int energia, int coragem) {
        super(nome, energia);
        this.coragem = coragem;
    }

    public int getCoragem() {
        return coragem;
    }

    public void aumentarCoragem(int valor) {
        coragem += valor;
    }

    @Override
    public void interagir() {
        System.out.println("Morgana está investigando o ambiente...");
    }
}
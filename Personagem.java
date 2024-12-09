public abstract class Personagem {
    private final String nome; // Tornado final
    private int energia;

    public Personagem(String nome, int energia) {
        this.nome = nome;
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public int getEnergia() {
        return energia;
    }

    public void reduzirEnergia(int dano) {
        energia -= dano;
    }

    public void aumentarEnergia(int valor) {
        energia += valor;
    }

    public abstract void interagir();
}

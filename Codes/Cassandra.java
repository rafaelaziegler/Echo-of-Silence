public class Cassandra extends Personagem {
    private boolean agressiva;

    public Cassandra(String nome, int energia, boolean agressiva) {
        super(nome, energia);
        this.agressiva = agressiva;
    }

    public void alternarEstado() {
        agressiva = !agressiva;
    }

    @Override
    public void interagir() {
        if (agressiva) {
            System.out.println("O espírito de Cassandra está atacando!");
        } else {
            System.out.println("O espírito de Cassandra observa silenciosamente...");
        }
    }

    public boolean isAgressiva() {
        return agressiva;
    }
}
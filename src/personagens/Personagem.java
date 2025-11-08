package personagens;

public abstract class Personagem {
    protected String nome;
    protected int vida;
    protected int forca;
    protected int defesa;
    protected boolean defendendo = false;

    public Personagem(String nome, int vida, int forca, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public abstract void atacar(Personagem alvo);
    public abstract void defender();
    public abstract void curar();

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }
}

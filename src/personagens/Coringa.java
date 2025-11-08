package personagens;

import java.util.Random;

public class Coringa extends Vilao {
    public Coringa() {
        super("Coringa", 65, 15, 6);
    }

    @Override
    public void atacar(Personagem heroi) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(8);
        heroi.vida -= dano;
        System.out.println("💣 " + nome + " jogou uma bomba de gás do riso causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🎭 " + nome + " riu insanamente e confundiu o inimigo!");
    }

    @Override
    public void curar() {
        int cura = 5;
        vida += cura;
        System.out.println("🃏 " + nome + " se animou e recuperou " + cura + " de vida!");
    }

    @Override
    public void agir(Personagem heroi) {
        Random rand = new Random();
        int acao = rand.nextInt(3);
        switch (acao) {
            case 0:
                atacar(heroi);
                break;
            case 1: 
                defender();
                break;
            case 2: 
                curar();
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}

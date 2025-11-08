package personagens;

import java.util.Random;

public class Garou extends Vilao {
    public Garou() {
        super("Garou", 90, 22, 8);
    }

    @Override
    public void atacar(Personagem heroi) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(10);
        heroi.vida -= dano;
        System.out.println("💥 " + nome + " usou artes marciais monstruosas causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🌀 " + nome + " desviou com reflexos sobre-humanos!");
    }

    @Override
    public void curar() {
        int cura = 10;
        vida += cura;
        System.out.println("🔥 " + nome + " se fortaleceu e recuperou " + cura + " de vida!");
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

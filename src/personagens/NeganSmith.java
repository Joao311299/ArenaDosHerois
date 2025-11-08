package personagens;

import java.util.Random;

public class NeganSmith extends Vilao {
    public NeganSmith() {
        super("Negan Smith", 80, 17, 7);
    }

    @Override
    public void atacar(Personagem heroi) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(6);
        heroi.vida -= dano;
        System.out.println("🏏 " + nome + " atacou com Lucille causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🧥 " + nome + " se escondeu atrás de seus capangas!");
    }

    @Override
    public void curar() {
        int cura = 6;
        vida += cura;
        System.out.println("🩸 " + nome + " descansou e recuperou " + cura + " de vida!");
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

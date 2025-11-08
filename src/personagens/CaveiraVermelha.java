package personagens;

import java.util.Random;

public class CaveiraVermelha extends Vilao {
    public CaveiraVermelha() {
        super("Caveira Vermelha", 75, 18, 7);
    }

    @Override
    public void atacar(Personagem heroi) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(6);
        heroi.vida -= dano;
        System.out.println("☠️ " + nome + " usou a arma Hydra causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🧥 " + nome + " se protegeu atrás de tecnologia Hydra!");
    }

    @Override
    public void curar() {
        int cura = 7;
        vida += cura;
        System.out.println("🧬 " + nome + " usou soro experimental e curou " + cura + " de vida!");
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

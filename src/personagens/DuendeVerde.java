package personagens;

import java.util.Random;

public class DuendeVerde extends Vilao {
    public DuendeVerde() {
        super("Duende Verde", 70, 16, 6);
    }

    @Override
    public void atacar(Personagem heroi) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(8);
        heroi.vida -= dano;
        System.out.println("🎃 " + nome + " lançou uma g de abóbora causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🛶 " + nome + " manobrou seu planador para evitar o ataque!");
    }

    @Override
    public void curar() {
        int cura = 7;
        vida += cura;
        System.out.println("🧪 " + nome + " injetou soro verde e recuperou " + cura + " de vida!");
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

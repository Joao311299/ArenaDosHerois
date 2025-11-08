package personagens;

import java.util.Random;

public class HomemAranha extends Heroi {
    public HomemAranha() {
        super("Homem-Aranha", 80, 17, 8);
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(7);
        inimigo.vida -= dano;
        System.out.println("🕸️ " + nome + " lançou teias rápidas causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🤸 " + nome + " desviou agilmente do próximo ataque!");
    }

    @Override
    public void curar() {
        int cura = 7;
        vida += cura;
        System.out.println("🕷️ " + nome + " se recuperou rapidamente de ferimentos menores!");
    }
}

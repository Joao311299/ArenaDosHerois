package personagens;

import java.util.Random;

public class CapitaoAmerica extends Heroi {
    public CapitaoAmerica() {
        super("Capitão América", 85, 18, 10);
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(8);
        inimigo.vida -= dano;
        System.out.println("🛡️ " + nome + " lançou seu escudo e causou " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🦅 " + nome + " ergueu o escudo e reduzirá o próximo dano!");
    }

    @Override
    public void curar() {
        int cura = 10;
        vida += cura;
        System.out.println("💪 " + nome + " recuperou " + cura + " de vida através da força de vontade!");
    }
}

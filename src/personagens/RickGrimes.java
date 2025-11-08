package personagens;

import java.util.Random;

public class RickGrimes extends Heroi {
    public RickGrimes() {
        super("Rick Grimes", 70, 15, 7);
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(6);
        inimigo.vida -= dano;
        System.out.println("🔫 " + nome + " atirou com seu revolver causando " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🧱 " + nome + " se escondeu atrás de uma barricada para se proteger!");
    }

    @Override
    public void curar() {
        int cura = 6;
        vida += cura;
        System.out.println("💊 " + nome + " usou um kit médico e recuperou " + cura + " de vida!");
    }
}

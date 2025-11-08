package personagens;

import java.util.Random;

public class Batman extends Heroi {
    public Batman() {
        super("Batman", 75, 16, 9);
    }

    @Override
    public void atacar(Personagem inimigo) {
        Random rand = new Random();
        int dano = forca + rand.nextInt(6);
        inimigo.vida -= dano;
        System.out.println("🦇 " + nome + " atacou com golpes rápidos e causou " + dano + " de dano!");
    }

    @Override
    public void defender() {
        defendendo = true;
        System.out.println("🛡️ " + nome + " usou um gadget para bloquear o próximo ataque!");
    }

    @Override
    public void curar() {
        int cura = 8;
        vida += cura;
        System.out.println("🩹 " + nome + " aplicou primeiros socorros e recuperou " + cura + " de vida!");
    }
}

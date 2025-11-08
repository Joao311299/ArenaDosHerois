package personagens;



public class Saitama extends Heroi {
    public Saitama() {
        super("Saitama", 9999, 9999, 9999);
    }

    @Override
    public void atacar(Personagem inimigo) {
        inimigo.vida = 0;
        System.out.println("👊 Saitama deu um soco e derrotou " + inimigo.getNome() + " instantaneamente!");
    }

    @Override
    public void defender() {
        System.out.println("😐 Saitama nem precisa se defender...");
    }

    @Override
    public void curar() {
        System.out.println("🧘 Saitama está sempre 100% — não há necessidade de cura!");
    }
}

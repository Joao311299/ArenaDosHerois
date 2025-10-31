import java.util.Random;
import java.util.Scanner;

// Classe base para personagens
class Personagem {
    String nome;
    int vida;
    int forca;
    int defesa;
    boolean defendendo = false;

    public Personagem(String nome, int vida, int forca, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.forca = forca;
        this.defesa = defesa;
    }

    public boolean estaVivo() {
        return vida > 0;
    }
}

// Classe para o herói
class Heroi extends Personagem {

    public Heroi(String nome, int vida, int forca, int defesa) {
        super(nome, vida, forca, defesa);
    }

    public void atacar(Personagem inimigo) {
        Random rand = new Random();
        int dano = this.forca + rand.nextInt(5);
        if (inimigo.defendendo) {
            dano -= inimigo.defesa;
            inimigo.defendendo = false;
            if (dano < 0) dano = 0;
        }
        inimigo.vida -= dano;
        System.out.println(nome + " atacou " + inimigo.nome + " causando " + dano + " de dano!");
    }

    public void defender() {
        defendendo = true;
        System.out.println(nome + " está se defendendo e reduzirá o próximo dano!");
    }

    public void curar() {
        int cura = 10;
        vida += cura;
        System.out.println(nome + " recuperou " + cura + " de vida!");
    }
}

// Classe para o inimigo
class Inimigo extends Personagem {

    public Inimigo(String nome, int vida, int forca, int defesa) {
        super(nome, vida, forca, defesa);
    }

    public void agir(Personagem heroi) {
        Random rand = new Random();
        int acao = rand.nextInt(3); // 0 atacar, 1 defender, 2 curar

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
        }
    }

    public void atacar(Personagem heroi) {
        Random rand = new Random();
        int dano = this.forca + rand.nextInt(4);
        if (heroi.defendendo) {
            dano -= heroi.defesa;
            heroi.defendendo = false;
            if (dano < 0) dano = 0;
        }
        heroi.vida -= dano;
        System.out.println(nome + " atacou " + heroi.nome + " causando " + dano + " de dano!");
    }

    public void defender() {
        defendendo = true;
        System.out.println(nome + " está se defendendo!");
    }

    public void curar() {
        int cura = 8;
        vida += cura;
        System.out.println(nome + " recuperou " + cura + " de vida!");
    }
}

// Classe principal
public class ArenaDosHerois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("⚔️  Bem-vindo à Arena dos Heróis ⚔️");
        System.out.print("Digite o nome do seu herói: ");
        String nomeHeroi = scanner.nextLine();

        Heroi heroi = new Heroi(nomeHeroi, 60, 15, 5);

        String[] nomesInimigos = {"Goblin", "Orc", "Troll", "Cavaleiro Sombrio", "Look"};
        String nomeInimigo = nomesInimigos[rand.nextInt(nomesInimigos.length)];
        Inimigo inimigo = new Inimigo(nomeInimigo, 50, 12, 3);

        System.out.println("\nUm inimigo apareceu: " + inimigo.nome + "!");
        System.out.println("Prepare-se para a batalha!\n");

        while (heroi.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\n===== STATUS =====");
            System.out.println(heroi.nome + " ➤ Vida: " + heroi.vida);
            System.out.println(inimigo.nome + " ➤ Vida: " + inimigo.vida);

            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Curar");
            System.out.println("4 - Fugir da batalha");
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    heroi.atacar(inimigo);
                    break;
                case 2:
                    heroi.defender();
                    break;
                case 3:
                    heroi.curar();
                    break;
                case 4:
                    System.out.println("Você fugiu da batalha!");
                    return;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            if (inimigo.estaVivo()) {
                inimigo.agir(heroi);
            } else {
                System.out.println("\n💥 " + inimigo.nome + " foi derrotado! 💥");
                break;
            }

            if (!heroi.estaVivo()) {
                System.out.println("\n☠️  " + heroi.nome + " foi derrotado!");
            }
        }

        System.out.println("\nFim da batalha!");
        scanner.close();
    }
}

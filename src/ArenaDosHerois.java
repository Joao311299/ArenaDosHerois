import personagens.*;
import java.util.*;

public class ArenaDosHerois {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("⚔️  Bem-vindo à Arena dos Heróis ⚔️");
        System.out.println("Escolha seu herói:");
        System.out.println("1 - Saitama");
        System.out.println("2 - Capitão América");
        System.out.println("3 - Batman");
        System.out.println("4 - Rick Grimes");
        System.out.println("5 - Homem-Aranha");
        System.out.print("Opção: ");
        int escolha = scanner.nextInt();

        Heroi heroi;

        switch (escolha) {
            case 1:
                heroi = new Saitama();
                break;
            case 2:
                heroi = new CapitaoAmerica();
                break;
            case 3:
                heroi = new Batman();
                break;
            case 4:
                heroi = new RickGrimes();
                break;
            case 5:
                heroi = new HomemAranha();
                break;
            default:
                System.out.println("Opção inválida, você será o Batman!");
                heroi = new Batman();
                break;
        }

        Vilao[] viloes = {
            new Garou(), new CaveiraVermelha(), new Coringa(),
            new NeganSmith(), new DuendeVerde()
        };

        Vilao vilao = viloes[rand.nextInt(viloes.length)];

        System.out.println("\n💀 Um vilão apareceu: " + vilao.getNome() + "!");
        System.out.println("Prepare-se para a batalha!\n");

        while (heroi.estaVivo() && vilao.estaVivo()) {
            System.out.println("\n===== STATUS =====");
            System.out.println(heroi.getNome() + " ➤ Vida: " + heroi.getVida());
            System.out.println(vilao.getNome() + " ➤ Vida: " + vilao.getVida());

            System.out.println("\nEscolha uma ação:");
            System.out.println("1 - Atacar");
            System.out.println("2 - Defender");
            System.out.println("3 - Curar");
            System.out.println("4 - Fugir");
            System.out.print("Opção: ");
            int acao = scanner.nextInt();

            switch (acao) {
                case 1:
                    heroi.atacar(vilao);
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

            if (vilao.estaVivo()) {
                vilao.agir(heroi);
            } else {
                System.out.println("\n💥 " + vilao.getNome() + " foi derrotado!");
                break;
            }

            if (!heroi.estaVivo()) {
                System.out.println("\n☠️  " + heroi.getNome() + " foi derrotado!");
            }
        }

        System.out.println("\n🏁 Fim da batalha!");
        scanner.close();
    }
}

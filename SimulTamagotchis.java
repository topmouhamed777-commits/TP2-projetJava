import java.util.Scanner;

/**
 * Programme principal du TP2.
 * Cree n tamagotchis, puis enchaine des cycles vivre / nourrir
 * jusqu'a victoire (tous a l'age limite) ou defaite (un mort de faim).
 */
public class SimulTamagotchis {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);

        System.out.print("Combien de tamagotchis voulez-vous creer ?: ");
        int n = clavier.nextInt();
        clavier.nextLine();

        Tamagotchi[] colonie = new Tamagotchi[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Quel nom pour le nouveau tamagotchi : ");
            colonie[i] = new Tamagotchi(clavier.nextLine());
        }

        int numeroCycle = 1;
        boolean enCours = true;
        while (enCours) {
            System.out.println("-------Cycle no " + numeroCycle + " -------");

            for (Tamagotchi tamagotchi : colonie) {
                if (!tamagotchi.vivre()) {
                    System.out.println("PERDU !!");
                    enCours = false;
                    break;
                }
            }
            if (!enCours) {
                break;
            }

            if (tousAgeLimite(colonie)) {
                System.out.println("GAGNE !!");
                break;
            }

            afficherMenu(colonie);
            System.out.print("Nourrir quel tamagotchi ? ");
            int choix = clavier.nextInt();
            clavier.nextLine();

            if (choix >= 0 && choix < colonie.length && !colonie[choix].ageLimite()) {
                colonie[choix].manger();
            } else {
                System.out.println("Choix invalide, personne n'est nourri ce cycle.");
            }

            numeroCycle++;
        }

        clavier.close();
    }

    private static boolean tousAgeLimite(Tamagotchi[] colonie) {
        for (Tamagotchi tamagotchi : colonie) {
            if (!tamagotchi.ageLimite()) {
                return false;
            }
        }
        return true;
    }

    private static void afficherMenu(Tamagotchi[] colonie) {
        for (int i = 0; i < colonie.length; i++) {
            if (!colonie[i].ageLimite()) {
                System.out.print("(" + i + ") " + colonie[i].getNom() + " ");
            }
        }
        System.out.println();
    }
}
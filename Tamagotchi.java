public class Tamagotchi {
    private int age;
    private int dureeDeVie;
    private int maxEnergie;
    private int energie;
    private String nom;

    public Tamagotchi(String nom) {
        this.nom = nom;
        this.age = 0;
        // dureeDeVie aléatoire entre 9 et 14 inclus
        this.dureeDeVie = (int) (Math.random() * (14 - 9 + 1)) + 9;
        // maxEnergie aléatoire entre 5 et 9 inclus
        this.maxEnergie = (int) (Math.random() * (9 - 5 + 1)) + 5;
        // energie aléatoire entre 3 et maxEnergie inclus
        this.energie = (int) (Math.random() * (this.maxEnergie - 3 + 1)) + 3;
    }

    public String getNom() {
        return this.nom;
    }

    // Question 2 : parler()
    public void parler() {
        if (this.energie > 5) {
            System.out.println(this.nom + " : tout va bien !");
        } else {
            System.out.println(this.nom + " : je suis affamé !");
        }
    }

    // Question 3 : manger()
    public void manger() {
        if (this.energie >= this.maxEnergie) {
            System.out.println(this.nom + " : je n'ai pas faim !!");
        } else {
            int gain = (int) (Math.random() * 3) + 1; // entre 1 et 3
            this.energie += gain;
            if (this.energie > this.maxEnergie) {
                this.energie = this.maxEnergie;
            }
            System.out.println(this.nom + " : Merci !");
        }
    }
}

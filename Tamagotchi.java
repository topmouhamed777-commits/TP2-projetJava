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
}

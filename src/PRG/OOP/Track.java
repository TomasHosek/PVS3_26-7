package PRG.OOP;

public class Track {

    String nazev;
    int rok;
    double hodnoceni;
    int delka;

    public Track(String nazev, int rok, double hodnoceni, int delka) {

        this.nazev = nazev;
        this.rok = rok;
        this.hodnoceni = hodnoceni;
        this.delka = delka;
    }

    @Override
    public String toString() {
        return "Track{" +
                "nazev='" + nazev + '\'' +
                ", rok=" + rok +
                ", hodnoceni=" + hodnoceni +
                ", delka=" + delka +
                '}';
    }

    public void setDelka(int delka) {

        if (delka < 1) {

            System.out.println("Neplatná hodnota");
            return;
        }

        this.delka = delka;
    }

    public void setHodnoceni(double hodnoceni) {

        if (hodnoceni < 0.0 || hodnoceni > 10) {

            System.out.println("Neplatná hodnota");
            return;
        }

        this.hodnoceni = hodnoceni;
    }
}
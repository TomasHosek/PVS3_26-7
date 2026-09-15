package PRG.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

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

    public String getNazev() {
        return nazev;
    }

    public int getRok() {
        return rok;
    }

    public double getHodnoceni() {
        return hodnoceni;
    }

    public int getDelka() {
        return delka;
    }

    public static void main(String[] args) {

        DataImport di = new DataImport("data/tracks.txt");

        ArrayList<Track> list = new ArrayList<>();

        while (di.hasNext()) {

            String radek = di.readLine();

            String[] tokeny = radek.split(";");

            Track song = new Track(tokeny[0], Integer.parseInt(tokeny[1]), Double.parseDouble(tokeny[2]), Integer.parseInt(tokeny[3]));

            list.add(song);
        }
    }

    public void setRok(int rok) {

        if (rok < 0) {

            System.out.println("Neplatná hodnota");
            return;
        }

        this.rok = rok;
    }

    public void setHodnoceni(double hodnoceni) {

        if (hodnoceni < 0.0 || hodnoceni > 10) {

            System.out.println("Neplatná hodnota");
            return;
        }

        this.hodnoceni = hodnoceni;
    }

    public void setDelka(int delka) {

        if (delka < 1) {

            System.out.println("Neplatná hodnota");
            return;
        }

        this.delka = delka;
    }
}
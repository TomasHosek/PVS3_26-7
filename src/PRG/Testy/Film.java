package PRG.Testy;

import fileworks.DataExport;
import fileworks.DataImport;

public class Film {

    String nazev;
    int rokVydani;
    String zanr;
    double rating;

    public Film(String nazev, int rokVydani, String zanr, double rating) {

        this.nazev = nazev;
        this.rokVydani = rokVydani;
        this.zanr = zanr;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Film{" +
                "nazev='" + nazev + '\'' +
                ", rokVydani=" + rokVydani +
                ", zanr='" + zanr + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getNazev() {
        return nazev;
    }

    public int getRokVydani() {
        return rokVydani;
    }

    public String getZanr() {
        return zanr;
    }

    public double getRating() {
        return rating;
    }

    public static void main(String[] args) {

        DataImport di = new DataImport("data/movieList.txt");
        DataExport de = new DataExport("data/horrors.txt");

        double nejvetsiRating = 0.0;
        int pocetFilmuPoRoce2000 = 0;

        Film nejlepsiFilm = new Film(null, 0, null, 0.0);

        while (di.hasNext()) {

            String radek = di.readLine();

            String[] tokeny = radek.split(";");

            Film film = new Film(tokeny[0], Integer.parseInt(tokeny[1]), tokeny[2], Double.parseDouble(tokeny[3]));

            if (film.rating > nejlepsiFilm.rating) {

                nejlepsiFilm = film;
            }

            if (film.rokVydani > 2000) {

                pocetFilmuPoRoce2000 ++;
            }

            if (film.zanr.equalsIgnoreCase("horror")) {

                de.writeLine(film.toString());
            }
        }

        System.out.println(pocetFilmuPoRoce2000);
        System.out.println("Film s největším ratingem: " + nejlepsiFilm);

        di.finishImport();
        de.finishExport();
    }
}
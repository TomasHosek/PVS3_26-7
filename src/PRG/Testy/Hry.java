package PRG.Testy;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Hry {
    static void main(String[] args) {

        DataImport di = new DataImport("data/steam_games.txt");

        ArrayList<Game> hry = new ArrayList<>();

        String line;
        String[] tokeny;

        while (di.hasNext()) {

            line = di.readLine();
            tokeny = line.split("\t");

            if (tokeny.length == 3) {

                hry.add(new Game(tokeny[0], Double.parseDouble(tokeny[1]), Integer.parseInt(tokeny[2])));
            }

            else {

                hry.add(new Game(tokeny[0], Double.parseDouble(tokeny[1]), Integer.parseInt(tokeny[2]), tokeny[3]));
            }
        }

        System.out.println("Počet her: " + hry.size() + "\n");
        System.out.println("Počet placených her: " + PaidGamesCount(hry) + "\n");
        System.out.println("Počet her zdarma: " + FreeGamesCount(hry) + "\n");
        System.out.println("Nejdražší hra: " + MostExpensiveGame(hry) + "\n");
        System.out.printf("Průměrný počet hodnocení: %.2f\n\n", AvgReviewPerGame(hry) );

        di.finishImport();
    }

    static Game MostExpensiveGame(List<Game> hry) {

        Game nejdrazsihra = new Game(null, 0.0, 0, null);

        for (int i = 0; i < hry.size(); i++) {

            Game hra = hry.get(i);

            if (hra.price > nejdrazsihra.price) {

                nejdrazsihra = hra;
            }
        }

        return nejdrazsihra;
    }

    static int FreeGamesCount(List<Game> hry) {

        int pocetHerZdarma = 0;

        for (int i = 0; i < hry.size(); i++) {

            Game hra = hry.get(i);

            if (hra.price == 0.0) {

                pocetHerZdarma++;
            }
        }

        return pocetHerZdarma;
    }

    static int PaidGamesCount(List<Game> hry) {

        int pocetPlacenychHer = 0;

        for (int i = 0; i < hry.size(); i++) {

            Game hra = hry.get(i);

            if (hra.price != 0.0) {

                pocetPlacenychHer++;
            }
        }

        return pocetPlacenychHer;
    }

    static double AvgReviewPerGame(List<Game> hry) {

        double pocetRecenzi = 0;

        for (int i = 0; i < hry.size(); i++) {

            Game hra = hry.get(i);

            pocetRecenzi += hra.reviewsCount;
        }

        double avgReviewPerGame = pocetRecenzi/hry.size();

        return avgReviewPerGame;
    }
}

class Game {
    String name;
    double price;
    int reviewsCount;
    String description;

    public Game(String name, double price, int reviewsCount, String description) {

        this(name, price, reviewsCount);
        this.description = description;
    }

    public Game(String name, double price, int reviewsCount) {

        this.name = name;
        this.price = price;
        this.reviewsCount = reviewsCount;

        if (price == 0.0) {

            description = "Not released yet";
        }

        else {

            description = "N/A";
        }
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getReviewsCount() {
        return reviewsCount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return STR."'\{name}', price = \{price}, reviewsCount = \{reviewsCount}, description = '\{description}'";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReviewsCount(int reviewsCount) {
        this.reviewsCount = reviewsCount;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
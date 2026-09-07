package PRG.Basics;

import fileworks.DataImport;

public class Country {
    public Country(String name, String continent, Long population, Double avgAge) {
    }

    public static void main(String[] args) {

        String path = "data/countries.txt";

        DataImport di = new DataImport(path);

        Country czechia = new Country("Czech Republic", "Europe", 10_800_000L, 85.0);

        String line = di.readLine();
        String[] tokeny = line.split(";");

        String name = tokeny[0];
        String continent = tokeny[1];
        long population = Long.parseLong(tokeny[2]);
        double avgAge = Double.parseDouble(tokeny[3]);

        Country oneCountry = new Country(name, continent, population, avgAge);

        System.out.println(oneCountry);

        di.finishImport();
    }
}
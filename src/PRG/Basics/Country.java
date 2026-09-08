package PRG.Basics;

import fileworks.DataImport;

public class Country {

    String name, continent;
    long population;
    double avgAge;

    public Country(String name, String continent, long population, double avgAge) {

        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }

    public static void main(String[] args) {

        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        Country czechia = new Country("Czech Republic", "Europe", 10_800_000, 85.0);

        String line = di.readLine();
        String[] tokeny = line.split(";");
        String name = tokeny[0];
        String continent = tokeny[1];
        long population = Long.parseLong(tokeny[2]);
        double avgAge = Double.parseDouble(tokeny[3]);

        Country oneCountry = new Country(name, continent, population, avgAge);

        di.finishImport();
    }

    public String toString() {

        return name;
    }
}
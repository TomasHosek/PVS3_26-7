package PRG.OOP;

import  basics.Country;
import fileworks.DataImport;

public class CountryExamples {
    public static void main(String[] args) {

        DataImport di = new DataImport("data/countries.txt");

        while (di.hasNext()) {

            String line = di.readLine();
            String[] data = line.split(";");

            String nazev = data[0];
            String kontinent = data[1];
            long populace = Long.parseLong(data[2]);
            double avgAge = Double.parseDouble(data[3]);

            Country country = new Country(nazev, kontinent, populace, avgAge);

            System.out.println(country);
        }

        di.finishImport();
    }
}
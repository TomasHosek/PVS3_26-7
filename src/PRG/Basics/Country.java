package PRG.Basics;

import fileworks.DataImport;

public class Country {
    public static void main(String[] args) {

        String path = "data/countries.txt";

        DataImport di = new DataImport(path);

        Long nejmensiPopulace = 99999999999999l;
        Double nejvetsiAvgAge = 0.0;

        while (di.hasNext()) {

            String radek = di.readLine();

            Long populace = Long.parseLong(radek.split(";")[2]);

            if (populace < nejmensiPopulace) {

                nejmensiPopulace = populace;
            }

            double avgAge = Double.parseDouble(radek.split(";")[3]);

            if (avgAge > nejvetsiAvgAge) {

                nejvetsiAvgAge = avgAge;
            }
        }

        System.out.println(nejmensiPopulace);
        System.out.println(nejvetsiAvgAge);
    }
}
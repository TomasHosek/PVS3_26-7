package PRG.Basics;

import fileworks.DataImport;

import java.io.IOException;

public class ParseFile {
    public static void main(String[] args) throws IOException {

        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        String name;
        String continent;
        long population;
        double avgAge;

        di.reinitializeRead();

        int radky = 0;

        while (di.hasNext()) {

            System.out.println(di.readLine());
        }

        di.finishImport();
    }
}
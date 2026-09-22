package PRG.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

class Product {

    String name;
    String category;
    int ammount;
    double pricePerPiece;

    private final String defaultCategory = "Other";

    // GETTERY

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmmount() {
        return ammount;
    }

    // SETTERY

    public void setAmmount(int ammount) {

        if (ammount > 0) {

            this.ammount = ammount;
        }

        else {

            this.ammount = 0;
        }
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(double pricePerPiece) {

        if (pricePerPiece > 0) {

            this.pricePerPiece = pricePerPiece;
        }

        else {

            this.pricePerPiece = 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", ammount=" + ammount +
                ", pricePerPiece=" + pricePerPiece +
                '}';
    }

    public Product(String name, String category) {

        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, int ammount) {

        this(name, category);
        this.ammount = ammount;
    }

    public Product(String name, int ammount, double pricePerPiece) {

        this.name = name;
        this.ammount = ammount;
        this.pricePerPiece = pricePerPiece;
    }

    public Product(String name, String category, int ammount, double pricePerPiece) {

        this(name, category, ammount);
        this.pricePerPiece = pricePerPiece;
    }
}

public class Products {

    static void main(String[] args) {

        DataImport di = new DataImport("data/products.txt");

        ArrayList<Product> produkty = new ArrayList<>();

        while (di.hasNext()) {

            String line = di.readLine();
            String[] tokeny = line.split(";");

            if (tokeny.length == 2) {

                Product zbozi = new Product(tokeny[0], tokeny[1]);

                produkty.add(zbozi);
            }

            else if (tokeny.length == 3) {

                Product zbozi = new Product(tokeny[0], tokeny[1], Integer.parseInt(tokeny[2]));

                produkty.add(zbozi);
            }

            else if (tokeny.length == 4) {

                Product zbozi = new Product(tokeny[0], tokeny[1], Integer.parseInt(tokeny[2]), Double.parseDouble(tokeny[3]));

                produkty.add(zbozi);
            }
        }

        System.out.println("Počet produktů: " + produkty.size());

        Product product = new Product("Chair", 400, 0.0);

        di.finishImport();
    }
}
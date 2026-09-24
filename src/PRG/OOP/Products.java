package PRG.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

class Product {

    String name;
    String category;
    int amount;
    double pricePerPiece;

    private final String defaultCategory = "Other";

    // GETTERY a SETTERY

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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {

        if (amount > 0) {

            this.amount = amount;
        }

        else {

            this.amount = 0;
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
                ", ammount=" + amount +
                ", pricePerPiece=" + pricePerPiece +
                '}';
    }

    public Product(String name, String category) {

        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, int amount) {

        this(name, category);
        this.amount = amount;
    }

    public Product(String name, int amount, double pricePerPiece) {

        this.name = name;
        this.amount = amount;
        this.pricePerPiece = pricePerPiece;
    }

    public Product(String name, String category, int amount, double pricePerPiece) {

        this(name, category, amount);
        this.pricePerPiece = pricePerPiece;
    }
}

public class Products {

    static void main(String[] args) {

        DataImport di = new DataImport("data/products.txt");
        ArrayList<Product> produkty = new ArrayList<>();
        Product zbozi;

        while (di.hasNext()) {

            String line = di.readLine();
            String[] tokeny = line.split(";");

            if (tokeny.length == 2) {

                zbozi = new Product(tokeny[0], tokeny[1]);

                produkty.add(zbozi);
            }

            else if (tokeny.length == 3) {

                zbozi = new Product(tokeny[0], tokeny[1], Integer.parseInt(tokeny[2]));

                produkty.add(zbozi);
            }

            else if (tokeny.length == 4) {

                zbozi = new Product(tokeny[0], tokeny[1], Integer.parseInt(tokeny[2]), Double.parseDouble(tokeny[3]));

                produkty.add(zbozi);
            }
        }

        System.out.println("Počet produktů: " + produkty.size());

        Product product = new Product("Chair", 400, 0.0);

        System.out.println(product.getName() + ": " + product.getAmount());
        System.out.println(product.toString());

        di.finishImport();
    }
}
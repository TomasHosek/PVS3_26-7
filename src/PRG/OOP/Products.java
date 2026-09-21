package PRG.OOP;

import fileworks.DataImport;

class Product {

    String name;
    String category;
    int ammount;
    int pricePerPiece;

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

    public void setAmmount(int ammount) {

        if (ammount > 0) {

            this.ammount = ammount;
        }

        else {

            this.ammount = 0;
        }
    }

    public int getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(int pricePerPiece) {

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

    public Product(String name, String category, int ammount, int pricePerPiece) {


        this.pricePerPiece = pricePerPiece;
    }
}

public class Products {

    static void main(String[] args) {

        DataImport di = new DataImport("data/produscts.txt");
    }
}
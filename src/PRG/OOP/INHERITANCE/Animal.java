package PRG.OOP.INHERITANCE;

import fileworks.DataImport;

import java.util.ArrayList;

public class Animal {

    String name;
    private double energy;

    public Animal(String name, double energy) {

        this.name = name;
        this.energy = energy;
    }

    public void eat() {

        energy += Math.exp(-energy);
    }

    public void makeNoise() {

        System.out.println("Make some noise");
    }
}

class Cat extends Animal {

    public Cat(String name, double energy) {

        super(name, energy);
    }

    @Override
    public void eat() {

        super.eat();
    }

    @Override
    public void makeNoise() {

        System.out.println("Meow");
    }
}

class Dog extends Animal {

    public String breed;

    public Dog(String name, double energy) {

        super(name, energy);
    }

    public Dog(String name, double energy, String breed) {

        super(name, energy);
        this.breed = breed;
    }

    @Override
    public void eat() {

        super.eat();
    }

    @Override
    public void makeNoise() {

        System.out.println("Woof");
    }
}

class Pig extends Animal {

    int mudLevel;

    public Pig(String name, double energy, int mudLevel) {

        super(name, energy);
        this.mudLevel = mudLevel;
    }

    @Override
    public void eat() {

        super.eat();
    }

    @Override
    public void makeNoise() {

        System.out.println("Oink");
    }

    void playInMud() {

        mudLevel += 10;

        mudLevel = Math.min(mudLevel, 100);
    }
}

class Main {

    static void main() {

        DataImport di = new DataImport("data/animals.txt");

        ArrayList<Animal> animals = new ArrayList<>();

        ArrayList<Cat> cats = new ArrayList<>();
        ArrayList<Dog> dogs = new ArrayList<>();
        ArrayList<Pig> pigs = new ArrayList<>();

        while (di.hasNext()) {

            String line = di.readLine();

            String[] tokens = line.split(";");

            switch (tokens[0]) {

                case "Cat" -> animals.add(new Cat(tokens[2], Double.parseDouble(tokens[1])));

                case "Dog" -> animals.add(new Dog(tokens[2], Double.parseDouble(tokens[1]), tokens[3]));

                case "Pig" -> animals.add(new Pig(tokens[2], Double.parseDouble(tokens[1]), Integer.parseInt(tokens[4])));
            }
        }

        System.out.println(animals);

        di.finishImport();
    }
}
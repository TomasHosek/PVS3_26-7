package PRG.OOP.INHERITANCE;

public class Doctor {

    final static int BASE_SALARY = 50_000;

    String name;
    int salary;

    public Doctor(String name) {

        this.name = name;
        this.salary = BASE_SALARY;
    }

    void diagnose() {

        System.out.println("Something  is wrong with you");
        salary += 10_000;
    }
}

class Surgeon extends Doctor {

    final static int SURGEON_BONUS = 25_000;

    public Surgeon(String name) {

        super(name);
        salary += SURGEON_BONUS;
    }

    void surgery() {

        System.out.println("Cutting you open");
        salary += 20_000;
    }
}

class CardiacSurgeon extends Surgeon {

    final static int CS_BONUS = 35_000;

    public CardiacSurgeon(String name) {

        super(name);
        salary += CS_BONUS;
    }

    void cardiacSurgery() {

        System.out.println("Cutting your heart");
        salary += 30_000;
    }
}
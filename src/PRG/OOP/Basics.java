package PRG.OOP;

public class Basics {

    public Basics() {

        System.out.println("Zavolán konstruktor A");
    }

    public Basics(int a) {

        System.out.println("Zavolán konstruktor B");
    }

    public void metodaA() {

    }

    public int spucet(int a) {

        return 0;
    }

    public static void main(String[] args) {

        Basics obj1 = new Basics();
        Basics obj2 = new Basics(1);
    }
}
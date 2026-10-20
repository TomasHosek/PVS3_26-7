package PRG.OOP.INHERITANCE;

public class Hospital {

    static void main() {

        Surgeon surgeon = new Surgeon("Bob");

        surgeon.surgery();

        System.out.println(surgeon.salary);

        CardiacSurgeon cardiacSurgeon = new CardiacSurgeon("Max");

        cardiacSurgeon.cardiacSurgery();

        System.out.println(cardiacSurgeon.salary);
    }
}
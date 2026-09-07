package PRG.Basics;

public class ParseSimple {
    public static void main(String[] args) {

        String data = "This is a number:7";

        String[] tokeny = data.split(":");

        int parsedNumber = Integer.parseInt(tokeny[1]);

        System.out.println(parsedNumber);
    }
}
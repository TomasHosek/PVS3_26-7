package PRG.OOP;

import fileworks.DataImport;
import java.util.ArrayList;

public class Points {
    static void main(String[] args) {

        Point a = new Point(44.5, 22.1);
        Point b = new Point(44.5, 22.1);
        Point c = new Point(44.5, 22.1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Point.pointsCreated);

        DataImport di = new DataImport("data/points.txt");

        ArrayList<Point> body = new ArrayList<>();

        String line;
        String[] tokeny;

        while (di.hasNext()) {

            line = di.readLine();
            tokeny = line.split(",");

            switch (tokeny.length) {

                case 2 -> body.add(new Point(Double.parseDouble(tokeny[0]), Double.parseDouble(tokeny[1])));
                case 3 -> body.add(new Point(tokeny[0], Double.parseDouble(tokeny[1]), Double.parseDouble(tokeny[2])));
                case 4 -> body.add(new Point(tokeny[0], Double.parseDouble(tokeny[1]), Double.parseDouble(tokeny[2]), Double.parseDouble(tokeny[3])));
            }
        }

        di.finishImport();
    }
}

class Point {

    String name;
    double x, y, z;
    final double DEFAULT_Z = 0;
    static int pointsCreated = 1;

    public Point(String name, double x, double y, double z) {

        this(name, x, y);
        this.z = z;
    }

    public Point(String name, double x, double y) {

        this.name = name;
        this.x = x;
        this.y = y;
        this.z = DEFAULT_Z;
    }

    public Point(double x, double y) {

        this.x = x;
        this.y = y;
        this.z = DEFAULT_Z;
        this.name = "Points#" + pointsCreated;
        pointsCreated++;
    }

    @Override
    public String toString() {

        return name + "(" + x + "," + y + "," + z + ")";
    }
}
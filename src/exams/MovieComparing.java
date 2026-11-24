package exams;

//Doplnte atributy pro Film

//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach

//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {

    static void main() {

        DataImport di = new DataImport("data/Movies.txt");

        List<Movie> movies = new ArrayList<>();

        while(di.hasNext()){

            String line = di.readLine();
            String[] tokens = line.split(";");

            movies.add(new Movie(tokens[0], Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]), Integer.parseInt(tokens[3])));
        }

        printListByYear(movies);
        printListByName(movies);
        topTen(movies);
    }

    public static void topTen(List<Movie> list) {

        list.sort(Movie.BY_RATING);

        System.out.println("Top 10:");
        for (int i = 0; i < 10; i++) {

            System.out.println("\t" + list.get(i).name + " | " + list.get(i).yearOfRelease + " | " + list.get(i).rating + " | " + list.get(i).length);
        }
    }

    public static void printList(List<Movie> list) {

        System.out.println("Movies:");

        for (int i = 0; i < list.size(); i++) {

            System.out.println("Movie:");
            System.out.println("\t" + list.get(i).name + " | " + list.get(i).yearOfRelease + " | " + list.get(i).rating + " | " + list.get(i).length);
        }

        System.out.println();
    }

    public static void printListByName(List<Movie> list) {

        list.sort(Movie.BY_NAME);

        System.out.println("Movies by name:");

        for (int i = 0; i < list.size(); i++) {

            System.out.println("\t" + list.get(i).name + " | " + list.get(i).yearOfRelease + " | " + list.get(i).rating + " | " + list.get(i).length);
        }

        System.out.println();
    }

    public static void printListByYear(List<Movie> list) {

        list.sort(Movie.BY_YEAR);

        System.out.println("Movies by year:");

        for (int i = 0; i < list.size(); i++) {

            System.out.println("\t" + list.get(i).name + " | " + list.get(i).yearOfRelease + " | " + list.get(i).rating + " | " + list.get(i).length);
        }

        System.out.println();
    }
}
class Movie implements Comparable<Movie> {

    String name;
    int yearOfRelease;
    double rating;
    int length;

    public Movie(String name, int yearOfRelease, double rating, int length) {

        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.length = length;
    }

    public static final Comparator<Movie> BY_NAME = new Comparator<Movie>() {

        @Override
        public int compare(Movie m1, Movie m2) {

            return m1.name.toLowerCase().compareTo(m2.name.toLowerCase());
        }
    };

    public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {

        @Override
        public int compare(Movie m1, Movie m2) {

            if (m1.rating < m2.rating) {

                return 1;
            }

            if (m1.rating > m2.rating) {

                return -1;
            }

            else return 0;
        }
    };

    public static final Comparator<Movie> BY_YEAR = new Comparator<Movie>() {

        @Override
        public int compare(Movie m1, Movie m2) {

            if (m1.yearOfRelease > m2.yearOfRelease) {

                return 1;
            }

            if (m1.yearOfRelease < m2.yearOfRelease) {

                return -1;
            }

            else return 0;
        }
    };

    @Override
    public int compareTo(Movie o) {

        return 0;
    }
}
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class GuessTheMovie {

    public static void main(String [] args) throws Exception{
        // Added movie.txt file to scan it:
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        // Create an empty movies' array and add movie to it from the file text:
        ArrayList movies = new ArrayList();


        while(scanner.hasNextLine()){
            String movie = scanner.nextLine();
            movies.add(movie);
        }

        // Pick a random movie to guess:
        int size = movies.size();
        int randomNumber = (int) (Math.random()*size);
        System.out.println(randomNumber);
        String randomMovie = (String) movies.get(randomNumber);
        System.out.println(randomMovie);

    }
}

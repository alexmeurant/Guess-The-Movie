import java.io.File;
import java.util.Scanner;


public class GuessTheMovie {

    public static void main(String [] args) throws Exception{
        // Added movie.txt file to scan it:
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);

        // Create a movies array and add movie to it from the file text:
        int movieNumber = 0;
        String[] movies = new String[26];

        while(scanner.hasNextLine()){
            String movie = scanner.nextLine();
            movies[movieNumber] = movie;
            movieNumber++;
        }

        // Pick a random movie to guess:
        int randomNumber = (int) (Math.random()*26) + 1;
        String randomMovie = movies[randomNumber];

    }
}

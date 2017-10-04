import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class GuessTheMovie {

    public static void main(String [] args) throws Exception{
        // Added movie.txt file to scan it:
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        Scanner userGuess = new Scanner(System.in);

        // Create an empty movies' array and add movie to it from the file text:
        ArrayList movies = new ArrayList();


        while(scanner.hasNextLine()){
            String movie = scanner.nextLine();
            movies.add(movie);
        }

        // Pick a random movie to guess:
        int size = movies.size();
        int randomNumber = (int) (Math.random()*size);
        String randomMovie = (String) movies.get(randomNumber);
        String hiddenMovie = randomMovie;

        // Convert randomMovie's letters to '_':
        for (int i = 0; i < randomMovie.length(); i++){
            char movieChar = randomMovie.charAt(i);
            if (movieChar != ' ' && movieChar != ':' && movieChar != '-'){
                hiddenMovie = hiddenMovie.replace(movieChar, '_');
            }
        }

        // Invite the player to guess the random hidden movie :
        System.out.println("You are guessing: " + hiddenMovie);

        int guess = 0;
        System.out.println("You have guessed (" + guess + ") wrong letters:");
        System.out.println("Guess a letter: ");

    }
}

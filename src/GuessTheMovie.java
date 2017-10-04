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

        // Invite the player to guess the hidden movie with a max of 10 attempts:
        int wrongLetters = 0;
        int attempts = 10;
        String wrongLetter = "";

        System.out.println("You are guessing: " + hiddenMovie);
        System.out.println("You have " + attempts + " attempts.");
        System.out.println("Guess a letter: ");

        while (wrongLetters <= attempts){
            char guessCharacter = userGuess.next().charAt(0);
            
            if (randomMovie.indexOf(guessCharacter) >= 0){
                for (int i = 0; i < randomMovie.length(); i++){
                    char randomMovieChar = randomMovie.charAt(i);
                    if (randomMovieChar != ' ' && randomMovieChar != ':' && randomMovieChar != '-' && randomMovieChar != guessCharacter){
                        randomMovie = randomMovie.replace(randomMovieChar, '_');
                    }
                }
            } else {
                wrongLetters++;
                wrongLetter = wrongLetter + " " + guessCharacter;
            }

            System.out.println("You are guessing: " + randomMovie);
            System.out.println("You have guessed (" + wrongLetters + ") wrong letters: " + wrongLetter);
            System.out.println("Guess a letter: ");
        }

    }
}

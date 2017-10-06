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
        randomMovie = randomMovie.toLowerCase();
        String hiddenMovie = randomMovie;

        // Convert randomMovie's letters into '.':
        for (int i = 0; i < randomMovie.length(); i++){
            char movieChar = randomMovie.charAt(i);
            if (movieChar != ' ' && movieChar != ':' && movieChar != '-'){
                hiddenMovie = hiddenMovie.replace(movieChar, '.');
            }
        }

        // Invite the player to guess the hidden movie with a max of 10 attempts:
        int wrongLetterNumber = 0;
        int attempts = 10;
        String wrongLetter = "";

        System.out.println("You are guessing: " + hiddenMovie);
        System.out.println("You have " + attempts + " attempts.");
        System.out.println("Guess a letter: ");

        // create a mutable sequence of characters:
        StringBuilder displayMovie = new StringBuilder(hiddenMovie);

        // loop the movie title characters if max attempts is not reached:
        while (wrongLetterNumber < attempts) {
            // Player guess a letter :
            char guessCharacter = userGuess.next().charAt(0);

            // checks if the movie title contains the guess letter:
            if (randomMovie.indexOf(guessCharacter) >= 0) {
                for (int i = 0; i < hiddenMovie.length(); i++) {
                    // checks if guessed character position is equal to the movie title one:
                    if (guessCharacter == randomMovie.charAt(i)) {
                        // replace . by the guess character:
                        if (displayMovie.charAt(i) == '.') {
                            displayMovie.setCharAt(i, guessCharacter);
                        }
                    }
                }
            } else {
                if(wrongLetter.indexOf(guessCharacter) < 0){
                    wrongLetterNumber++;
                    wrongLetter += " " + guessCharacter;
                }

        }

            System.out.println("You are guessing: " + displayMovie);
            System.out.println("You have guessed (" + wrongLetterNumber + ") wrong letters: " + wrongLetter);
            System.out.println("Guess another letter: ");
        }
        // Print a message if the limit attempts number is reached:
        if (wrongLetterNumber >= attempts){
            System.out.println("You lose!!!");
        }
    }
}


package neil.mthree.excerice;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        // Ask user for number of round he would like to play

        System.out.print("How many rounds would you like to play ? ");
        Scanner inputReader = new Scanner(System.in);

        int nbRounds = inputReader.nextInt();

        //Checking for number of round to be between 1 and 10
        if (nbRounds<11 && nbRounds>0){
            int result = play(nbRounds);

            System.out.println("");
            System.out.println("");
          if (result == 0) System.out.println("Thanks for playing!");
        }
        else System.out.println("Error, invalid input");
}

    private static int play(int nbRounds) {
        int wins = 0;
        int ties = 0;
        int lost = 0;

        // Instructions for the player to play

        System.out.println("To play select 1 for Rock, 2 for Paper or 3 for Scissors");
        System.out.println("Rock win over Scissors, Paper wins over Rock and Scissors win over Paper");
        Scanner inputReader = new Scanner(System.in);

        Random randomizer = new Random();

        int round =  0;

        //While loop representing each round played until desired number is reached

        while (round < nbRounds){

            System.out.println("");
            System.out.println("What would you like to play? ");
            int playerPlay = inputReader.nextInt();

            // Checking for incorrect input

            while (playerPlay < 1 || playerPlay > 3 ){
                System.out.println("Incorrect input try again  ");
                System.out.println("What would you like to play? ");
                 playerPlay = inputReader.nextInt();

            }
            int computerPlay = randomizer.nextInt(3)+1;

            System.out.println("");

            // Decision of the round's result

            if (computerPlay == playerPlay){ ties++; System.out.println("You tied this round");}

            else if (playerPlay == 1 && computerPlay == 3){ wins++; System.out.println("You won this round");}
            else if (playerPlay == 2 && computerPlay == 1){ wins++; System.out.println("You won this round");}
            else if (playerPlay == 3 && computerPlay == 2){ wins++; System.out.println("You won this round");}

            else { lost++; System.out.println("You lost this round");}


            // Decision when the number of round is reached

            if((round+1) == nbRounds) {

                System.out.println("");
                System.out.println("Game Over");
                int decision = 0 ;

                // Showing player result and asking for a new game
                decision =  result(wins,ties,lost);
                if (decision == 1 ){

                    System.out.print("How many rounds would you like to play ? ");


                     nbRounds = inputReader.nextInt();

                    if (nbRounds<11 && nbRounds>0){
                        wins = 0;
                        ties = 0;
                        lost = 0;
                        round = 0;
                        System.out.println("Let's play again");
                    }
                    else { System.out.println("Error, invalid input"); return 1;}


                }
                else round++;
            }
            else round++;
        }
    return 0;}

    private static int result(int wins, int ties, int lost) {

        System.out.println("");
        if (wins > lost) System.out.print("Congratulations, you won       ");
        else if (wins < lost) System.out.println("Sorry, you lost maybe next time       ");
        else System.out.println("You're tied, try again to win next time        ");

        System.out.println("You have "+wins+" wins, "+ties+" ties and "+ lost+ " lost in total" );
        System.out.println("");
        System.out.println("Would you like to play again ? 1 for Yes or else for No");
        Scanner inputReader = new Scanner(System.in);

        return inputReader.nextInt();
    }
}

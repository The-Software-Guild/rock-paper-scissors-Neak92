package neil.mthree.excerice;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        System.out.print("How many rounds would you like to play ? ");
        Scanner inputReader = new Scanner(System.in);

        int nbRounds = inputReader.nextInt();
        if (nbRounds<11 && nbRounds>0){  play(nbRounds);
            System.out.println("");
            System.out.println("");
            System.out.println("Thanks for playing!");
        }
        else System.out.println("Error, invalid input");


    }

    private static void play(int nbRounds) {
        int wins = 0;
        int ties = 0;
        int lost = 0;

        System.out.println("To play select 1 for Rock, 2 for Paper or 3 for Scissors");
        System.out.println("Rock win over Scissors, Paper wins over Rock and Scissors win over Paper");
        Scanner inputReader = new Scanner(System.in);

        Random randomizer = new Random();

        int x =  0;
        while (x < nbRounds){

            System.out.println("");
            System.out.println("What would you like to play? ");
            int playerPlay = inputReader.nextInt();

            int computerPlay = randomizer.nextInt(3)+1;
          //  System.out.println(computerPlay);
            System.out.println("");

            if (computerPlay == playerPlay){ ties++; System.out.println("You tied this round");}

            else if (playerPlay == 1 && computerPlay == 3){ wins++; System.out.println("You won this round");}
            else if (playerPlay == 2 && computerPlay == 1){ wins++; System.out.println("You won this round");}
            else if (playerPlay == 3 && computerPlay == 2){ wins++; System.out.println("You won this round");}

            else if (playerPlay == 3 && computerPlay == 1){ lost++; System.out.println("You lost this round");}
            else if (playerPlay == 2 && computerPlay == 3){ lost++; System.out.println("You lost this round");}
            else if (playerPlay == 1 && computerPlay == 2){ lost++; System.out.println("You lost this round");}



            if((x+1) == nbRounds) {

                System.out.println("");
                System.out.println("Game Over");
                int r =0 ;
               r =  result(wins,ties,lost);
                if (r == 1 ){

                     wins = 0;
                     ties = 0;
                     lost = 0;
                     x = 0;
                    System.out.println("Let's play again");
                }
                else x++;
            }
            else x++;
        }
    }

    private static int result(int wins, int ties, int lost) {

        System.out.println("");
        if (wins > lost) System.out.print("Congrulations, you won       ");
        else if (wins < lost) System.out.println("Sorry, you lost maybe next time       ");
        else System.out.println("You're tied, try again to win next time        ");

        System.out.println("You have "+wins+" wins, "+ties+" ties and "+ lost+ " lost in total" );
        System.out.println("");
        System.out.println("Would you like to play again ? 1 for Yes or else for No");
        Scanner inputReader = new Scanner(System.in);

        return inputReader.nextInt();
    }
}

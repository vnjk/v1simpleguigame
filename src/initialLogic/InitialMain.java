package initialLogic;

import java.util.Random;
import java.util.Scanner;


public class InitialMain {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String playAgain = "";
        do {
            int theNumber = (int) (Math.random() * 500 + 1);
            int guess = 0;
            int tries = 0;
            while (guess != theNumber) {
                tries++;
                System.out.println("Guess a number between 1 and 500:");
                guess = sc.nextInt();
                if (guess < theNumber) {
                    System.out.println(guess + " is too low. Try again");
                } else if (guess > theNumber) {
                    System.out.println(guess + " is too high. Try again");
                } else {
                    System.out.println(guess + " is correct! You win! You took " + tries + " tries");
                }
            }
            System.out.println("Would you like to play again (y/n)?");
            playAgain = sc.next();

        }while(playAgain.equalsIgnoreCase("y"));
    }

}

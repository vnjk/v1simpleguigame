import java.util.Scanner;

public class HiLo extends IGame{

    INumberGenerator numGenerator = null;

    public HiLo(INumberGenerator numGenerator){
        this.numGenerator = numGenerator;
    }

    @Override
    public void play() {
        Scanner sc = new Scanner(System.in);
        do {
            int expectedVal = numGenerator.generateNumber(500);
            int guess = 0, tries = 0;

            prompt("Guess the number between 1 and 500");
            guess = sc.nextInt();

            while (verifyResponse(guess, expectedVal, tries)) {
                guess = sc.nextInt();
                tries++;
            }
            prompt("Would you like to play again (y/n)?");

        }while(playAgain(sc.next()));
    }

    private boolean verifyResponse(int answer, int expectedVal, int tries){
        if(answer > expectedVal){
            prompt(answer + " is too high.");
        }else if(answer < expectedVal){
            prompt(answer + " is too low.");
        }else{
            prompt(answer + " is correct. Number of tries: " + tries);
        }
        return answer != expectedVal;
    }



    private boolean playAgain(String response) {
        return response.equalsIgnoreCase("y");
    }


}

import java.util.Scanner;

public class HiLoController {

    HiLo game = null;

    public HiLoController(HiLo game){
        this.game = game;
    }

    public void playGame(){
        game.init();

        Scanner sc = new Scanner(System.in);
        System.out.println("Game start " + game.getMaxVal());

        int guess = sc.nextInt();
        GuessType type = game.verifyGuess(guess);
        while( type != GuessType.CORRECT){
            switch(type){
                case HIGH:
                    System.out.println("Too high");
                    break;
                case LOW:
                    System.out.println("Too low");
                    break;
                default:
                    break;
            }
            guess = sc.nextInt();
            type = game.verifyGuess(guess);
        }
        System.out.println("Correct");

    }

    public boolean playAgain(String response) {
        return response.equalsIgnoreCase("y");
    }
}

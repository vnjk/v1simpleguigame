import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HiLo2 extends Application {


    Stage window;
    Scene startScene, gameScene, finishedScene;
    HiLoController game = null;
    int maxVal;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Label labelText = new Label("Would you like to play the HiLo game?");
        Button button1 = new Button("Start");

        game = new HiLoController(new HiLo(new NumberGenerator()));
        button1.setOnAction(e-> {
            window.setScene(gameScene);
            game.init();
        });


        //Layout 1 - children are laid out in vertical column


        VBox layout = new VBox(20);
        layout.getChildren().addAll(labelText, button1);
        startScene = new Scene(layout, 450,250);


        //Layout 3 -

        Label labelText3 = new Label();
        Button button3 = new Button("Play Again?");

        VBox layout3 = new VBox(50);
        layout3.getChildren().addAll(labelText3, button3);
        finishedScene = new Scene(layout3, 450,250);

        button3.setOnAction(e -> window.setScene(startScene));
        //Layout 2

        TextField input = new TextField();
        Label labelText2 = new Label("Guess a number between 1 and "+ game.getMaxVal());
        Button button2 = new Button("Guess");
        button2.setOnAction(e -> {
            System.out.println(Integer.parseInt(input.getText()));
            game.guess(Integer.parseInt(input.getText()));
            switch(game.getGuessStatus()){
                case HIGH:
                    labelText2.setText("The number " + game.getLatestGuess() + " is too HIGH. Try again!");
                    break;
                case LOW:
                    labelText2.setText("The number " + game.getLatestGuess() + " is too LOW. Try again!");
                    break;
                case CORRECT:
                    labelText3.setText("Congratulations you've guessed the correct answer! The answer was: " + game.getLatestGuess() + " Tries: " + game.getTries());
                    window.setScene(finishedScene);
                default:
                    break;
            }
        });

        VBox layout2 = new VBox(50);
        layout2.getChildren().addAll(labelText2, input, button2);


        gameScene = new Scene(layout2, 450,250);

        window.setScene(startScene);
        window.setTitle("HiLo Game");
        window.show();
    }
}

public class Main {
    public static void main(String[] args) {
        HiLoController test = new HiLoController(new HiLo(new NumberGenerator()));
        test.playGame();
    }
}

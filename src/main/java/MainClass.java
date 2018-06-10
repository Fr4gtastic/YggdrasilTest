import java.util.ArrayList;

public class MainClass {

    private static int numberOfLoops = (int)1e7;
    private static ArrayList<Integer> listOfRewards = new ArrayList<>();

    private static double calculateAverage() {

        int sum = 0;

        for (Integer integer : listOfRewards) {
            sum += integer;
        }

        return sum/listOfRewards.size();
    }

    public static void main(String[] args) {

        for(int i = 0; i < numberOfLoops; i++) {
            Game game = new Game();
            game.playGame();
            listOfRewards.add(game.getTreasury());
        }

        System.out.println("The average reward after one round, calculated using 10 mln simulations: " + calculateAverage());
    }
}

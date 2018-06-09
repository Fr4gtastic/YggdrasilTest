import java.util.Random;

public class Game {

    private BoxesHolder boxesHolder;
    private int treasury;
    private boolean gameOver;
    private boolean hasExtraLife;
    private boolean hasSecondChance;
    private Random randomInitializer;

    public Game() {
        boxesHolder = new BoxesHolder(1, 2, 5, 1, 3);
        treasury = 0;
        gameOver = false;
        hasExtraLife = false;
        hasSecondChance = false;
        randomInitializer = new Random();
    }

    private void addToTreasury(int reward) {
        treasury += reward;
    }

    private boolean isGameOver() {
        return gameOver;
    }

    public int getTreasury() {
        return treasury;
    }

    public void playGame() {

        while (!isGameOver()) {
            int counter = boxesHolder.getSize();
            int selection = randomInitializer.nextInt(counter);
            Box chosenBox = boxesHolder.removeFromHolder(selection);

            if (chosenBox.getBonus() == null) {
                addToTreasury(chosenBox.getReward());
            } else if (chosenBox.getBonus() == Bonus.EXTRA_LIFE) {
                hasExtraLife = true;
            } else if (chosenBox.getBonus() == Bonus.GAME_OVER) {
                if (hasExtraLife) {
                    hasExtraLife = false;
                } else {
                    gameOver = true;
                }
            }
        }

        Box additionalReward = getAdditionalReward();

        if(additionalReward.getBonus() == Bonus.SECOND_CHANCE) {
            hasSecondChance = true;
            gameOver = false;
            playGame();
        } else {
            addToTreasury(additionalReward.getReward());
        }

    }

    private Box getAdditionalReward() {
        int numberOfPossibleRewards = 4;

        if (hasSecondChance) {
            numberOfPossibleRewards = 3;
        }

        int rewardChoice = randomInitializer.nextInt(numberOfPossibleRewards);
        Box additionalReward;

        switch(rewardChoice) {
            case 0: additionalReward = new Box(5);
                    break;
            case 1: additionalReward = new Box(10);
                    break;
            case 2: additionalReward = new Box(20);
                    break;
            case 3: additionalReward = new Box(Bonus.SECOND_CHANCE);
                    break;
            default: additionalReward = null;
        }

        return additionalReward;
    }

}

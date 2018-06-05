import java.util.ArrayList;
import java.util.Random;

public class Game {

    private ArrayList<Box> boxes;
    private int treasury;
    private boolean gameOver;
    private boolean hasExtraLife;
    private boolean hasSecondChance;
    private Random randomInitializer;

    public Game() {
        boxes = new ArrayList<>(12);

        fillBoxes();
        treasury = 0;
        gameOver = false;
        hasExtraLife = false;
        hasSecondChance = false;
        randomInitializer = new Random();

        fillBoxes();
    }

    private void fillBoxes() {

        int hundred = 1;
        int five = 5;
        int twenty = 2;
        int life = 1;
        int over = 3;

        int all = 12;

        while (all > 0) {
            int chance = randomInitializer.nextInt(all);

            if (chance < hundred) {
                boxes.add(new Box(100));
                hundred--;
                all--;
            } else if (chance >= hundred && chance < five + hundred) {
                boxes.add(new Box(5));
                five--;
                all--;
            } else if (chance >= five + hundred && chance < twenty + five + hundred) {
                boxes.add(new Box(20));
                twenty--;
                all--;
            } else if (chance >= twenty + five + hundred && chance < life + twenty + five + hundred) {
                boxes.add(new Box(Bonus.EXTRA_LIFE));
                life--;
                all--;
            } else if(chance < all) {
                boxes.add(new Box(Bonus.GAME_OVER));
                over--;
                all--;
            }
        }
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
            int counter = boxes.size();
            int selection = randomInitializer.nextInt(counter);
            Box chosenBox = boxes.remove(selection);

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

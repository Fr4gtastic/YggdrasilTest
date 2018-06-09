import java.util.ArrayList;
import java.util.Collections;

public class BoxesHolder {

    private ArrayList<Box> holder;

    public BoxesHolder(int hundreds, int twenties, int fives, int lives, int gameOvers) {
        holder = new ArrayList<>();
        fillBoxes(hundreds, twenties, fives, lives, gameOvers);
        Collections.shuffle(holder);
    }

    private void fillBoxes(int hundreds, int twenties, int fives, int lives, int gameOvers) {

        addToHolder(hundreds, new Box(100));
        addToHolder(twenties, new Box(20));
        addToHolder(fives, new Box(5));
        addToHolder(lives, new Box(Bonus.EXTRA_LIFE));
        addToHolder(gameOvers, new Box(Bonus.GAME_OVER));
    }

    private void addToHolder(int numberOfItems, Box item) {
        for(int i = 0; i < numberOfItems; i++) {
            holder.add(item);
        }
    }

    public int getSize() {
        return holder.size();
    }

    public Box removeFromHolder(int index) {
        return holder.remove(index);
    }

}

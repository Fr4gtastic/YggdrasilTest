import java.util.ArrayList;
import java.util.Collections;

public class BoxesHolder {

    private ArrayList<Box> holder;

    public BoxesHolder() {
        holder = new ArrayList<>();
    }

    public void addToHolder(int numberOfItems, Box item) {
        for(int i = 0; i < numberOfItems; i++) {
            holder.add(item);
        }
    }

    public void shuffleBoxes() {
        Collections.shuffle(holder);
    }

    public int getSize() {
        return holder.size();
    }

    public Box removeFromHolder(int index) {
        return holder.remove(index);
    }

    public Box getBoxAtIndex(int index) {
        return holder.get(index);
    }

    public void emptyHolder() {
        holder.clear();
    }

}

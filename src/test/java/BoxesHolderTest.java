import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;

public class BoxesHolderTest {

    private BoxesHolder boxesHolder;

    @Before
    public void setUp() {
        boxesHolder = new BoxesHolder();
    }

    @Test
    public void addToHolderTest() {
        boxesHolder.addToHolder(2, new Box(1));
        boxesHolder.addToHolder(2, new Box(Bonus.EXTRA_LIFE));
        Assert.assertEquals(4, boxesHolder.getSize());
        Assert.assertEquals(1, boxesHolder.getBoxAtIndex(0).getReward());
        Assert.assertEquals(Bonus.EXTRA_LIFE, boxesHolder.getBoxAtIndex(boxesHolder.getSize() - 1).getBonus());
    }

    @Test
    public void removeFromHolderTest() {
        boxesHolder.addToHolder(2, new Box(2));
        int size = boxesHolder.getSize();
        Assert.assertEquals(new Box(2).getReward(), boxesHolder.removeFromHolder(size - 1).getReward());
        Assert.assertEquals(size - 1, boxesHolder.getSize());
    }

    @AfterEach
    public void clear() {
        boxesHolder.emptyHolder();
    }
}

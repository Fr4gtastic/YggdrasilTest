import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GameTest {

    private Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @Test
    public void playGameTest() {
        game.playGame();
        Assert.assertTrue(game.isGameOver());
        Assert.assertTrue(game.getTreasury() >= 0);
    }

}

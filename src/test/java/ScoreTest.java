import Controller.Score;
import model.Card;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class ScoreTest {
    @Test
    public void checkScore() {
        Score score = new Score();
        Assert.assertEquals(4, score.getScore(new Card[]{Card.A, Card.A, Card.A}));
        Assert.assertEquals(2, score.getScore(new Card[]{Card.A, Card.K, Card.K}));
        Assert.assertEquals(3, score.getScore(new Card[]{Card.TWO, Card.THREE, Card.FOUR}));
        Assert.assertEquals(0, score.getScore(new Card[]{Card.TWO, Card.FOUR, Card.TWO}));
    }

    @Test
    public void checkSequential() {
        Score score = new Score();
        Assert.assertEquals(true, score.checkSequential(new Card[]{Card.A, Card.K, Card.Q}));
        Assert.assertEquals(false, score.checkSequential(new Card[]{Card.TWO, Card.FOUR, Card.TEN}));
        Assert.assertEquals(true, score.checkSequential(new Card[]{Card.TWO, Card.THREE, Card.FOUR}));
        Assert.assertEquals(false, score.checkSequential(new Card[]{Card.FIVE, Card.K, Card.Q}));
    }

    @Test
    public void checkPair() {
        Score score = new Score();
        Assert.assertEquals(true, score.checkPair(new Card[]{Card.FIVE, Card.K, Card.K}));
        Assert.assertEquals(false, score.checkPair(new Card[]{Card.A, Card.K, Card.Q}));
        Assert.assertEquals(true, score.checkPair(new Card[]{Card.Q, Card.Q, Card.FOUR}));
        Assert.assertEquals(false, score.checkPair(new Card[]{Card.TWO, Card.FOUR, Card.TWO}));
    }

}

import Controller.Game;
import model.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class GameTest {
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkNumberOfPlayer() {
        Game game = new Game(19);
    }

    @Test
    public void checkShuffledDeck() {
        Game game = new Game(4);

        Card[] deck = new Card[52];
        for (int i = 0;  i < 52; i++) {
            deck[i] = Card.valueOf(i%13);
        }

        Arrays.sort(deck);
        Arrays.sort(game.getDeck().getDeck());

        Assert.assertArrayEquals(deck, game.getDeck().getDeck());
    }

}

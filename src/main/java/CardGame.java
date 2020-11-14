import Controller.Game;
import model.Deck;
import model.Player;

import java.util.logging.Logger;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class CardGame {
    public static void main(String[] args) {

        final Integer NUMBER_OF_PLAYERS = 4;
        Game game = new Game(NUMBER_OF_PLAYERS);
        game.startGame();

    }
}

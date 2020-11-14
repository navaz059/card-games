package Controller;

import Exceptions.PlayerCardException;
import model.Card;
import model.Rule;

import java.util.Arrays;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class Score {

    public int getScore(Card[] playerCard) {
        // check for exception if player has more than three cards;

        if (playerCard.length != 3) {
            throw new PlayerCardException("Player needs to have exactly three cards");
        }

        if (playerCard[0] == playerCard[1] && playerCard[1] == playerCard[2]) {
            return Rule.ALL_SAME_CARD.getValue();
        } else if (checkSequential(playerCard)) {
            return Rule.SEQUENTIAL_CARDS.getValue();
        } else if(checkPair(playerCard)) {
            return Rule.PAIR_OF_CARD.getValue();
        }

        return Rule.GAME_DRAW.getValue();
    }

    public boolean checkSequential(Card[] cards) {
        int[] cardValue = new int[3];
        for (int i = 0; i < 3; i++) {
            cardValue[i] = cards[i].getValue();
        }
        Arrays.sort(cardValue);
        return ((cardValue[2] - cardValue[1]) == (cardValue[1] - cardValue[0]));
    }

    public boolean checkPair(Card[] cards) {

        int count = 0;
        if (cards[0] == cards[1]) {
            count++;
        }
        if (cards[1] == cards[2]) {
            count++;
        }
        if (cards[0] == cards[2]) {
            count++;
        }
        return (count == 2);
    }
}

package model;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class Deck {
    Card[] deck = new Card[52];

    public Deck() {
        for (int i = 0;  i < 52; i++) {
            deck[i] = Card.valueOf(((i%13)+1));
        }

//        for (int i = 0;  i < 52; i++) {
//            System.out.print(deck[i] + "  ");
//            if ((i + 1) % 13 == 0) {
//                System.out.println("");
//            }
//        }

        Collections.shuffle(Arrays.asList(deck));
    }

    public Card[] getDeck() {
        return this.deck;
    }

}

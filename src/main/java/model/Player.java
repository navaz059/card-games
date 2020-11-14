package model;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class Player {
    private Integer id;

    Card[] cards = new Card[3];

    public Player(Deck deck, Integer id) {
        this.id = id;
        System.out.print("Player: "+id+" -> Cards: ");
        int i = 3*id;
        for (int j = 0; j < 3; j++) {
            cards[j] = deck.getDeck()[i];
            System.out.print(cards[j].getLabel()+"   ");
            i++;
        }
        System.out.println("");
    }

    public Card[] getCards() {
        return cards;
    }

    public Integer getId() {
        return id;
    }
}

package Controller;

import Exceptions.NumberOfPlayerException;
import model.Deck;
import model.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public class Game {

    Integer lastCardIndex;
    List<Player> players;
    Player winner;
    Deck deck;

    Score score;

    public Game(Integer playerCount) {

        if (playerCount*3 > 52) {
            throw new NumberOfPlayerException("Number Can Be Maximum upto 17");
        }

        deck = new Deck();
        players = new ArrayList<Player>();

        for (int i = 1; i <= playerCount; i++) {
            players.add(new Player(deck, i));
        }

        lastCardIndex = playerCount*3;
    }

    public void startGame() {
        score = new Score();
        int maxScore = 0;
        for (Player player : players) {
            if (score.getScore(player.getCards()) > maxScore) {
                maxScore = score.getScore(player.getCards());
                this.winner = player;
            }
        }

        System.out.println(this.winner != null? ("Player "+this.winner.getId()+" is Winner"):"A Draw Game");

        if (this.winner == null) {
            getWinnerByTopCard();
        }
    }

    public void getWinnerByTopCard() {
        System.out.println("Pick top Card for Each Player");
        int maxScore = 0;
        for (Player player : players) {

            System.out.println("Player: " + player.getId() + " -> Top Card Picked From Deck: " + player.getCards()[2].getPriority());

            if (player.getCards()[2].getPriority() > maxScore) {
                maxScore = deck.getDeck()[lastCardIndex].getValue();
                this.winner = player;
            }
        }
        if (this.winner != null) {
            System.out.println("Player "+this.winner.getId()+" is Winner");
        } else {
            getTopCardFromDeck();
        }
    }

    public void getTopCardFromDeck() {
        System.out.println("Starting Draw Game Scenario ...................................................");
        int maxScore = 0;
        while (maxScore == 0 && lastCardIndex < 52) {
            for (Player player : players) {

                if (lastCardIndex >= 52) {
                    throw new IndexOutOfBoundsException("All cards finished. Can't decide Winner");
                }

                System.out.println("Player: "+player.getId()+" -> Top Card Picked From Deck: "+deck.getDeck()[lastCardIndex].getLabel());

                if (deck.getDeck()[lastCardIndex].getValue() > maxScore) {
                    maxScore = deck.getDeck()[lastCardIndex].getValue();
                    this.winner = player;
                }

                lastCardIndex++;
            }
            if (this.winner != null) {
                System.out.println("Player "+this.winner.getId()+" is Winner");
            }
        }
    }

    public Deck getDeck() {
        return this.deck;
    }
}

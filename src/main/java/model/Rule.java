package model;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public enum Rule {
    ALL_SAME_CARD("All Same Cards", 4),
    SEQUENTIAL_CARDS("Sequential Cards", 3),
    PAIR_OF_CARD("2 Cards Of Same Pair", 2),
    TOP_CARD_VALUE("Checked Top Value Of Card", 1),
    GAME_DRAW("Game Draw", 0);

    String label;
    int value;

    Rule(String label, int value) {
        this.label = label;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Navaz on 14, Nov, 2020
 */
public enum Card {
    A(1, "A", 13),
    K(13, "K", 12),
    Q(12, "Q", 11),
    J(11, "J", 10),
    TEN(10, "10", 9),
    NINE(9, "9", 8),
    EIGHT(8, "8", 7),
    SEVEN(7, "7", 6),
    SIX(6, "6", 5),
    FIVE(5, "5", 4),
    FOUR(4, "4", 3),
    THREE(3, "3", 2),
    TWO(2, "2", 1);

    private int value;
    private String label;
    int priority;

    private static Map map = new HashMap<Integer, Card>();

    private Card(int value, String label, int priority) {
        this.value = value;
        this.label = label;
        this.priority = priority;
    }

    static {
        for (Card cardType : Card.values()) {
            map.put(cardType.value, cardType);
            System.out.print(cardType + "  -> "+cardType.value+" ");
        }
        System.out.println("End");
    }

    public static Card valueOf(int cardType) {
        return (Card) map.get(cardType);
    }

    public int getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public int getPriority() {
        return priority;
    }
}

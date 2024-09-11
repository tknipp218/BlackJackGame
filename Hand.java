import java.util.ArrayList;
import java.util.List;

public class Hand {
    //list of cards in the hand
    public List<Card> cards;

    //makes a hand
    public Hand() {
        cards = new ArrayList<>();
    }

    //adds a card to the hand
    public void addCard(Card card) {
        cards.add(card);
    }

    //gets the value of the hand
    public int getValue() {
        int value = 0;
        int aces = 0;

        //loop through each card in the hand
        for (Card card : cards) {
            int cardValue = card.getValue();
            if (card.toString().startsWith("Ace")) {
                aces++;
            }
            value += cardValue;
        }

        //if the value is over 21, subtract 10 for each ace
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }

    public Card get(int index) {
        return cards.get(index);
    }

    public void clear() {
        cards.clear();
    }

    //returns the hand as a string
    @Override
    public String toString() {
        return cards.toString();
    }
}
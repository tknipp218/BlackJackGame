import java.util.Collections;
import java.util.Stack;

public class Deck {
    //stack of cards
    private Stack<Card> cards;

    //creates a deck of cards
    public Deck() {
        cards = new Stack<>();
        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    //refills the deck
    private void refillDeck() {
        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    //shuffles the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //deals a card from the deck
    public Card dealCard() {
        if (cards.isEmpty()) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            System.out.println("\nDeck is empty. Dealer Shuffling...");
            refillDeck();
            shuffle();
        }
        return cards.pop();
    }
}

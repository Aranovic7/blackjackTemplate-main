package com.someName.projektarbete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private static final String[] CARD_SYMBOLS = { // Varje objekt av den här classen har variabeln
            " of Hearts (♥)", " of Spades (♤)",
            " of Diamonds (♢) ", " of Clubs (♧)"};

    private static final String[] CARD_VALUES = {
            "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King"};
    private final List<Card> deckList;  // Standardpaket med 52 kort används

    public Deck() { // Har en lista med 52 kort
        this.deckList = new ArrayList<>(52);
    }

    public void generateDeck() { // Hämtar 52 nya kort efter varje runda och blandar
        deckList.clear();
        for (String cardSymbol : CARD_SYMBOLS) {

            for (String cardValue : CARD_VALUES) {
                Card card = new Card();
                card.setCardSymbol(cardSymbol);
                card.setCardValue(cardValue);
                deckList.add(card);
            }
            Collections.shuffle(deckList);
        }

    }
    public Card drawCard(){
        Card drawCard = deckList.get(0);
        deckList.remove(drawCard);
        return drawCard;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deckList=" + deckList +
                '}';
    }
}



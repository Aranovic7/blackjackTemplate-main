package com.someName.projektarbete;

public class Card {

    private String cardSymbol;
    private String cardValue;


    public String getCardSymbol() {
        return cardSymbol;
    }
    public void setCardSymbol(String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }

    public String getCardValue() { return cardValue;}

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }

    public int getRealValue (){
        return switch (cardValue) {
            case "Ace" -> 1;
            case "Jack", "Queen", "King" -> 10;
            default -> Integer.parseInt(cardValue);
        };
    }

    @Override
    public String toString() {
    return cardValue + "" + cardSymbol;
    }


}

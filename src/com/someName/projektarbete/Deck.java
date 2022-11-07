package com.someName.projektarbete;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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


       private String player;
       private int betDollar;
       private int moneyAmount = 1000;
       private int choice;
        private int hit = 1;
        private int stand = 2;


        public void restartOrExit(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n" + "You have " + moneyAmount + " dollars left to play for");
            System.out.println("Do you want to play again? " + "\n" + "Input (1) to play again or (2) to exit" );


            choice = scanner.nextInt();
            if (choice == 1) {

                menu();
            } else if (choice == 2) {

                System.out.println("Hope we see you soon!");
                System.exit(0);

            } else
                System.out.println("Please try again");
        }
        public void startMenu (){
            Scanner scanner = new Scanner(System.in);


            System.out.println("Hello and welcome to Aran's Blackjack!");
            System.out.println("What is your name?");
            player = scanner.nextLine();

            System.out.println("Once again, welcome " + player);
            System.out.println();
            System.out.println("You have" + moneyAmount + " $ to play with. How much do you want to bet? (notice your bet needs to be 2$ to 500$)");
            betDollar = scanner.nextInt();
            moneyAmount -= betDollar;

            if (betDollar > 500) {
                System.out.println("Your bet can't be more than 500$");
                System.exit(0);
            }
            else if (betDollar < 2) {
                System.out.println("Your bet can't be less than 2$");
                System.exit(0);

            } else if (betDollar < 500 && betDollar > 2){
                System.out.println();
                System.out.println("Congrats champ!, you have now " + betDollar + "$");
                System.out.println("The game starts now! Good luck champ!");
            } else
                System.out.println("Please try again");


        }


    public void menu () {
        Scanner scanner = new Scanner(System.in);
        Deck deck = new Deck();
        deck.generateDeck();

        List<Card> playerCards = new ArrayList<>();
        List<Card> dealersCards = new ArrayList<>();

        playerCards.add(deck.drawCard());
        playerCards.add(deck.drawCard());

        dealersCards.add(deck.drawCard());
        dealersCards.add(deck.drawCard());

        System.out.println("Player cards = " + playerCards);
        System.out.println("Dealers cards = " + dealersCards.get(0) + " hidden card");

        while (true) {
            System.out.println("Do you wanna hit(1) or stay(2)?");
            choice = scanner.nextInt();
            if (choice == 1) {
                playerCards.add(deck.drawCard());
                System.out.println(playerCards);
                int sum = 0;
                for (int i = 0; i < playerCards.size(); i++) {
                    sum += playerCards.get(i).getRealValue();
                    if (sum > 21) {
                        System.out.println("You lost! You now lost " + betDollar + " dollars");
                        System.out.println("You have " + (moneyAmount) + " dollars left to play for");
                        restartOrExit();
                        break;

                    } else if (sum == 21) {
                        System.out.println("Congratulations you won!, you won " + betDollar + " dollars");
                        System.out.println("You have " + (moneyAmount) + " dollars left to play for");
                        restartOrExit();
                        break;
                    }
                }

            } else if (choice == 2) {
                System.out.println("You chose to stay");
                int sum = 0;
                for (int i = 0; i < playerCards.size(); i++) {
                    sum += playerCards.get(i).getRealValue();
                    if (sum > 21) {

                        System.out.println("You lost! You now lost " + betDollar + " dollars, you have " + (moneyAmount) + "left to play for");
                        restartOrExit();
                        break;
                    } else if (sum == 21) {
                        System.out.println("Congrats you won!");
                    } else if (dealersCards.get(i).getRealValue() > playerCards.get(i).getRealValue()) {
                        System.out.println("You lost against the dealer, therefore you also lost " + betDollar + " dollars");
                        //System.out.println(moneyAmount);
                        restartOrExit();

                        break;
                    } else if (playerCards.get(i).getRealValue() > dealersCards.get(i).getRealValue()) {
                        System.out.println("You won!! Therefore you also won: " + betDollar + " dollar");
                        moneyAmount += betDollar * 1.5;
                        //System.out.println(moneyAmount);
                        restartOrExit();
                        break;
                    } else if (playerCards.get(i).getRealValue() == dealersCards.get(i).getRealValue()){
                        System.out.println("It´s a draw!, you still have " + moneyAmount + " dollars left!");
                        restartOrExit();
                        break;
                    } else
                        System.out.println("Please try again");

                }

            }
            while (true) {
                int sum1 = 0;
                for (int i = 0; i < dealersCards.size(); i++) {
                    sum1 += dealersCards.get(i).getRealValue();
                    if (sum1 < 17){
                        System.out.println("Dealer draws card...");
                        dealersCards.add(deck.drawCard());
                        restartOrExit();
                        break;
                    } else if (sum1 >= 17 && sum1 <= 21 && dealersCards.size() > playerCards.size()) {
                        System.out.println("Dealer wins!");
                        restartOrExit();
                        break;
                    } else  {
                        System.out.println("Something went wrong");
                        break;
                    }
                }
        }


    }}}
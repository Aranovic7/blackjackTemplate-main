package com.someName.projektarbete;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String playerName;
        int betDollar;
        int hit = 1;
        int stay = 2;
        int choice;



        Scanner myScanner = new Scanner(System.in);

        System.out.println("Welcome to Aran's Blackjack Game!");
        System.out.println("Please, enter your name ");
        playerName = myScanner.next();
        System.out.println("Hi " + playerName + ", how much do you wanna bet?"
                + " (notice that you can only put in between 2 - 500 dollars)");
        betDollar = myScanner.nextInt();
        if (betDollar > 500 || betDollar < 2 ) {
            System.out.println("Your bet must be at least 2 dollars and not more than 500");
            System.exit(1);

        } else if (betDollar <= 500 || betDollar >= 2)
            System.out.println("Congrats, you have put in " + betDollar + " dollars"
                    + "," + '\n' + "Now the game starts, good luck!"
            + "\n" + "\n" + "These are your cards");

        else
            System.out.println("Please, try again");

        Deck deckTemplate = new Deck();

        List<Card> deckOfCards = deckTemplate.generateDeck();

        System.out.println(deckOfCards.get(1));
        System.out.println(deckOfCards.get(2));
        System.out.println("\n" + "These are dealers cards");
        System.out.println(deckOfCards.get(3));
        System.out.println(deckOfCards.get(4));
        System.out.println("\n" + "Do you wanna (1)hit or (2)stand?");
        choice = myScanner.nextInt();
        if (choice == hit)
            System.out.println("This is your new card " +
              "\n" +
                    deckOfCards.get(5)
                    + "\n" + "These are your cards now" + "\n" +
                    deckOfCards.get(1) + deckOfCards.get(2) + deckOfCards.get(5));
        else if (choice == stay) {
            System.out.println("You chose to stand");
        } else
            System.out.println("Please, choose a number between 1 or 2");

    }

}

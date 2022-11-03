package com.someName.projektarbete;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String player;
        int betDollar;
        int choice;
        int hit = 1;
        int stand = 2;

        System.out.println("Hello and welcome to the finest Blackjack game in the city!");
        System.out.println("First of all what is your name champ?");
        player = scanner.nextLine();

        System.out.println("That's a great name just like our new champ!");
        System.out.println();
        System.out.println("Okey now! You have 1000$ to play with. How much do you want to bet? PS. You can only bet from 2$ to 500$");
        betDollar = scanner.nextInt();

        if (betDollar > 500) {
            System.out.println("Your bet can't be more than 500$");
            System.exit(0);
        }
        else if (betDollar < 2) {
            System.out.println("Your bet can't be less than 2$");

        } else {
            System.out.println();
            System.out.println("Congrats champ!, you have now " + betDollar + "$");
        }
        System.out.println("The game starts now! Good luck champ!");

        Deck deckTemplate = new Deck();

        List<Card> deckOfCards = deckTemplate.generateDeck();
        List<Card> totalOfCards = new ArrayList<>();
        List<Card> handOfCards = new ArrayList<>();
        List<Card> dealersCards = new ArrayList<>();

        totalOfCards.add(deckOfCards.get(0));
        deckOfCards.remove(0);
        totalOfCards.add(deckOfCards.get(1));
        deckOfCards.remove(1);
        System.out.println();
        System.out.println("The dealer gave you: " + totalOfCards.get(0) + totalOfCards.get(1));
        int sum = 0;
        for (int i = 0; i < totalOfCards.size(); i++) {
            sum += totalOfCards.get(i).getRealValue();
        }
        System.out.println("Your hand is: " + sum);

        System.out.println();

        dealersCards.add(deckOfCards.get(0));
        deckOfCards.remove(0);
        System.out.println("The dealer draws " + dealersCards.get(0) + " and have one card faced down");
        int sum1 = 0;
        for (int i = 0; i < dealersCards.size(); i++) {
            sum1 += dealersCards.get(i).getRealValue();
        }
        System.out.println("Dealers hand is: " + sum1);

        System.out.println();

        System.out.println("Do you want to (1)Hit or (2)Stand?");
        choice = scanner.nextInt();
        handOfCards.add(deckOfCards.get(0));
        deckOfCards.remove(0);
        for (int i = 0; i < handOfCards.size(); i++) {
            if (choice == hit) {
                System.out.println("The dealer gave you a new card: " + handOfCards.get(0));
                sum += handOfCards.get(i).getRealValue();
                System.out.println("Your hand is now: " + sum);
                if (sum == 21) {
                    System.out.println("Congrats you won " + betDollar * 1.5);
                } else if (sum > 21) {
                    System.out.println("You lose! You have " + (1000 - betDollar + "$ left. Try again!"));
                }
            }else if (choice == stand){
                System.out.println("You chose to stand");
            } else
                System.out.println("Please pick a number between 1 or 2.");
        }

        System.out.println("The dealer reveals the faced down card and it is: " + dealersCards.get(2));
        for (int i = 0; i < dealersCards.size(); i++) {
            sum1 += dealersCards.get(i).getRealValue();
            if (sum1 == 21){
                System.out.println("Dealer has won.");
            }
        }
    }
}

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
            System.exit(0);

        } else {
            System.out.println();
            System.out.println("Congrats champ!, you have now " + betDollar + "$");
        }
        System.out.println("The game starts now! Good luck champ!");



        Deck deck = new Deck();
        deck.generateDeck(); // Hämtar kortlek

        List<Card> playerCards = new ArrayList<>();
        List<Card> dealersCards = new ArrayList<>();
        System.out.println(deck);
        playerCards.add(deck.drawCard()); // Ger första kortet i kortleken till player
        System.out.println(deck);
        playerCards.add(deck.drawCard()); // Ger andra kortet i kortleken till player
        System.out.println(deck);
        dealersCards.add(deck.drawCard()); // Ger ett kort till dealer
        System.out.println(deck);
        dealersCards.add(deck.drawCard());

        System.out.println("Player cards = " + playerCards);
        System.out.println("Dealers cards = " + dealersCards.get(0) + " hidden card");

        while (true) { // Kör en loop av while eftersom vi inte vet hur många gånger användaren vill 'hit'
            // Fråga användaren hit or stay
            System.out.println("Do you wanna hit(1) or stay(2)?");
            choice = scanner.nextInt();
            if (choice == 1){ // If answer is 1, draw new card
                playerCards.add(deck.drawCard());
                System.out.println(playerCards); // Skriver ut hur mycket jag har i handen
                int sum = 0;
                for (int i = 0; i < playerCards.size(); i++) { // For - loop för beräkning av summan av korten
                    sum += playerCards.get(i).getRealValue();
                    if (sum > 21){ // Om summan av korten är större än 21 förlorar användaren
                        System.out.println("You lost! You now lost " + betDollar + " dollars");
                        System.out.println("You have " + (1000 - betDollar) + " dollars left to play for");

                    } else if (sum == 21) {
                        System.out.println("Congratulations you won!, you won " + betDollar * 1.5);

                    }
                }
                break;
            } else if (choice == 2) {
                System.out.println("You chose to stay");
                int sum = 0;
                for (int i = 0; i < playerCards.size(); i++) {
                    sum += playerCards.get(i).getRealValue();
                    if (sum > 21) {
                        // beräkna om användarens kort är värd över 21
                        System.out.println("You lost! You now lost " + betDollar + " dollars, you have " + (1000 - betDollar) + "left to play for" );
                    } else if (sum == 21)
                        System.out.println("Congrats you won!");

                }
                break; // Om den är det break ur loop

            } else
                System.out.println("Please input 1 to hit or 2 to stay");

        }




/*
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

 */
    }


}

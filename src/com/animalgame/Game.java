package com.animalgame;

<<<<<<< Updated upstream
import com.animalgame.abstractclass.Animal;
=======
import com.animalgame.Store.Store;
>>>>>>> Stashed changes

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    public Scanner console;
    private int numberOfPlayers;
    private int numberOfRounds;
    public ArrayList<Player> players;
    public int menuChoice;
    public Store store;
    public Helper helper;

    public Game(){
        console= new Scanner (System.in);
        players = new ArrayList<>();
        store = new Store();
        helper = new Helper();

        System.out.println("Welcome to Capitalism: The Animal Edition!");

        boolean setupInProgress = true;
        while (setupInProgress) {

            System.out.println("Please choose how many players 2-4: ");
            numberOfPlayers = helper.numberOfPlayers();

            //Vid flera felskrivningar kommer vi ännu vidare till number of rounds
            if (numberOfPlayers > 4 || numberOfPlayers < 2) {
                System.out.println("Invalid choice, please choose 2, 3 or 4.");
            }

            else {
                //Here we generate the players, they may name themselves
                // We save them in an arraylist
                //In the game we then need to access them from this, player 1 is index 0 etc.

            for (int i =1; i <= numberOfPlayers; i++) {
            System.out.println("Player " +i +" please enter your name: ");
            String name = console.next();
            Player in = new Player(name, 10_000);
            players.add(in);
            }
        }
        setupInProgress = false;
        }

        boolean choiceInProgress = true;
        while (choiceInProgress) {
            System.out.println("Please choose how many (5-30) rounds you want to play: ");
            numberOfRounds = helper.numberOfRounds();

            if (numberOfRounds > 30 || numberOfRounds < 5) {
                System.out.println("Nope, you need to choose number between 5 and 30.");
            }
            else {
                System.out.println("Thanks! We'll play for " + numberOfRounds + ", good luck!");
                choiceInProgress = false;
            }
        }
        //Basic OUTER gameplay loop for chosen number of rounds
        for (int i = 1; i <= numberOfRounds; i++ ) {
            //Then we play the game for the chosen number of rounds

            //Here check if a player has lost and if a player has lost remove from player list.
            //Number of players uppdateras
            System.out.println("Round number: " + i); //bara testutskrift

<<<<<<< Updated upstream


=======
>>>>>>> Stashed changes
            //This is our INNER game loop of what a player does on their round
            for (int j = 1; j <= numberOfPlayers; j++) {
                players.get(j-1).lostAnimal(numberOfPlayers,players);// inform if players animal dead
                helper.clear();
                System.out.println("This is round " + i + " of " +numberOfRounds + ". What do you want to do " +players.get(j-1).toString() +"?");
                players.get(j-1).printAnimalList();
                System.out.println(" ");
                players.get(j-1).printFoodList();
                System.out.println(" ");
                helper.createMenu("Buy animal(s)", "Buy food", "Feed animal(s)", "Breed animals", "Sell animals");
                menuChoice = helper.menuChoice();

                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("Yay, let's buy some animals!");
                        store.buyAnimal(players.get(j-1));
                    }
                    case 2 -> {
                        System.out.println("Off to the store to buy some food!");
                        store.buyFood(players.get(j-1));

                    }
                    case 3 -> {
                        System.out.println("Lovely, let's feed the animals!");
                        players.get(j-1).feedAnimal();
                    }
                    case 4 -> {
                        System.out.println("Fingers crossed the stork will deliver babies!");
                        players.get(j-1).pairAnimals();
                    }
                    case 5 -> {
                        System.out.println("Get ready to make some money!");
                        store.sellAnimal(players.get(j-1));
                    }
                    default -> System.out.println("Whoops what happened now?");
                }
            }
            //animal's health Lv goes down after every round finished.
            helper.updatedAllAnimalHealth(numberOfPlayers, players);
            helper.checkPlayersMoney(numberOfPlayers,players);


        }

        // compare players' money and get winner
        helper.getWinner(players,numberOfPlayers);


        //After this game play loop the score (money) needs to be summed up and the winner/scoreboard display

        System.out.println("Här ska vi bara avgöra vem som vann, easy peasy!");











    }

}

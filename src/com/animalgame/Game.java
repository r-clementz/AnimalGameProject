package com.animalgame;

import com.animalgame.abstractclass.Animal;
import com.animalgame.Store.Store;
import com.animalgame.abstractclass.Animal;


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

    public Game() {
        console = new Scanner(System.in);
        players = new ArrayList<>();
        store = new Store();
        helper = new Helper();

        System.out.println("Welcome to Capitalism: The Animal Edition!");

        System.out.println("Please choose how many players 2-4: ");
        numberOfPlayers = helper.numberOfPlayers();

        for (int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Player " + i + " please enter your name: ");
            String name = console.next();
            Player in = new Player(name, 10_000);
            players.add(in);
        }


        //boolean choiceInProgress = true;
        //while (choiceInProgress) {
        System.out.println("Please choose how many (5-30) rounds you want to play: ");
        numberOfRounds = helper.numberOfRounds();


        System.out.println("Thanks! We'll play for " + numberOfRounds + " rounds, good luck!");

        //Basic OUTER gameplay loop for chosen number of rounds
        for (int i = 1; i <= numberOfRounds; i++) {
            //Then we play the game for the chosen number of rounds

            //This is our INNER game loop of what a player does on their round
            for (int j = 1; j <= numberOfPlayers; j++) {

                players.get(j - 1).lostAnimal(numberOfPlayers, players);// inform if players animal dead
                System.out.println("*".repeat(50));

                System.out.println("This is round " + i + " of " + numberOfRounds + ".");
                System.out.println("It's "+ players.get(j-1).getPlayerName()+"'s turn and you have "+players.get(j-1).money+"kr.");//show player' money here

                players.get(j - 1).printAnimalList();
                System.out.println(" ");
                players.get(j - 1).printFoodList();
                System.out.println(" ");
                helper.createMenu("Buy animal(s)", "Buy food", "Feed animal(s)", "Breed animals", "Sell animals");
                menuChoice = helper.menuChoice();

                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("Yay, let's buy some animals!");
                        store.buyAnimal(players.get(j - 1));
                    }
                    case 2 -> {
                        System.out.println("Off to the store to buy some food!");
                        store.buyFood(players.get(j - 1));

                    }
                    case 3 -> {
                        System.out.println("Lovely, let's feed the animals!");
                        players.get(j - 1).feedAnimal();
                    }
                    case 4 -> {
                        System.out.println("Fingers crossed the stork will deliver babies!");
                        players.get(j - 1).pairAnimals();
                    }
                    case 5 -> {
                        System.out.println("Get ready to make some money!");
                        store.sellAnimal(players.get(j - 1));
                    }
                    default -> {
                        System.out.println("Whoops what happened now? Please choose a number between 1 and 5!");
                        menuChoice = helper.menuChoice();
                    }
                }
            }
            //animal's health Lv goes down after every round finished.
            helper.updatedAllAnimalHealth(numberOfPlayers, players);
            helper.checkPlayersMoney(numberOfPlayers, players);


        }
        System.out.println("*".repeat(50));
        // compare players' money and get winner
        store.sellAllanimals(players);
        helper.getWinner(players, numberOfPlayers);
    }

}

package com.animalgame;

import java.util.ArrayList;
import java.util.Scanner;



public class Game {
    //I'm going to comment out things not used RIGHT NOW, please "activate"/update as needed!
    //Program crashes in spectacular ways if everything activated.

    public Scanner console;
    private int numberOfPlayers;
    private int numberOfRounds;
    public ArrayList<Player> players;
    public int menuChoice;


    public Game(){
        console= new Scanner (System.in);
        players = new ArrayList<>();


        //Just basics to get everything working, validation of input still needed
        System.out.println("Welcome to Capitalism: The Animal Edition!");
        System.out.println("Please choose how many players 2-4: ");
        numberOfPlayers = console.nextInt();

        //Here we generate the players, they may name themselves
        //We save them in an arraylist (or should we do array?)
        //In the game we then need to access them from this, player 1 is index 0 etc.

        for (int i =1; i <= numberOfPlayers; i++) {
            System.out.println("Player " +i +" please enter your name: ");
            String name = console.next();
            Player in = new Player(name, 10_000); //Money?
            players.add(in);
        }

        System.out.println("Please choose how many (5-30) rounds you want to play: ");
        numberOfRounds = console.nextInt();

        //Basic OUTER gameplay loop for chosen number of rounds
        for (int i = 1; i <= numberOfRounds; i++ ) {
            //Then we play the game for the chosen number of rounds
            //This print is just a test to eliminate logic errors
            System.out.println("Round number: " + i);

            //This is our INNER game loop of what a player does on their round
            for (int j = 1; j <= numberOfPlayers; j++) {
                System.out.println(players.get(j-1));
                System.out.println("What do you want to do?");
                System.out.println("1. Buy animal(s)\t2. Buy food\t3.Feed animal(s)\t4. Breed animals\t5. Sell animal(s)");
                menuChoice = console.nextInt();

                //Enhanced switch syntax! Will need to add { } for codeblocks in the cases as example case 1.
                switch (menuChoice) {
                    case 1 -> {
                        System.out.println("Yay, let's buy some animals!");
                    }
                    case 2 -> System.out.println("Off to the store to buy some food!");
                    case 3 -> System.out.println("Lovely, let's feed the animals!");
                    case 4 -> System.out.println("Fingers crossed the stork will deliver babies!");
                    case 5 -> System.out.println("Get ready to make some money!");
                    default -> System.out.println("Whoops what happened now?");
                }
            }
        }//animal's health Lv goes down after every round finished.
         //Where can we put updateHealthStatus(Player player) method there.

        //After this game play loop the score (money) needs to be summed up and the winner/scoreboard display
//<<<<<<< Updated upstream
        System.out.println("Här ska vi bara avgöra vem som vann, easy peasy!");
//=======








//
//<<<<<<< Updated upstream
//=======
//
//        animal.updateHealthStatus(player);
//>>>>>>> Stashed changes
//>>>>>>> Stashed changes

    }

}

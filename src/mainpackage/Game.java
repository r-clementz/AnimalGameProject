package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    //I'm going to comment out things not used RIGHT NOW, please "activate"/update as needed!
    //Program crashes in spectacular ways if everything activated.

    public Scanner console;
    private int numberOfPlayers;
    private int numberOfRounds;
    //public int [] playersChoices;
    //private Store store;
    //private Animal animal;
    public ArrayList<Player> players;
    public int menuChoice;


    public Game(){
        console= new Scanner (System.in);
        //store = new Store();
        players = new ArrayList<>();
        //playersChoices = new int[3];
        //players = new Player[3];

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
            }
        }

        //After this game play loop the score (money) needs to be summed up and the winner/scoreboard display










    }

//    public void createPlayers(int numberOfPlayer){ // IDEA
//        switch(numberOfPlayer){
//            case 2:
//                players[1]= new Player("player1");
//                players[1].giveNickName();
//                players[2]= new Player("player2");
//                players[2].giveNickName();
//                break;
//            case 3:
//                players[1]= new Player("player1");
//                players[1].giveNickName();
//                players[2]= new Player("player2");
//                players[2].giveNickName();
//                players[3]= new Player("player2");
//                players[3].giveNickName();
//                break;
//            case 4:
//                players[1]= new Player("player1");
//                players[1].giveNickName();
//                players[2]= new Player("player2");
//                players[2].giveNickName();
//                players[3]= new Player("player2");
//                players[3].giveNickName();
//                players[4]= new Player("player1");
//                players[4].giveNickName();
//                break;
//        }
//    }

}

package com.animalgame;

import com.animalgame.Store.StoreHelper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Helper {

        public Scanner console;
        public Player player;

        public Helper () {
        console = new Scanner(System.in);
    }


    public void createMenu(String ...menuChoice) {
        int counter = 1;
        System.out.println("Please enter the number representing your choice: ");
        System.out.println("*".repeat(50));
        System.out.println(" ");
        for (String choice : menuChoice) {
            System.out.print(counter + ". " + choice +"\n");
            counter ++;
        }
        System.out.println(" ");
        System.out.println("*".repeat(50));
    }



    public void validateInput () {
        while (!console.hasNextInt()) {
            System.out.println("Invalid input. Please choose a number.");
            console.next();
        }
    }

    public int menuChoice() {
        validateInput();
        int menuChoice = console.nextInt();
        while (menuChoice > 5 || menuChoice < 1) {
            System.out.println("Sorry, not valid. Choose 1, 2, 3, 4 or 5.");
            validateInput();
            menuChoice = console.nextInt();
        }
        return menuChoice;
    }

    public int numberOfRounds() {
        validateInput();
        int numberOfRounds = console.nextInt();
        while (numberOfRounds > 30 || numberOfRounds < 5) {
            System.out.println("Sorry, not valid. Choose a number between 5 and 30.");
            validateInput();
            numberOfRounds = console.nextInt();
        }
        return numberOfRounds;
    }

    public int numberOfPlayers() {
        validateInput();
        int numberOfPlayers = console.nextInt();
        while (numberOfPlayers > 4 || numberOfPlayers < 2) {
            System.out.println("Sorry, not valid. Choose 2, 3 or 4.");
            validateInput();
            numberOfPlayers = console.nextInt();
        }
        return numberOfPlayers;
    }

    public int animalChoice() {
        validateInput();
        int animalChoice = console.nextInt();
        while (animalChoice > 5 || animalChoice < 1) {
            System.out.println("Sorry, not valid. Choose 1, 2, 3, 4 or 5.");
            validateInput();
            animalChoice = console.nextInt();
        }
        return animalChoice;
    }
    public int foodChoice() {
        validateInput();
        int foodChoice = console.nextInt();
        while (foodChoice > 3 || foodChoice < 1) {
            System.out.println("Sorry, not valid. Choose 1, 2 or 3.");
            validateInput();
            foodChoice = console.nextInt();
        }
        return foodChoice;
    }

    public int sexChoice() {
        validateInput();
        int sexChoice = console.nextInt();
        while (!(sexChoice == 1 || sexChoice == 2)) {
            System.out.println("Sorry, not valid. Choose 1 or 2.");
            validateInput();
            sexChoice = console.nextInt();
        }
        return sexChoice;
    }

    public int shopMore() {
            validateInput();
            int shopMore = console.nextInt();
            while (!(shopMore == 1 || shopMore == 2)) {
                System.out.println("Sorry, not valid. Choose 1 or 2.");
                validateInput();
                shopMore = console.nextInt();

            }
            return shopMore;
    }

    public int sellMore() {
        validateInput();
        int sellMore = console.nextInt();
        while (!(sellMore == 1 || sellMore == 2)) {
            System.out.println("Sorry, not valid. Choose 1 or 2.");
            validateInput();
            sellMore = console.nextInt();

        }
        return sellMore;
    }

    public int vegChoice(){
        validateInput();
        int vegChoice = console.nextInt();
        while (vegChoice > 3 || vegChoice < 1) {
            System.out.println("Sorry, not valid. Choose 1 or 2.");
            validateInput();
            vegChoice = console.nextInt();
        }
        return vegChoice;
    }
    public int meatChoice(){
        validateInput();
        int meatChoice = console.nextInt();
        while (meatChoice > 3 || meatChoice < 1) {
            System.out.println("Sorry, not valid. Choose 1 or 2.");
            validateInput();
            meatChoice = console.nextInt();
        }
        return meatChoice;
    }
    public int milkChoice(){
        validateInput();
        int milkChoice = console.nextInt();
        while (!(milkChoice ==1 || milkChoice == 2)) {
            System.out.println("Sorry, not valid. Choose 1 or 2.");
            validateInput();
            milkChoice= console.nextInt();
        }
        return milkChoice;
    }

    public int indexChosen() {
        validateInput();
        int indexChosen = console.nextInt();
        while (!(indexChosen > player.animalList.size())){
            System.out.println("Sorry, not valid.");
            validateInput();
            indexChosen = console.nextInt();

        }
        return indexChosen;
    }


    public void getWinner(ArrayList<Player> players, int numberOfPlayers){
        String winner;
        String gameTied = "Game is tied. Good job for everyone!";
        Collections.sort(players,new GetResult()); // players list sorted by money low to high
        switch (numberOfPlayers) {
            case 4://4players
                if ((players.get(3).money == players.get(2).money) && (players.get(2).money > players.get(1).money)) { //P4 P3
                    winner = players.get(4).getPlayerName() + players.get(3).getPlayerName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                } else if ((players.get(3).money == players.get(1).money) && (players.get(1).money > players.get(0).money)) { //P4-2
                    winner = players.get(3).getPlayerName() + players.get(2).getPlayerName() + players.get(1).getPlayerName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                } else if (players.get(4).money == players.get(0).money) {//alla
                    System.out.println(gameTied);
                } else {
                    winner = players.get(4).getPlayerName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                }
                break;
            case 3://3 Players , index 210
                if ((players.get(2).money == players.get(1).money) && (players.get(1).money > players.get(0).money)) { //P3 P2
                    winner = players.get(2).getPlayerName() + players.get(1).getPlayerName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                } else if (players.get(2).money == players.get(0).money)  { //P3 P2 P1, alla
                    System.out.println(gameTied);
                } else { // P3
                    winner = players.get(2).getPlayerName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                }
                break;
            case 2://2 players
                if ((players.get(0).money == players.get(1).money)) {
                    System.out.println("Game is tied, good job for both!");
                } else {
                    winner = players.get(1).getPlayerName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                }
        }
    }
    public void updatedAllAnimalHealth(int numberOfPlayers, ArrayList<Player> players){
     for (int p = 0; p < numberOfPlayers - 1; p++) {
        if (!(players.get(p).animalList.isEmpty())) {
            players.get(p).checkAnimalHealth();//check all animals HealthLv
        }
    }
    }

    public void checkPlayersMoney(int numberOfPlayers, ArrayList<Player>players) {
        for (int q = 0; q < numberOfPlayers - 1; q++) {
            if(players.get(q).animalList.isEmpty()) {
                int playerMoney = players.get(q).money;
                if (playerMoney == 0) {
                    System.out.println(players.get(q).getPlayerName() + " has no more money and out from the game!");
                    players.remove(q);
                    numberOfPlayers = players.size();
                }
            }
        }
    }



}

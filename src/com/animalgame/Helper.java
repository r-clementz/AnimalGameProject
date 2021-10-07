package com.animalgame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Helper {

    Scanner console = new Scanner(System.in);

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

    public void clear() {
        System.out.println("\n".repeat(50));
    }

    public void validateInput () {
        while (!console.hasNextInt()) {
            System.out.println("Invalid input. Please choose a number from the menu.");
            console.next();
        }
    }

    public void getWinner(ArrayList<Player> players, int numberOfPlayers){
        String winner;
        String gameTied = "Game is tied. Good job for everyone!";
        Collections.sort(players,new GetResult()); // players list sorted by money low to high
        switch (numberOfPlayers) {
            case 4://4players
                if ((players.get(3).money == players.get(2).money) && (players.get(2).money > players.get(1).money)) { //P4 P3
                    winner = players.get(4).getPlayesName() + players.get(3).getPlayesName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                } else if ((players.get(3).money == players.get(1).money) && (players.get(1).money > players.get(0).money)) { //P4-2
                    winner = players.get(3).getPlayesName() + players.get(2).getPlayesName() + players.get(1).getPlayesName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                } else if (players.get(4).money == players.get(0).money) {//alla
                    System.out.println(gameTied);
                } else {
                    winner = players.get(4).getPlayesName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                }
                break;
            case 3://3 Players , index 210
                if ((players.get(2).money == players.get(1).money) && (players.get(1).money > players.get(0).money)) { //P3 P2
                    winner = players.get(2).getPlayesName() + players.get(1).getPlayesName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                } else if (players.get(2).money == players.get(0).money)  { //P3 P2 P1, alla
                    System.out.println(gameTied);
                } else { // P3
                    winner = players.get(2).getPlayesName();
                    System.out.println("Winner(s): " + winner + ", congratulations:)");
                }
                break;
            case 2://2 players
                if ((players.get(0).money == players.get(1).money)) {
                    System.out.println("Game is tied, good job for both!");
                } else {
                    winner = players.get(1).getPlayesName();
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
            int playerMoney = players.get(q).money;
            if (playerMoney == 0) {
                System.out.println(players.get(q).getPlayesName() + " has no more money and out from the game!");
                players.remove(q);
                numberOfPlayers = players.size();
            }
        }
    }



}

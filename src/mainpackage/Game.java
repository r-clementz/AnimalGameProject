package mainpackage;

import java.util.Scanner;

public class Game {
    public Scanner console;
    private int numberOfPlayer;
    private int numberOfRound;
    public int [] playersChoices;
    private Store store;
    private Animal animal;
   // public Player[] players;
    public Game(){
        console= new Scanner (System.in);
        store = new Store();
        playersChoices = new int[3];
        //players = new Player[3];


    }
    public void newGame(){
        //Round 5-30

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

package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private String name;
    public int money;
    public ArrayList<Animal> animalList;
    public ArrayList<Food> foodStock;
    public Scanner console;

    public Player(String name) {
        this.name = name;
        this.money = 500;
        animalList = new ArrayList<>();
        foodStock = new ArrayList<>();
        console = new Scanner(System.in);
    }

//    public void createPlayers (int numberOfPlayers){
//        switch (numberOfPlayers) {
//
//            case 2:
//                Player player1 = new Player("player1");
//                Player player2 = new Player("player2");
//                System.out.println("Now we have :" + player1 + player2 );
//                break;
//            case 3:
//                player1 = new Player("player1");
//                player2 = new Player("player2");
//                Player player3 = new Player("player3");
//                System.out.println("Now we have :" + player1 + player2 +player3);
//                break;
//            case 4:
//                player1 = new Player("player1");
//                player2 = new Player("player2");
//                player3 = new Player("player3");
//                Player player4 = new Player("player4");
//                System.out.println("Now we have :" + player1 + player2 +player3 +player4 );
//                break;
//            default:
//                System.out.println("Invalid input! ");
//                break;
//
//        }
//    }


    public void seeAnimalList() {
        System.out.println("Here are animals in your list ");
        for (int i = 0; i <= this.animalList.size(); i++) {
            System.out.println(i + ". :\t" + this.animalList.get(i));
        }
    }
    public void seeFoodlist(){
        for (int i = 0; i <= this.foodStock.size(); i++) {
            System.out.println(i + ". :\t" + this.foodStock.get(i));
        }
    }

    public void feedAnimal() {
        //show animal(s) player's list
        seeAnimalList();
        //player pick up animal
        System.out.println("Please choose animal you'd like to feed.");
        int indexPicked1 = console.nextInt();
        Animal animalPicked = animalList.get(indexPicked1);

        //show players food list
        seeFoodlist();
        //player pick up food
        System.out.println("Please choose food to give.");
        int indexPicked2 = console.nextInt();
        Food foodPicked = this.foodStock.get(indexPicked2);
        //Show amount of food exists
        System.out.println("You have "+ foodPicked.amount + "kg of "+foodPicked);
        System.out.println("Please choose the amount you'd like to give.");
        //player chooses the amount
        int amountPicked = console.nextInt();
        //update stock
        if (amountPicked == foodPicked.amount){
            this.foodStock.remove(foodPicked);
        }
        else{
            foodPicked.amount= foodPicked.amount -amountPicked;
        }
        //animal eats food and gain energy if it can eat food chosen
        animalPicked.eat(foodPicked);
        //show updated energy
        System.out.println("Now " + animalPicked + "'s health is " + animalPicked.healthLevel);
    }

    public void pairAnimals() {
        //see animals in the list
        seeAnimalList();
        // choose first one
        System.out.println("Please choose first animal to pair up");
        int firstChoice = console.nextInt();
        Animal pair1 = this.animalList.get(firstChoice);
        // choose second one
        System.out.println("Please choose second animal to pair up");
        int secondChoice = console.nextInt();
        Animal pair2 = this.animalList.get(secondChoice);

        //see if animal chosen fills the requirement to pair up (same animal, different sex)
        //same animal and same sex
        if ((pair1.getAnimalsSex() == pair2.getAnimalsSex()) && (pair1.getClass() == pair2.getClass())) {
            System.out.println("You can't pair up the same sex!");
        }
        // different animals (animals are not in the same class)
        else if (!(pair1.getClass() == pair2.getClass())) {
            System.out.println("You can't pair different animals");
        }
        // fill the requirement (same animal, different sex)
        else {
            int possibility = (int) (Math.random() * 1);
            switch (possibility) {
                case 0:
                    System.out.println("pairing was unsuccessful");
                    break;
                case 1: // pairing succeeded
                    pair1.babyborn(pair1,this);
                    break;
            }
        }
    }

}

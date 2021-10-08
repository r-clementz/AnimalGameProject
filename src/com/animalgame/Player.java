package com.animalgame;

import com.animalgame.abstractclass.Animal;
import com.animalgame.abstractclass.Food;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
/**This Class generates methods of
 * what player can do in the game.
 * @author Rie,
 * */

public class Player {
    private String playerName;
    public int money;
    public ArrayList<Animal> animalList;
    public ArrayList<Food> foodStock;
    public Scanner console;


    public Player(String playerName, int money) {
        this.playerName = playerName;
        this.money = 10000;
        animalList = new ArrayList<>();
        foodStock = new ArrayList<>();
        console = new Scanner(System.in);
    }
    /** Player check all animals name in own animal list.
     * */
    public void seeAnimalList() {

            System.out.println("Here are animals in your list ");
            for (int i = 0; i <= this.animalList.size() - 1; i++) {
                System.out.println(i + ". :\t" + this.animalList.get(i).getSpecies() + ", " + this.animalList.get(i).name);

            }
        }


    /** Player check all name of food  in own food list.
     * */
    public void seeFoodList() {
        System.out.println("Here are food in your list ");
        for (int i = 0; i <= this.foodStock.size() - 1; i++) {
                System.out.println(i + ". :\t" + this.foodStock.get(i).name);
            }
        }


    /** Player check all animals name and health level
     *  in own animal list
     * */
    public void printAnimalList() {//if nothing in list no print
        if (this.animalList.isEmpty()) {
            System.out.println("You have no animal at the moment.");
        } else {
            System.out.println("Here are your animals: ");
            for (int i = 0; i <= this.animalList.size() - 1; i++) {
                System.out.print(this.animalList.get(i).name + ":");
                System.out.println("Health Lv: " + ((int)(this.animalList.get(i).healthLevel / 0.9)) + "->" + this.animalList.get(i).healthLevel + ".");
            }
        }
    }

    /** Player check all name and amount of food
     *  in own food list.
     * */
    public void printFoodList() {
        if (this.foodStock.isEmpty()) {
            System.out.println("You have no food at the moment.");
        } else {
            System.out.println("This is your pantry: ");
            for (int i = 0; i <= this.foodStock.size() - 1; i++) {
                System.out.print(this.foodStock.get(i).name + ": " + this.foodStock.get(i).amount + " |");
            }
        }
    }

    /** Player chooses animal and food in the list.
     * Amount of food player chosen will be fed to chosen animal.
     * */
    public void feedAnimal() {
        if(this. animalList.isEmpty()|| this. foodStock.isEmpty()){
            System.out.println("You don't have any animal or food to feed!");
        }
        else{
            //show animal(s) player's list
            seeAnimalList();
            //player pick up animal
            System.out.println("Please choose animal you'd like to feed.");
            int indexPicked1 = console.nextInt();
            Animal animalPicked = animalList.get(indexPicked1);

            //show players food list
            seeFoodList();
            //player pick up food
            System.out.println("Please choose food to give.");
            int indexPicked2 = console.nextInt();
            Food foodPicked = this.foodStock.get(indexPicked2);
            //Show amount of food exists
            System.out.println("You have "+ foodPicked.amount + "kg of "+foodPicked.name);
            System.out.println("Please choose the amount you'd like to give.");
            //player chooses the amount
            int amountPicked = console.nextInt();
            //update stock
            if (amountPicked == foodPicked.amount){
                this.foodStock.remove(foodPicked);
            }
            else{//if player didn't feed everything, food remains in the list
                foodPicked.amount= foodPicked.amount -amountPicked;
            }

            //animal eats food and gain energy if it can eat food chosen
            if(animalPicked.healthLevel<animalPicked.getOriginalHL()) { //filter if the animal can eat food
                animalPicked.eat(foodPicked, this, indexPicked1, amountPicked);
                //show previous too
                System.out.println("Previous health level: " + animalPicked.healthLevel);
                // show updated energy
                System.out.println("Now " +animalList.get(indexPicked1).name + "'s health is " + animalList.get(indexPicked1).healthLevel);
            }
            else if (animalPicked.healthLevel<= animalPicked.getOriginalHL()) {
                System.out.println(animalPicked.name+ " is full now and can't eat! ");
            }

        }
    }

    /** Player check all animals in own animal list.
     * */
    public void pairAnimals() { //tested and work!
        if((animalList.isEmpty())||(animalList.size()==1)){
            System.out.println("You don't have any animal!");
        }
        else{
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
                int possibility = (int) (Math.random() * 2)+1;
                switch (possibility) {
                    case 1:
                        System.out.println("pairing was unsuccessful");
                        break;
                    case 2: // pairing succeeded
                        System.out.println("Please give a name to baby");
                        String babyName = console.next();
                        pair1.babyborn(pair2,this,babyName);
                        break;
                }
            }
        }
    }

    public void checkAnimalHealth() {
        for (int i = 0; i < animalList.size(); i++) {
            animalList.get(i).healthLevel = (int) (animalList.get(i).healthLevel * 0.9);// update healthLv
            if (animalList.get(i).healthLevel == 0) {
                animalList.get(i).die(this);
            }
        }
    }

    public void lostAnimal(int numberOfPlayers, ArrayList<Player> players) {
        for (int p = 1; p < numberOfPlayers; p++) {
            for (int j = 0; j < animalList.size()-1; j++) {
                int animalHL = players.get(p-1).animalList.get(j).healthLevel;
                if (animalHL == 0) {
                    System.out.println(players.get(p-1).getPlayerName() + ", ");
                    players.get(p-1).animalList.get(j).die(players.get(p));
                }
            }

        }
    }



    public String getPlayerName(){
        return playerName;
    }
    @Override
    public String toString() {
        return playerName;
    }
}

class GetResult implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        return o1.money - o2.money;
    }
    //Collections.sort(players, new compare());

}
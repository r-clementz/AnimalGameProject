package com.animalgame.Store;

import com.animalgame.Helper;
import com.animalgame.Player;
import com.animalgame.abstractclass.*;
import com.animalgame.animals.*;
import com.animalgame.food.*;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreHelper {
    Scanner console;
    public Helper helper;
    StoreHelper(){
        console= new Scanner(System.in);
        helper = new Helper();
    }

    public void createNewAnimals(int animalChoice, int sexChoice, ArrayList<Animal> animalChosen, String name) {
        switch (animalChoice) {
            case 1://Dog
                if (sexChoice == 1) { //male
                    animalChosen.add(new Dog(name, "male"));
                } else if (sexChoice == 2) {
                    animalChosen.add(new Dog(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 2://Cat
                if (sexChoice == 1) { //male
                    animalChosen.add(new Cat(name, "male"));
                } else if (sexChoice == 2) {
                    animalChosen.add(new Cat(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 3://Unicorn
                if (sexChoice == 1) { //male
                    animalChosen.add(new Unicorn(name, "male"));
                } else if (sexChoice == 2) {
                    animalChosen.add(new Unicorn(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 4: //Rabbit
                if (sexChoice == 1) { //male
                    animalChosen.add(new Rabbit(name, "male"));
                } else if (sexChoice == 2) {
                    animalChosen.add(new Rabbit(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 5: //Bat
                if (sexChoice == 1) { //male
                    animalChosen.add(new Bat(name, "male"));
                } else if (sexChoice == 2) {
                    animalChosen.add(new Bat(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    public void checkTotalPrice(Player player, ArrayList<Animal> animalChosen, ArrayList<Integer> priceTotal) {
        for (int i = 0; i < animalChosen.size(); i++) {
            int animalPrice = animalChosen.get(i).price;
            player.money = player.money - animalPrice;
            priceTotal.add(animalPrice);
        }

    }
    public int decideAmountToBuy(){
        System.out.println("How much you'd like to get?");
        int amount = console.nextInt();
        return amount;
    }

    public void checkMoneyAndAdd(int sum, Player player, ArrayList<Animal> animalChosen) {
        if (sum > player.money) {
            System.out.println("You don't have enough money and no animal is added to the list.");
        } else if (sum == player.money) {
            System.out.println("You have just enough to buy but no money left!");
            player.animalList.addAll(animalChosen);
            ;
        } else {
            player.animalList.addAll(animalChosen);
            System.out.println("You have " + player.money + "kr left after payment and the list updated");


        }
    }


    public void chooseVeg(ArrayList<Food> foodChosen, ArrayList<Integer>amountChosen) {
        System.out.println("1.Carrot (3kr) 2. Cabbage(5kr) 3.Potato (3kr)");
        int vegChoice = helper.vegChoice();
        int amount = decideAmountToBuy();
        switch (vegChoice) {
            case 1://Carrot

                    foodChosen.add(new Veggies("Carrot", 3));
                    amountChosen.add(amount);

                break;
            case 2: //Cabbage

                    foodChosen.add(new Veggies("Cabbage", 5));
                    amountChosen.add(amount);

                break;
            case 3://Potato

                    foodChosen.add(new Veggies("Potato", 3));
                    amountChosen.add(amount);

        }
    }

    public void chooseMeat(ArrayList<Food> foodChosen, ArrayList<Integer>amountChosen) {
        System.out.println("1.Chicken (12kr) 2. Beef(25kr)");
        int meatChoice = helper.meatChoice();
        int amount = decideAmountToBuy();
        switch (meatChoice ){
            case 1://Chicken
                foodChosen.add(new Meat("Chicken", 12));
                amountChosen.add(amount);
                break;
            case 2: //Beef
                foodChosen.add(new Meat("Beef", 25));
                amountChosen.add(amount);
                break;
        }
    }

    //NEED TO CHECK IF PLAYER CHOSE THAT FOOD BEFORE IN THE SAME ROUND
    public void chooseMilk(ArrayList<Food> foodChosen, ArrayList<Integer>amountChosen) {
        System.out.println("1.Cow milk (10kr) 2.Oats milk(12kr)");
        int milkChoice = helper.milkChoice();
        int amount = decideAmountToBuy();
        switch (milkChoice){
            case 1://milk

               foodChosen.add(new Milk("Cow milk", 10));
                    amountChosen.add(amount);
                    break;
            case 2: //Oats
                foodChosen.add(new Milk("Cow milk", 12));
                    amountChosen.add(amount);
                break;
            }
        }

    public void payAndUpdateList(Player player, ArrayList<Food> foodChosen, ArrayList<Integer> amountChosen) {

            // food player bought added to the one already exist on the list


             //checking current p's list

                // Food player bought is not in current list


            System.out.println("Food is added to your list! Now you have " + player.money + "kr left");
        }
    }





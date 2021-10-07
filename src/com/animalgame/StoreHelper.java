package com.animalgame;

import com.animalgame.abstractclass.*;
import com.animalgame.animals.*;
import com.animalgame.food.*;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreHelper {
    Scanner console= new Scanner(System.in);

    public void createNewAnimals(int choice, int choice2, ArrayList<Animal> animalChosen, String name) {
        switch (choice) {
            case 1://Dog
                if (choice2 == 1) { //male
                    animalChosen.add(new Dog(name, "male"));
                } else if (choice2 == 2) {
                    animalChosen.add(new Dog(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 2://Cat
                if (choice2 == 1) { //male
                    animalChosen.add(new Cat(name, "male"));
                } else if (choice2 == 2) {
                    animalChosen.add(new Cat(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 3://Unicorn
                if (choice2 == 1) { //male
                    animalChosen.add(new Unicorn(name, "male"));
                } else if (choice2 == 2) {
                    animalChosen.add(new Unicorn(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 4: //Rabbit
                if (choice2 == 1) { //male
                    animalChosen.add(new Rabbit(name, "male"));
                } else if (choice2 == 2) {
                    animalChosen.add(new Rabbit(name, "female"));
                } else {
                    System.out.println("Invalid input");
                }
                break;
            case 5: //Bat
                if (choice2 == 1) { //male
                    animalChosen.add(new Bat(name, "male"));
                } else if (choice2 == 2) {
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


    public void chooseVeg(ArrayList<Food> foodChosen, Player player) {
        System.out.println("1.Carrot (3kr) 2. Cabbage(5kr) 3.Potato (3kr)");
        int vegChoice = console.nextInt();
        if (vegChoice == 1) {//Carrot
            foodChosen.add(new Veggies("Carrot", 3));
        } else if (vegChoice == 2) {
            foodChosen.add(new Veggies("Cabbage", 5));
        } else if (vegChoice == 3) {
            foodChosen.add(new Veggies("Potato", 3));
        }
    }

    public void chooseMeat(ArrayList<Food> foodChosen, Player player) {
        System.out.println("1.Chicken (12kr) 2. Beef(25kr)");
        int meatChoice = console.nextInt();

        if (meatChoice == 1) {//Chicken
            foodChosen.add(new Meat("Chicken", 12));
        } else if (meatChoice == 2) {//Beef
            foodChosen.add(new Meat("Beef", 25));

        }
    }

    public void chooseMilk(ArrayList<Food> foodChosen, Player player) {
        System.out.println("1.Cow milk (10kr) 2.Oats milk(12kr)");
        int milkChoice = console.nextInt();

        if (milkChoice == 1) {//Carrot
            foodChosen.add(new Milk("Cow milk", 10));
        } else if (milkChoice == 2) {
            foodChosen.add(new Milk("Oats milk", 12));
        }
    }

    public void payAndUpdateList(Player player, ArrayList<Food> foodChosen, ArrayList<Integer> amountChosen) {
        for (int i = 0; i < foodChosen.size(); i++) {
            player.money = player.money - foodChosen.get(i).price; //pay

            // food player bought added to the one already exist on the list
            if (player.foodStock.contains(foodChosen.get(i))) { //checking current p's list
                int index = player.foodStock.indexOf(foodChosen.get(i));
                int newAmount = player.foodStock.get(index).amount + amountChosen.get(i);
                player.foodStock.get(index).amount = newAmount;
            } else { // Food player bought is not in current list
                player.foodStock.add(foodChosen.get(i));// added food
                int index = player.foodStock.indexOf(foodChosen.get(i));
                player.foodStock.get(i).amount = amountChosen.get(i); //added amount
            }
        }
        System.out.println("Food is added to your list! Now you have " + player.money + "kr left");
    }
}





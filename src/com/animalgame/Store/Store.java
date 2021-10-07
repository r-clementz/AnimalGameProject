package com.animalgame.Store;


import java.util.ArrayList;
import java.util.Scanner;

import com.animalgame.Player;
import com.animalgame.abstractclass.Animal;
import com.animalgame.abstractclass.Food;
import com.animalgame.Helper;


public class Store {
    public Scanner console;
    public StoreHelper storehelper;
    public Helper helper;


    public Store() {
        console = new Scanner(System.in);
        storehelper = new StoreHelper();
        helper = new Helper();
    }

    public void buyAnimal(Player player) { // double checked!
        ArrayList<Animal> animalChosen = new ArrayList<>();
        boolean playerWannaChoose = true;

        System.out.println("Please Choose the number for animal you'd like to buy");
        while (playerWannaChoose) {
            System.out.println("1.Dog (50kr) 2.Cat(40kr) 3.Unicorn(150kr) 4.Rabbit(30kr)  5.Bat(20kr)");
            //int choice = console.nextInt(); // animal choice
            int choice = helper.choice();
            System.out.println("Please choose its sex: 1.male 2.female");
            //int choice2 = console.nextInt();// sex choice
            int choice2 = helper.choice2();
            System.out.println("Give it a name:");
            String name = console.next();// animal's name
            storehelper.createNewAnimals(choice, choice2, animalChosen, name);
            // player can keep going
            System.out.println("Would you like to choose more?\n1.Yes 2.No");
            //int choice3 = console.nextInt();
            int choice3 = helper.choice3();
            if (choice3 == 2) {
                playerWannaChoose = false;
                System.out.println("Now you'd move to payment:\n");
            }
        }
        //payment
        ArrayList<Integer> priceTotal = new ArrayList<>();
        storehelper.checkTotalPrice(player, animalChosen, priceTotal);
        int sum = priceTotal.stream().mapToInt(Integer::intValue).sum();
        storehelper.checkMoneyAndAdd(sum, player, animalChosen);
    }

    public void buyFood(Player player) {
        ArrayList<Food> foodChosen = new ArrayList<>();
        ArrayList<Integer> amountChosen = new ArrayList<>();
        boolean playerWannaMore = true;

        while (playerWannaMore) {
            System.out.println("Please choose the number for food you'd like to buy.");
            System.out.println("1. Veggies 2. Meat 3. Milk");
            //int choice1 = console.nextInt();
            int choice1 = helper.choice1();
            switch (choice1) {
                case 1: //veggie
                    storehelper.chooseVeg(foodChosen, player);
                    break;
                case 2: //meat
                    storehelper.chooseMeat(foodChosen, player);
                    break;
                case 3://milk
                    storehelper.chooseMilk(foodChosen, player);
                    break;
                default:
                    System.out.println("Invalid input");
            }
            System.out.println("How much you'd like to get?");
            int amount = console.nextInt();
            amountChosen.add(amount);
            //loop until player decides to finish
            System.out.println("Would you like to buy other food? : 1.Yes 2.No");
            int choice2 = console.nextInt();
            switch (choice2) {
                case 1:
                    break;
                case 2:
                    playerWannaMore = false;
                    System.out.println("Now you move to payment");
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
        //payment and update the list
        storehelper.payAndUpdateList(player, foodChosen, amountChosen);
    }

    public void sellAnimal(Player player) {
        if (player.animalList.isEmpty()) {
            System.out.println("No animal in your list!");
        } else {
            boolean playerWannaSell = true;
            //show players animal list
            System.out.println("Here is your animal list:\n");
            while (playerWannaSell) {
                for (int i = 0; i < player.animalList.size(); i++) {
                    System.out.println(i + "." + player.animalList.get(i).name);
                }


                System.out.println("Please choose which Animal you'd like to sell.");
                int indexChosen = console.nextInt();//player choose index for animal to sel;
                Animal animalToSell = player.animalList.get(indexChosen);//get animal from the list

                int currentHealth = animalToSell.healthLevel;
                int priceToSell = 0;
                if (currentHealth == animalToSell.getOriginalHL()) {
                    priceToSell = animalToSell.price;
                } else if (currentHealth >= (animalToSell.getOriginalHL() / 2)) { //Health Lv is more than 50%
                    priceToSell = animalToSell.price / 2;
                } else if (currentHealth < (animalToSell.getOriginalHL() / 2)) {//Health Lv is less than 50%
                    priceToSell = animalToSell.price / 4;
                }
                System.out.println(animalToSell.name + "is sold for " + priceToSell);
                player.animalList.remove(animalToSell);
                player.money = player.money + priceToSell;

                System.out.println("Woudl you like to sell more?\n1.Yes 2.No");
                int playersChoice = console.nextInt();
                switch (playersChoice) {
                    case 1://Yes
                        break;
                    case 2://No
                        playerWannaSell = false;
                        System.out.println("See you next time!");
                        break;
                    default:
                        System.out.println("Invalid input!");

                }
            }
        }
    }

    public void sellAllanimals(Player player) {
        ArrayList<Integer> allAnimalPrices = new ArrayList<>();
        int animalPrice; //check all animal prices and sell
        for (int i = 0; i < player.animalList.size(); i++) {
            int currentLv = player.animalList.get(i).healthLevel;

            if (currentLv == player.animalList.get(i).getOriginalHL()) {
                animalPrice = player.animalList.get(i).price;
                allAnimalPrices.add(animalPrice);
            } else if (currentLv >= (player.animalList.get(i).getOriginalHL() / 2)) { //Health Lv is more than 50%
                animalPrice = player.animalList.get(i).price / 2;
                allAnimalPrices.add(animalPrice);
            } else if (currentLv < (player.animalList.get(i).getOriginalHL() / 2)) {//Health Lv is less than 50%
                animalPrice = player.animalList.get(i).price / 4;
                allAnimalPrices.add(animalPrice);
            }
        } //get money after selling all animals
        int sum = allAnimalPrices.stream().mapToInt(Integer::intValue).sum();
        player.animalList.clear(); // all animal is gone from the list
        player.money = player.money + sum;

    }

}
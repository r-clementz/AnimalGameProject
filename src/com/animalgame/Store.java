package com.animalgame;


import java.util.ArrayList;
import java.util.Scanner;
import com.animalgame.food.*;
import com.animalgame.animals.*;


public class Store {
    public Scanner console;


    public Store() {
        console = new Scanner(System.in);
    }

    public void buyAnimal(Player player) { //checked! worked with testing at least..
        ArrayList<Animal> animalChosen = new ArrayList<>();
        boolean playerWannaChoose = true;
        System.out.println("Please Choose the number for animal you'd like to buy");
        while (playerWannaChoose) {
            System.out.println("1.Dog (50kr) 2.Cat(40kr) 3.Unicorn(150kr) 4.Rabbit(30kr)  5.Bat(20kr)");
            int choice = console.nextInt(); // animal choice
            System.out.println("Please choose its sex: 1.male 2.female");
            int choice2 = console.nextInt();// sex choice
            System.out.println("Give it a name:");
            String name = console.next();// animal's name
            switch (choice) {
                case 1://Dog
                    if (choice2 == 1) { //male
                        animalChosen.add(new Dog(name, "male"));
                    } else if (choice2 == 2) {
                        animalChosen.add(new Dog(name, "female"));
                    }
                    break;
                case 2://Cat
                    if (choice2 == 1) { //male
                        animalChosen.add(new Cat(name, "male"));
                    } else if (choice2 == 2) {
                        animalChosen.add(new Cat(name, "female"));
                    }
                    break;
                case 3://Unicorn
                    if (choice2 == 1) { //male
                        animalChosen.add(new Unicorn(name, "male"));
                    } else if (choice2 == 2) {
                        animalChosen.add(new Unicorn(name, "female"));
                    }
                    break;
                case 4: //Rabbit
                    if (choice2 == 1) { //male
                        animalChosen.add(new Rabbit(name, "male"));
                    } else if (choice2 == 2) {
                        animalChosen.add(new Rabbit(name, "male"));
                    }
                    break;
                case 5: //Bat
                    if (choice2 == 1) { //male
                        animalChosen.add(new Bat(name, "male"));
                    } else if (choice2 == 2) {
                        animalChosen.add(new Bat(name, "female"));
                    }
                    break;
            }
            // player can keep going
            System.out.println("Would you like to choose more?\n1.Yes 2. No");
            int choice3 = console.nextInt();
            switch (choice3) {
                case 1:
                    break;
                case 2:
                    playerWannaChoose = false;
                    break;
            }
        }
        //payment
        for(int i=0; i<= animalChosen.size(); i++){
            int moneyLeft = (player.money) - (animalChosen.get(i).price);
            if(moneyLeft<=0){
                System.out.println("You don't have enough money to buy all animal you chose.");
            }
            else {
                player.money = moneyLeft;
                player.animalList.addAll(animalChosen);
                System.out.println("All animal is added to your list! ");
            }
        }

    }

    public void buyFood(Player player) {
        ArrayList<Food> foodChoices = new ArrayList<>();
        boolean playerWannaBuy = true;
        while (playerWannaBuy) {
            showFoodMenu();
            switch (showFoodMenu()) {
                case 1: //Veggie
                    System.out.println("1.Carrot (3kr) 2. Cabbage(5kr) 3.Potato (3kr)");
                    int vegChoice = console.nextInt();
                    System.out.println("How much you'd like? (kg)");
                    int vegAmount = console.nextInt();
                    if (vegChoice == 1) {
                        foodChoices.add(new Veggies("Carrot", vegAmount));
                        player.money = player.money - vegAmount * 3;
                    }
                    else if (vegChoice == 2) {
                        foodChoices.add(new Veggies("Cabbage", vegAmount));
                        player.money = player.money - vegAmount * 5;
                    }
                    else if (vegChoice == 3) {
                        foodChoices.add(new Veggies("Potato", vegAmount));
                        player.money = player.money - vegAmount * 3;
                    }
                    break;
                case 2: //Meat
                    System.out.println("1.Chicken(12kr) 2. Beef(25kr)");
                    int meatChoice = console.nextInt();
                    System.out.println("How much you'd like?(kg)");
                    int meatAmount = console.nextInt();
                    if (meatChoice == 1) {
                        foodChoices.add(new Meat("Chicken", meatAmount));
                        player.money = player.money - meatAmount * 12;
                    }
                    else if (meatChoice == 2) {
                        foodChoices.add(new Meat("Beef", meatAmount));
                        player.money = player.money - meatAmount * 25;
                    }
                    break;

                case 3://Milk
                    System.out.println("1.Cow milk (10kr) 2. Oat milk(12kr)");
                    int milkChoice = console.nextInt();
                    System.out.println("How much you'd like?(Liter)");
                    int milkAmount = console.nextInt();
                    if (milkChoice == 1) {
                        foodChoices.add(new Milk("Cow milk", milkAmount));
                        player.money = player.money - milkAmount * 10;
                    }
                    else if (milkChoice == 2) {
                        foodChoices.add(new Milk("Oat milk", milkAmount));
                        player.money = player.money - milkAmount * 12;
                    }
                    break;
            }
            System.out.println("If you'd like to finish buying, input 0");
            if ((player.money == 0)) {
                playerWannaBuy = false;
                System.out.println("You can't buy more than you can afford! Try another time. "); // player get no food
            }
            else if (showFoodMenu() == 0) {
                playerWannaBuy = false;
                player.foodStock.addAll(foodChoices);
            }


        }
    }

    public void sellAnimal(Player player) {
        boolean playerWannaSell = true;
        //Show all animals in player's list
        System.out.println("Here is your animal list:\n");
        for (int i = 0; i < player.animalList.size(); i++) {
            System.out.println(i + "." + player.animalList.get(i));
        }
        while (playerWannaSell) {
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
            System.out.println(animalToSell + "is sold for " + priceToSell);
            player.animalList.remove(animalToSell);
            player.money = player.money + priceToSell;

            System.out.println("Woudl you like to sell more?\n1.Yes 2.No");
            int playersChoice = console.nextInt();
            switch (playersChoice) {
                case 1://Yes
                    break;
                case 2://No
                    playerWannaSell = false;
                    System.out.println("OK, see you next time!");
            }
        }
    }


        public void showAnimalMenu () {
            System.out.println("Please Choose the number for animal you'd like to buy");
            System.out.println("1.Dog 2. Cat  3. Unicorn 4. Rabbit 5. Bat ");
            System.out.println("The price for each Animal: 1.50kr 2.40kr 3.100kr 4.30kr 5.20kr");
        }

        public int showFoodMenu () {
            System.out.println("Please choose the number for Food you'd like to buy");
            System.out.println("1. Veggies 2. Meat 3. Milk");
            int foodChoice = console.nextInt();
            System.out.println("Which one you'd like to get?");
            return foodChoice;
        }

//        public void checkFoodStock(Player player){
//        if(player.foodStock.contains("Carrot")){
//           int index=player.foodStock.indexOf("Carrot");
//           int currentAmount =player.foodStock.get(index).amount;
//            player.foodStock.get(index).amount= currentAmount+vegAmount;
//
//        }
//        }


}
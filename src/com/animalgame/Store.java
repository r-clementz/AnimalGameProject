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
        ArrayList<Food> foodChosen = new ArrayList<>();
        ArrayList<Integer> amountChosen = new ArrayList<>();
        boolean playerWannaMore= true;

        while(playerWannaMore) {
            System.out.println("Please choose the number for food you'd like to buy.");
            System.out.println("1. Veggies 2. Meat 3. Milk");
            int choice1 = console.nextInt();
            switch (choice1) {
                case 1: //veggie
                    chooseVeg(foodChosen, player);
                    break;
                case 2: //meat
                    chooseMeat(foodChosen, player);
                    break;
                case 3://milk
                    chooseMilk(foodChosen, player);
                    break;
            }
            System.out.println("How much you'd like to get?");
            int amount = console.nextInt();
            amountChosen.add(amount);
            //loop until player decides to finish
            System.out.println("Would you like to buy other food? : 1.Yes 2.No");
            int choice2 = console.nextInt();
            if(choice2==2){
                playerWannaMore=false;
            }
        }
        for (int i = 0; i < foodChosen.size(); i++) {//payment and update the list
            player.money = player.money - foodChosen.get(i).price; //pay
            if (player.foodStock.contains(foodChosen.get(i))) {
                int index = player.foodStock.indexOf(foodChosen.get(i));
                int newAmount = player.foodStock.get(index).amount +amountChosen.get(i);
                player.foodStock.get(index).amount = newAmount;
            }// food player bought added to the one already exist on the list
            else {
                player.foodStock.add(foodChosen.get(i));// added food
                int index = player.foodStock.indexOf(foodChosen.get(i));
                player.foodStock.get(i).amount = amountChosen.get(i); //added amount
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

    public void chooseVeg(ArrayList<Food> foodChosen,Player player) {
        System.out.println("1.Carrot (3kr) 2. Cabbage(5kr) 3.Potato (3kr)");
        int vegChoice = console.nextInt();
        if(vegChoice==1) {//Carrot
            foodChosen.add(new Veggies ("Carrot"));
        }
        else if (vegChoice==2) {
            foodChosen.add(new Veggies("Cabbage"));
        }
        else if (vegChoice==3){
            foodChosen.add(new Veggies ("Potato"));
        }
    }

    public void chooseMeat(ArrayList<Food> foodChosen, Player player){
        System.out.println("1.Chicken (12kr) 2. Beef(25kr)");
        int meatChoice = console.nextInt();

        if(meatChoice==1) {//Chicken
            foodChosen.add(new Meat ("Chicken"));
        }
        else if (meatChoice==2){//Beef
            foodChosen.add(new Meat ("Beef"));

        }
    }

    public void chooseMilk (ArrayList<Food> foodChosen, Player player){
        System.out.println("1.Cow milk (10kr) 2.Oats milk(12kr)");
        int milkChoice = console.nextInt();

        if(milkChoice==1) {//Carrot
            foodChosen.add(new Milk ("Cow milk"));
        }
        else if (milkChoice==2){
            foodChosen.add(new Milk  ("Oats milk"));
        }
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
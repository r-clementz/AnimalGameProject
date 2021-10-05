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

    public void buyAnimal(Player player) { // completed!
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
            createNewAnimals(choice, choice2, animalChosen, name);
            // player can keep going
            System.out.println("Would you like to choose more?\n1.Yes 2.No");
            int choice3 = console.nextInt();
            if (choice3 == 2) {
                playerWannaChoose = false;
                System.out.println("Now you'd move to payment:\n");
            }
        }
        //payment
        ArrayList<Integer> priceTotal = new ArrayList<>();
        checkTotalPrice(player, animalChosen, priceTotal);
        int sum = priceTotal.stream().mapToInt(Integer::intValue).sum();
        checkMoneyAndAdd(sum, player, animalChosen);
    }

    public void buyFood(Player player) { //completed!
        ArrayList<Food> foodChosen = new ArrayList<>();
        ArrayList<Integer> amountChosen = new ArrayList<>();
        boolean playerWannaMore = true;

        while (playerWannaMore) {
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
            switch (choice2) {
                case 1:
                    break;
                case 2:
                    playerWannaMore = false;
                    System.out.println("Now you move to payment");
                    break;
            }
        }
        //payment and update the list
        //payment
        payAndUpdateList(player,foodChosen,amountChosen);
    }

    public void sellAnimal(Player player) { //NEED TO TEST
        boolean playerHasAnimal = true;
        boolean playerWannaSell = true;
        while(playerHasAnimal) {
            //check if player has animal to sell
            if (player.animalList.size() == 0) {
                System.out.println("You have no Animal to Sell!");
                playerHasAnimal = false;
            }
            //show players animal list
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
                        playerHasAnimal = false;
                        System.out.println("See you next time!");
                }
            }
        }
    }
    public void sellAllanimals(Player player){ //NEED TO TEST
        ArrayList<Integer> allAnimalPrices = new ArrayList<>();
        int animalPrice;
        for (int i=0; i<player.animalList.size();i++){
            int currentLv = player.animalList.get(i).healthLevel;

            if (currentLv == player.animalList.get(i).getOriginalHL()) {
                animalPrice = player.animalList.get(i).price;
                allAnimalPrices.add(animalPrice);
            }
            else if (currentLv >= (player.animalList.get(i).getOriginalHL() / 2)) { //Health Lv is more than 50%
                animalPrice = player.animalList.get(i).price/2;
                allAnimalPrices.add(animalPrice);
            }
            else if (currentLv < (player.animalList.get(i).getOriginalHL() / 2)) {//Health Lv is less than 50%
                animalPrice = player.animalList.get(i).price / 4;
                allAnimalPrices.add(animalPrice);
            }
        }
        int sum = allAnimalPrices.stream().mapToInt(Integer::intValue).sum();
        player.animalList.clear(); // all animal is gone from the list
        player.money= player.money + sum;

    }












    //supporting methods
    public void createNewAnimals(int choice, int choice2, ArrayList<Animal> animalChosen, String name) {
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
                    animalChosen.add(new Rabbit(name, "female"));
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
    }

    public void checkTotalPrice(Player player,ArrayList<Animal> animalChosen,ArrayList<Integer> priceTotal){
        for (int i = 0; i < animalChosen.size(); i++) {
            int animalPrice =animalChosen.get(i).price;
            player.money = player.money - animalPrice;
            priceTotal.add(animalPrice);
        }

    }


    public void checkMoneyAndAdd (int sum,Player player, ArrayList<Animal> animalChosen) {
        if(sum>player.money){
            System.out.println("You don't have enough money and no animal is added to the list.");
        }
        else if (sum==player.money){
            System.out.println("You have just enough to buy but no money left!");
            player.animalList.addAll(animalChosen);;
        }
        else {
            player.animalList.addAll(animalChosen);
            System.out.println("You have " +player.money+"kr left after payment and the list updated");


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
    public void payAndUpdateList (Player player, ArrayList<Food> foodChosen,ArrayList<Integer> amountChosen){
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



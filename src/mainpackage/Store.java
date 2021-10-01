package mainpackage;


import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public Scanner console;


    public Store() {
        console = new Scanner(System.in);
    }

    public void buyAnimal(Player player) {
        ArrayList<Animal> animalChoices = new ArrayList<>();
        //player decide how many animals to buy first
        System.out.println("How many animal would you like to buy in total?");
        int total = console.nextInt();//total number of animal
        showAnimalMenu(); //Show 5 different choices of animal
        for (int i = 0; i <= total; i++) {
            int animal = console.nextInt(); //player choose animal
            System.out.println("Male(1) or female(2)?");// choose sex
            int sex = console.nextInt();
            System.out.println("Please decide the name for your animal");//Decide name
            String animalName = console.next();

            switch (animal) {//Store put animal chosen to its list for now
                case 1: //Dog
                    if (sex == 1) {//male
                        animalChoices.add(new Dog(animalName, "male"));
                    } else {//female
                        animalChoices.add(new Dog(animalName, "female"));
                    }
                    break;
                case 2: //Cat
                    if (sex == 1) {//male
                        animalChoices.add(new Cat(animalName, "male"));
                    } else {//female
                        animalChoices.add(new Cat(animalName, "female"));
                    }
                    break;
                case 3: //Unicorn
                    if (sex == 1) {//male
                        animalChoices.add(new Unicorn(animalName, "male"));
                    } else {//female
                        animalChoices.add(new Unicorn(animalName, "female"));
                    }
                    break;
                case 4: //Rabbit
                    if (sex == 1) {//male
                        animalChoices.add(new Rabbit(animalName, "male"));
                    } else {//female
                        animalChoices.add(new Rabbit(animalName, "female"));
                    }
                    break;
                case 5: //Bat
                    if (sex == 1) {//male
                        animalChoices.add(new Bat(animalName, "male"));
                    } else {//female
                        animalChoices.add(new Bat(animalName, "female"));
                    }
                    break;
            }
        }
        //check total price
        int currentMoney = player.money;
        for (int x = 0; x <= animalChoices.size(); x++) { //get each animal from the list and do payment
            int moneyleft = player.money - animalChoices.get(x).price;
            if (moneyleft == 0) {
                System.out.println("You can't buy more than you can afford! Try another time. ");// if money=0
                player.money = currentMoney; //payment reset and no animal will be sold
            } else {
                player.animalList.addAll(animalChoices);
                System.out.println("Now all animals are added to your list");
                System.out.println("You have " + player.money + "kr left.");
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
        //Show all animals in player's list
        System.out.println("Please choose which Animal you'd like to sell.");
        for (int i=0; i<player.animalList.size();i++){
            System.out.println(i+"."+player.animalList.get(i));
        }
        int indexChosen = console.nextInt();//player choose index for animal to sell
        Animal animalToSell= player.animalList.get(indexChosen);
        int currentHealth = animalToSell.healthLevel;
        int priceToSell=0;
        if (currentHealth == animalToSell.getOriginalHL()){
            priceToSell= animalToSell.price;
        }
        else if(currentHealth >= (animalToSell.getOriginalHL()/2)){ //Health Lv is more than 50%
            priceToSell=  animalToSell.price/2;
        }
        else if (currentHealth < (animalToSell.getOriginalHL()/2)){//Health Lv is less than 50%
            priceToSell= animalToSell.price/4;
        }
        System.out.println(animalToSell + " can be sold for "+ priceToSell+" kr.\n Would you still like to sell?\n 1.Yes 2.No");
        int lastChoice = console.nextInt();
        switch (lastChoice){
            case 1://Yes
                player.animalList.remove(animalToSell);
                player.money= player.money+priceToSell;
                System.out.println(animalToSell+" is sold now!");
                break;
            case 2://No
                System.out.println("OK, see you next time!");
        }
    }

    public void showAnimalMenu(){
        System.out.println("Please Choose the number for animal you'd like to buy");
        System.out.println("1.Dog 2. Cat  3. Unicorn 4. Rabbit 5. Bat ");
        System.out.println("The price for each Animal: 1.50kr 2.40kr 3.100kr 4.30kr 5.20kr");
    }

    public int showFoodMenu(){
        System.out.println("Please choose the number for Food you'd like to buy");
        System.out.println("1. Veggies 2. Meat 3. Milk");
        int foodChoice = console.nextInt();
        System.out.println("Which one you'd like to get?");
        return foodChoice;
    }


}
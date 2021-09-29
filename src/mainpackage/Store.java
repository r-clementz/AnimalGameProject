package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public Scanner console;
    public ArrayList<Animal> storeAnimalStock; // can be normal Array instead?
    private Food[] storeFoodStock;
    public Store gameStore;

    public Store(){
        console = new Scanner(System.in);
        storeAnimalStock = new ArrayList<>();
        storeFoodStock = new Food[6]; //can be more
        gameStore= new Store();
    }
    public void createStoreAnimalList() {
        //Dogs
        storeAnimalStock.add(new Dog("labrador", "male", 40));
        storeAnimalStock.add(new Dog("labrador", "male", 40));
        storeAnimalStock.add(new Dog("labrador", "male", 55));
        storeAnimalStock.add(new Dog("labrador", "male", 60));
        //Cats
        storeAnimalStock.add(new Cat("", "male", 60));
        storeAnimalStock.add(new Cat("labrador", "male", 60));
        storeAnimalStock.add(new Cat("labrador", "male", 45));
        storeAnimalStock.add(new Cat("labrador", "male", 45));
        //Unicorn
        storeAnimalStock.add(new Unicorn("labrador", "male", 100));
        storeAnimalStock.add(new Unicorn("labrador", "male", 100));
        storeAnimalStock.add(new Unicorn("labrador", "male", 100));
        storeAnimalStock.add(new Unicorn("labrador", "male", 100));
        //Rabbit
        storeAnimalStock.add(new Rabbit("labrador", "male", 30));
        storeAnimalStock.add(new Rabbit("labrador", "male", 30));
        storeAnimalStock.add(new Rabbit("labrador", "male", 25));
        storeAnimalStock.add(new Rabbit("labrador", "male", 25));
        //Bat
        storeAnimalStock.add(new Bat("labrador", "male", 20));
        storeAnimalStock.add(new Bat("labrador", "male", 20));
        storeAnimalStock.add(new Bat("labrador", "male", 15));
        storeAnimalStock.add(new Bat("labrador", "male", 15));
    }
    public Food[] getStoreFoodStock() {
        storeFoodStock[1] = new Veggies("Carrot", 3);
        storeFoodStock[2] = new Veggies("Cabbage", 5);
        storeFoodStock[3] = new Meat("Chicken", 8);
        storeFoodStock[4] = new Meat("Beef", 10);
        storeFoodStock[5] = new Milk("Cow milk", 3);
        storeFoodStock[6] = new Milk("Oat milk", 4);
        return storeFoodStock;
    }

    public void showAnimals() {
        System.out.println("Here are animals in the store:");
        for (int i = 1; i <= storeAnimalStock.size(); i++) {
            System.out.println(i + ". :\t" + storeAnimalStock.get(i));
        }
    }

    public void buyAnimal(Player player) {
        showAnimals();
        //pick up animal
        System.out.println("Please input which Animal you'd like to buy.");
        int numberPicked = console.nextInt();
        //payment
        player.money = player.money - (int)(storeAnimalStock.get(numberPicked).originalPrice);
        int healthLv = storeAnimalStock.get(numberPicked).getOriginalHL();
        //update players list and store stock
        player.animalList.add(storeAnimalStock.get(numberPicked));//added players List
        //see of which index the animal is in the list
        int i =player.animalList.indexOf(storeAnimalStock.get(numberPicked));
        storeAnimalStock.remove(numberPicked);//removed from store stock
        //update info
        player.animalList.get(i).healthMeter = healthLv;
        System.out.println("Now the animal is added. Please give a name to your animal");
        String givenName = console.next();
        player.animalList.get(i).name = givenName;

    }

    public void showFood() {
        for (int i = 0; i <= storeFoodStock.length; i++) {
            System.out.println("No." + i + " " + storeFoodStock[i]+ "\tprice: "+storeFoodStock[i].price);
        }
    }

    public void buyFood(Player player){
        showFood();
        //pick Food to buy
        System.out.println("Please input which Food you'd like to buy.");
        int indexPicked = console.nextInt();
        System.out.println("How much you'd like to buy? (kg)");
        int amountToBuy = console.nextInt();
        //see the price
        int totalPrice = storeFoodStock[indexPicked].price*amountToBuy;
        System.out.println("Total price will be:" + totalPrice );
        //payment
        player.money= player.money-totalPrice;
        //add food to List
        player.foodStock.add(storeFoodStock[indexPicked]);
        //add amount information
        int i =player.foodStock.indexOf(storeFoodStock[indexPicked]);
        player.foodStock.get(i).amount = amountToBuy;
        System.out.println("Food is added to your list.");
        //store's food list is limitless so no need to remove Food from Array
    }

    public void sellAnimal(Player player){
        //player can see all animal currently in own list
        player.seeAnimalList();
        //player chooses which animal to sell
        System.out.println("Please choose animal to sell");
        int choiceToSell = console.nextInt();
        Animal animalToSell =player.animalList.get(choiceToSell);
        //check helath Lv of animal going to be sold
        int currentHealth = animalToSell.healthLevel;
        double deal=0;
        //price depends on the health meter
        if (currentHealth == currentHealth) {//100% HL = 100% price
            deal= animalToSell.originalPrice;
            player.animalList.remove(animalToSell); //removed from players list
            storeAnimalStock.add(animalToSell);// added to store again
            player.money= player.money+(int)deal;// player get money
        }
        else if ((currentHealth<=currentHealth*90)&&(currentHealth>=currentHealth*60)) {
            //90-60% = 50% price
            deal= animalToSell.originalPrice/2;
            player.animalList.remove(animalToSell); //removed from players list
            storeAnimalStock.add(animalToSell);// added to store again
            player.money= player.money+(int)deal;// player get money
        }
        else if ((currentHealth<currentHealth*60)&&(currentHealth>=currentHealth*10)) {
            //less than 50% = 25% price
            deal= animalToSell.originalPrice/4;
            player.animalList.remove(animalToSell); //removed from players list
            storeAnimalStock.add(animalToSell);// added to store again
            player.money= player.money+(int)deal;// player get money
        }



    }


}

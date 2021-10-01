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
                System.out.println("Now you run out of all money!");// if money=0
                player.money = currentMoney; //payment reset and no animal will be sold
            } else {
                player.animalList.addAll(animalChoices);
                System.out.println("Now all animals are added to your list");
                System.out.println("You have " + player.money + "kr left.");

            }

        }

    }




    public void buyFood(){

    }
    public void sellAnimal(Player player) {
    }
    public void showAnimalMenu(){
        System.out.println("Please Choose the number for animal you'd like to buy");
        System.out.println("1.Dog 2. Cat  3. Unicorn 4. Rabbit 5. Bat ");
        System.out.println("The price for each Animal: 1.50kr 2.40kr 3.100kr 4.30kr 5.20kr");
    }

    public void showFoodMenu(){
        System.out.println("Please choose the number for Food you'd like to buy");
        System.out.println("1. Veggies 2. Meat 3. Milk");
        int foodChoice = console.nextInt();
        System.out.println("Please choose which ");
    }


}
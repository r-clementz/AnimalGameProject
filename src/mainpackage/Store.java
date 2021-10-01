package mainpackage;


import java.util.Scanner;

public class Store {
    public Scanner console;

    public Store() {
        console = new Scanner(System.in);
    }
    public void buyAnimal(Player player) {
        //Show 5 different choices of animal

        //player choose animal
        int animalChoice= console.nextInt();
        // Player choose sex for animal
        System.out.println("Male(1) or Female(2)? ");
        int sexChoice = console.nextInt();
        //Decide name
        System.out.println("Please decide the name for your animal");
        String animalName = console.next();

        switch(animalChoice) {
            case 1: //Dog
                if(sexChoice==1) {//male
                    player.animalList.add(new Dog (animalName,"male"))
                }
        }
    }


    public void buyFood() {

    }

    public void sellAnimal(Player player) {
    }
    public void showAnimalMenu(){
        System.out.println("Please Choose the number for animal you'd like to buy");
        System.out.println("1.Dog 2. Cat  3. Unicorn 4. Rabbit 5. Bat ");
        System.out.println("The price for each Animal: 1.50kr 2.40kr 3.100kr 4.30kr 5.20kr");
    }


}
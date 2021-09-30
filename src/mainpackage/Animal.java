package mainpackage;
//superclass Animal
public abstract class Animal {
    public String name;
    private String breed;
    private String sex;
    public double originalPrice;
    public int healthLevel;

    public Animal(String sex, int originalprice) {
        this.name = name;
        this.sex = sex;
        this.originalPrice = originalprice;
        this.healthLevel = healthLevel;
    }

    public int getOriginalHL() {
        return healthLevel;
    }

    public void eat(Food food) {}

    public void seeIfBecameFull() { // Health Lv can't be more than Original
        if (this.healthLevel <= this.getOriginalHL()) {
            this.healthLevel = getOriginalHL();
            System.out.println(this.name +": I got full! ");
        }
    }
    public void gainMoreEnergy (Food food, int amountOfFood) {}
    public void updateHealthStatus(Player player){
        for (int i=0; i<player.animalList.size();i++){
            player.animalList.get(i).healthLevel=  (int)(player.animalList.get(i).healthLevel*0.9);
            if(player.animalList.get(i).healthLevel==0){
                player.animalList.get(i).die(player);
            }
        }
    }

    public void die (Player player) {
        System.out.println(this + "is dead:( You can't reach" + this + " anymore");
        player.animalList.remove(this);
    }

        public void babyborn (Animal animal, Player player){
            int sexDecision = (int) (Math.random() * 1);
            switch (sexDecision) {
                case 0:
                    System.out.println("you got a baby boy!");
                    if (animal instanceof Dog) {
                        player.animalList.add(new Dog("male", 10));
                    } else if (animal instanceof Cat) {
                        player.animalList.add(new Cat("male", 10));
                    } else if (animal instanceof Unicorn) {
                        player.animalList.add(new Unicorn("male", 50));
                    } else if (animal instanceof Rabbit) {
                        player.animalList.add(new Rabbit("male", 10));
                    } else if (animal instanceof Bat) {
                        player.animalList.add(new Bat("male", 10));
                    }
                    break;

                case 1: {
                    System.out.println("you got a baby girl!");
                    if (animal instanceof Dog) {
                        player.animalList.add(new Dog("female", 10));
                    } else if (animal instanceof Cat) {
                        player.animalList.add(new Cat("female", 10));
                    } else if (animal instanceof Unicorn) {
                        player.animalList.add(new Unicorn("female", 50));
                    } else if (animal instanceof Rabbit) {
                        player.animalList.add(new Rabbit("female", 10));
                    } else if (animal instanceof Bat) {
                        player.animalList.add(new Bat("female", 10));
                    }
                    break;
                }

            }
        }

        public String getAnimalsSex () {
            return this.sex;
        }
    }

class Dog extends Animal{

    public Dog (String sex, int originalprice)  {
        super(sex,originalprice);
    }
    @Override
    public int getOriginalHL(){
        this.healthLevel = 200;
        return healthLevel;
    }
    @Override
    public void eat(Food food){ // Dog can eat veg/meat
        //if Health Lv is Max, animal won't eat
        if(getOriginalHL()==this.healthLevel){
            System.out.println("I'm full now");
        }
        else{ // Health Lv is not full
            if( food instanceof Milk) {
            System.out.println("I don't want eat that");
            }
            else if ((food instanceof Meat)||(food instanceof Veggies))
            {
                System.out.println("Yum yum");

            }
        }
    }
    @Override
    public void gainMoreEnergy(Food food, int amountOfFood){
        if (food instanceof Meat) {
            this.healthLevel= this.healthLevel+10*amountOfFood;
        }
        else {
            this.healthLevel= this.healthLevel+5*amountOfFood;
        }
    }
    public void updateHealthStatus(Player player){}
    public void die(Player player){}
}


class Cat extends Animal { // meat milk

    public Cat(String sex, int originalprice) {
        super(sex, originalprice);
    }

    @Override
    public int getOriginalHL(){
        this.healthLevel = 100;
        return healthLevel;
    }

    @Override
    public void eat(Food food) { //Cats eat meat/milk
        if (getOriginalHL() == this.healthLevel) {
            System.out.println("I'm full now");
        } else { // Health Lv is not full
            if (food instanceof Veggies) {
                System.out.println("I don't want eat that");
            } else if ((food instanceof Meat) || (food instanceof Milk)) {
                System.out.println("Yum yum");

            }
        }
    }

    @Override
    public void gainMoreEnergy(Food food, int amountOfFood){
        if (food instanceof Meat) {
            this.healthLevel= this.healthLevel+10*amountOfFood;
        }
        else {
            this.healthLevel= this.healthLevel+5*amountOfFood;
        }
    }


    public void updateHealthStatus(Player player){}
    public void die(Player player){}
}

class Unicorn extends Animal{  //all
    Unicorn(String sex, int originalprice)  {
        super(sex,originalprice);
    }
    @Override
    public int getOriginalHL(){
        this.healthLevel = 400;
        return healthLevel;
    }

    @Override
    public void eat(Food food){ //unicorn eats everything!
        System.out.println("I eat everything, yum yum");
    }


    @Override
    public void gainMoreEnergy(Food food, int amountOfFood){
        this.healthLevel= this.healthLevel+5*amountOfFood;
    }

    public void updateHealthStatus(Player player){}
    public void die(Player player){}
}

class Rabbit extends Animal{
    Rabbit(String sex, int originalprice)  {
        super(sex,originalprice);
    }
    @Override
    public int getOriginalHL(){
        this.healthLevel = 60;
        return healthLevel;
    }

    @Override
    public void eat(Food food){ //Rabbit eats only veggie
        if(getOriginalHL()==this.healthLevel){
            System.out.println("I'm full now");
        }
        else{ // Health Lv is not full
            if( food instanceof Veggies) {
                System.out.println("Yum yum");

            }
            else
            {
                System.out.println("I don't want eat that");
            }
        }
    }
    public void gainMoreEnergy(Food food, int amountOfFood){
        this.healthLevel= this.healthLevel+15*amountOfFood;
    }

    public void updateHealthStatus(Player player){}
    public void die(Player player){}
}

class Bat extends Animal{
    Bat(String sex, int originalprice)  {
        super(sex,originalprice);
    }
    @Override
    public int getOriginalHL(){
        this.healthLevel = 80;
        return healthLevel;
    }

    @Override
    public void eat(Food food){// Bat eats only milk
        if(getOriginalHL()==this.healthLevel){
            System.out.println("I'm full now");
        }
        else{ // Health Lv is not full
            if( food instanceof Milk) {
                System.out.println("Yum yum");
            }
            else
            {
                System.out.println("I don't want eat that");
            }
        }
    }
    public void gainMoreEnergy(Food food, int amountOfFood){
        this.healthLevel= this.healthLevel+15*amountOfFood;
    }
    public void updateHealthStatus(Player player){}
    public void die(Player player){}
}

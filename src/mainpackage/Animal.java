package mainpackage;
//superclass Animal
public class Animal {
    public String name;
    private String breed;
    private String sex;
    public double originalPrice;
    public int healthLevel;

    public Animal(String breed,String sex, int originalprice) {
        this.name=name;
        this.breed=breed;
        this.sex= sex;
        this.originalPrice =originalprice;
        this.healthLevel = healthLevel;
    }
    public void eat(){}
    public int getOriginalHL(){return healthLevel;}
    public void lowerEnergy(){}
    public void gainMoreEnergy(){}
    public void die(){}
    public void babyborn(Animal animal,Player player) {
        int sexDecision = (int) (Math.random() * 1);
        switch (sexDecision) {
            case 0:
                System.out.println("you got a baby boy!");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog("", "male", 0));
                } else if (animal instanceof Unicorn) {
                    player.animalList.add(new Unicorn("", "male", 0));
                } else if (animal instanceof Rabbit) {
                    player.animalList.add(new Rabbit("", "male", 0));
                } else if (animal instanceof Bat) {
                    player.animalList.add(new Bat("", "male", 0));
                }
                break;

            case 1: {
                System.out.println("you got a baby girl!");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog("", "female", 0));
                } else if (animal instanceof Unicorn) {
                    player.animalList.add(new Unicorn("", "female", 0));
                } else if (animal instanceof Rabbit) {
                    player.animalList.add(new Rabbit("", "female", 0));
                } else if (animal instanceof Bat) {
                    player.animalList.add(new Bat("", "female", 0));
                }
                break;
            }

        }
    }
    public String getAnimalsSex(){
        return this.sex;
    }

}
class Dog extends Animal{


    public Dog (String breed,String sex,int originalprice) {
        super(breed,sex,originalprice);

    }
    public void eat(){}
    @Override
    public int getOriginalHL(){
        this.healthLevel = 200;
        return healthLevel;
    }
    public void lowerEnergy(){}
    public void gainMoreEnergy(){}
    public void die(){}
}


class Cat  extends Animal{

    public Cat (String breed,String sex,int originalprice) {
        super(breed,sex,originalprice);
    }
    public void eat(){}
    @Override
    public int getOriginalHL(){
        this.healthLevel = 100;
        return healthLevel;}
    public void lowerEnergy(){}
    public void gainMoreEnergy(){}
    public void die(){}
}

class Unicorn extends Animal{
    Unicorn(String breed,String sex,int originalprice) {
        super(breed,sex,originalprice);
    }

    public void eat(){}
    @Override
    public int getOriginalHL(){
        this.healthLevel = 400;
        return healthLevel;
    }
    public void lowerEnergy(){}
    public void gainMoreEnergy(){}
    public void die(){}
}
class Rabbit extends Animal{
    Rabbit (String breed,String sex,int originalprice) {
        super(breed,sex,originalprice);
    }

    public void eat(){}
    @Override
    public int getOriginalHL(){
        this.healthLevel = 60;
        return healthLevel;
    }
    public void lowerEnergy(){}
    public void gainMoreEnergy(){}
    public void die(){}
}
class Bat extends Animal{
    Bat(String breed,String sex,int originalprice) {
        super(breed,sex,originalprice);
    }

    public void eat(){}
    @Override
    public int getOriginalHL(){
        this.healthLevel = 80;
        return healthLevel;
    }
    public void lowerEnergy(){}
    public void gainMoreEnergy(){}
    public void die(){}
}
}
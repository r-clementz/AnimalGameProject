package mainpackage;
//superclass Animal
public class Animal {
   // private String name;
    private String sex;
    public int healthLevel;
    //Should we have name here as null and player give a name later?
    public Animal(String sex){
        this.sex=sex;
        this.healthLevel = healthLevel;


    }

    public void eat(){}
    public void die(){}

}
//5 sub animal  classes
class Dog extends Animal{

    public Dog(String sex) {
        super(sex);
    }

    public void eat(){}
    public void die(){}


}
class Cat extends Animal{
    public Cat(String sex) {
        super(sex);
    }

    public void eat(){}
    public void die(){}

}
class Unicorn extends Animal{
    public Unicorn (String sex) {
        super(sex);
    }

    public void eat(){}
    public void die(){}

}
class Rabbit extends Animal{
    public Rabbit(String sex) {
        super(sex);
    }

    public void eat(){}
    public void die(){}

}
class Bat extends Animal{
    public Bat(String sex) {
        super(sex);
    }

    public void eat(){}
    public void die(){}

}
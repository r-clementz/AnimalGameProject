package mainpackage;
//superclass Animal
public class Animal {
   // private String name;
    private String sex;
    public int healthLevel;
    public Animal(){}

    public void eat(){}
    public void die(){}

}
//5 sub animal  classes
class Dog extends Animal{

    public void eat(){}
    public void die(){}


}
class Cat extends Animal{}
class Unicorn extends Animal{}
class Rabbit extends Animal{}
class Bat extends Animal{}
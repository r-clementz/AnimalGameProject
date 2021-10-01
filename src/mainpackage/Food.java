package mainpackage;

public class Food {
    public String name;
    public int amount;

    public Food (String name,int amount){
        this.name=name;
        this.amount=amount;

    }

}
class Veggies extends Food{

    public Veggies(String name,int amount) {
        super(name,amount);
    }

}
class Meat extends Food{

    public Meat(String name,int amount) {
        super(name,amount);
    }
}
class Milk extends Food {

    public Milk(String name,int amount) {
        super(name,amount);
    }
}

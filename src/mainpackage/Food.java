package mainpackage;

public class Food {
    public String name;
    public int price;
    public int amount;

    public Food (String name,int price){
        this.name=name;
        this.price=price;
        this.amount=amount;

    }

}
class Veggies extends Food{

    public Veggies(String name,int price) {
        super(name,price);
    }

}
class Meat extends Food{

    public Meat(String name,int price) {
        super(name,price);
    }
}
class Milk extends Food {

    public Milk(String name,int price) {
        super(name,price);
    }
}

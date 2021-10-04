package com.animalgame.animals;


import com.animalgame.Animal;
import com.animalgame.Food;

public class Unicorn extends Animal {  //all
    int price;
    public Unicorn(String name, String sex) {
        super(name, sex);
        super.price=150;
    }

    @Override
    public int getOriginalHL() {
        this.healthLevel = 400;
        return healthLevel;
    }

    @Override
    public void eat(Food food) { //unicorn eats everything!
        System.out.println("I eat everything, yum yum");
    }


    @Override
    public void gainMoreEnergy(Food food, int amountOfFood) {
        this.healthLevel = this.healthLevel + 5 * amountOfFood;
        seeIfBecameFull();
    }//Unicorn can eat everything but no favourite food
     //and difficult to make it full


}
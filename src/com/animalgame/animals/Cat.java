package com.animalgame.animals;


import com.animalgame.*;
import com.animalgame.food.*;

public class Cat extends Animal { // meat milk
    public int price;

    public Cat(String name, String sex) {
        super(name, sex);
        price=40;
    }

    @Override
    public int getOriginalHL() {
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
    public void gainMoreEnergy(Food food, int amountOfFood) {
        if (food instanceof Meat) {
            this.healthLevel = this.healthLevel + 10 * amountOfFood;
        } else {
            this.healthLevel = this.healthLevel + 5 * amountOfFood;
        }
    }


}

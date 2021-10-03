package com.animalgame.animals;

import com.animalgame.*;
import com.animalgame.food.*;


public class Rabbit extends Animal {
    int price;
    public Rabbit(String name, String sex) {
        super(name, sex);
        price=30;
    }

    @Override
    public int getOriginalHL() {
        this.healthLevel = 60;
        return healthLevel;
    }

    @Override
    public void eat(Food food) { //Rabbit eats only veggie
        if (getOriginalHL() == this.healthLevel) {
            System.out.println("I'm full now");
        } else { // Health Lv is not full
            if (food instanceof Veggies) {
                System.out.println("Yum yum");

            } else {
                System.out.println("I don't want eat that");
            }
        }
    }


    public void gainMoreEnergy(Food food, int amountOfFood) {
        this.healthLevel = this.healthLevel + 15 * amountOfFood;
        seeIfBecameFull();
    }


}

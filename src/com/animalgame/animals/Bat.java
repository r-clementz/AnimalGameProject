package com.animalgame.animals;

import com.animalgame.*;
import com.animalgame.food.*;

public class Bat extends Animal {

    public Bat(String name, String sex) {
        super(name, sex);
        super.price=20;
        super.healthLevel=80;
    }

    @Override
    public int getOriginalHL() {
        this.healthLevel = 80;
        return healthLevel;
    }

    @Override
    public void eat(Food food) {// Bat eats only milk
        if (getOriginalHL() == this.healthLevel) {
            System.out.println("I'm full now");
        } else { // Health Lv is not full
            if (food instanceof Milk) {
                System.out.println("Yum yum");
            } else {
                System.out.println("I don't want eat that");
            }
        }
    }

    public void gainMoreEnergy(Food food, int amountOfFood) {
        if(food.name.equals("Cow milk")){
            this.healthLevel = this.healthLevel + 15 * amountOfFood;
        }
        else{
            this.healthLevel = this.healthLevel + 10 * amountOfFood;
        }
        seeIfBecameFull();
    }

}

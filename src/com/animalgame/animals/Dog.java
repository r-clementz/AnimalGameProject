package com.animalgame.animals;

import com.animalgame.*;
import com.animalgame.food.*;

public class Dog extends Animal {


    public Dog(String name, String sex) {
        super(name, sex);
        super.price=50;
        super.healthLevel=200;
    }

    @Override
    public int getOriginalHL() {
        this.healthLevel = 200;
        return healthLevel;
    }

    @Override
    public void eat(Food food) { // Dog can eat veg/meat
        //if Health Lv is Max, animal won't eat
        if (getOriginalHL() == this.healthLevel) {
            System.out.println("I'm full now");
        } else { // Health Lv is not full
            if (food instanceof Milk) {
                System.out.println("I don't want eat that");
            } else if ((food instanceof Meat) || (food instanceof Veggies)) {
                System.out.println("Yum yum");

            }
        }
    }

    @Override
    public void gainMoreEnergy(Food food, int amountOfFood) {
        if (food instanceof Meat) {
            if(food.name.equals("Beef")){
                this.healthLevel = this.healthLevel + 15 * amountOfFood;}
            else{this.healthLevel = this.healthLevel + 10 * amountOfFood;}
        } else {
            this.healthLevel = this.healthLevel + 5 * amountOfFood;
        }
        seeIfBecameFull();
    }


}




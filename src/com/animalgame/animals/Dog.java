package com.animalgame.animals;

import com.animalgame.*;
import com.animalgame.abstractclass.Animal;
import com.animalgame.abstractclass.Food;
import com.animalgame.food.*;

public class Dog extends Animal {


    public Dog(String name, String sex) {
        super(name, sex);
        super.price=50;
        super.healthLevel=200;


    }

    @Override
    public int getOriginalHL() {
        int originalHL =200;
        return originalHL;

    }
    @Override
    public String getSpecies(){
        String species ="Dog";
        return species;
    }

    @Override
    public void eat(Food food, Player player, int indexChosen, int amountOfFood) { // Dog can eat veg/meat

        if (food instanceof Milk) {
            System.out.println("I don't want eat that");
        } else if ((food instanceof Meat) || (food instanceof Veggies)) {
            System.out.println("Yum yum");
            gainMoreEnergy(food,player,indexChosen,amountOfFood);

        }

    }


    @Override
    public void gainMoreEnergy(Food food, Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).healthLevel;
        if (food instanceof Meat) {
            if (food.name.equals("Beef")) {
                player.animalList.get(indexChosen).healthLevel = healthLv + 15 * amountOfFood;
                ;
            } else {
                player.animalList.get(indexChosen).healthLevel = healthLv + 10 * amountOfFood;
            }
        } else {
            player.animalList.get(indexChosen).healthLevel = healthLv + 5 * amountOfFood;
        }
        seeIfBecameFull(player, indexChosen);
    }


}



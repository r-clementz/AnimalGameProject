package com.animalgame.animals;

import com.animalgame.*;
import com.animalgame.food.*;


public class Rabbit extends Animal {
    public Rabbit(String name, String sex) {
        super(name, sex);
        super.price=30;
        super.healthLevel=60;
    }


    @Override
    public int getOriginalHL() {
        int originalHL =60;
        return originalHL;
    }

    @Override
    public void eat(Food food, Player player, int indexChosen,int amountOfFood) { //Rabbit eats only veggie
        if (food instanceof Veggies) {
            System.out.println("Yum yum");
            gainMoreEnergy(food,player,indexChosen,amountOfFood);


        } else {
            System.out.println("I don't want eat that");
        }
    }


    @Override
    public void gainMoreEnergy(Food food,Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).healthLevel;
        if (food.name.equals("Carrot")) {
            player.animalList.get(indexChosen).healthLevel = healthLv + 15 * amountOfFood;
        } else if (food.equals("Cabbage")) {
            player.animalList.get(indexChosen).healthLevel= healthLv + 10 * amountOfFood;
        } else {
            player.animalList.get(indexChosen).healthLevel = healthLv + 5 * amountOfFood;
        }
        seeIfBecameFull(player, indexChosen);
    }
}


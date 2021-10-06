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
        int originalHL =80;
        return originalHL;
    }

    @Override
    public void eat(Food food, Player player, int indexChosen, int amountOfFood) { //Bats take only milk

        if (food instanceof Milk) {
            System.out.println("Yum yum");
            gainMoreEnergy(food,player,indexChosen,amountOfFood);
        } else {
            System.out.println("I don't want eat that");
        }
    }

    @Override
    public void gainMoreEnergy(Food food,Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).healthLevel;
        if(food.name.equals("Cow milk")){
            player.animalList.get(indexChosen).healthLevel =  healthLv + 15 * amountOfFood;
        }
        else{
            player.animalList.get(indexChosen).healthLevel =  healthLv + 10 * amountOfFood;
        }
        seeIfBecameFull(player, indexChosen);
    }


}


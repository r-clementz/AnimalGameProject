package com.animalgame.animals;


import com.animalgame.*;
import com.animalgame.abstractclass.Animal;
import com.animalgame.abstractclass.Food;
import com.animalgame.food.*;

public class Cat extends Animal { // meat milk



    public Cat(String name, String sex) {
        super(name, sex);
        super.price=40;
        super.healthLevel=100;

    }

    @Override
    public int getOriginalHL() {
        int originalHL =100;
        return originalHL;
    }
    @Override
    public String getSpecies(){
        String species ="Cat";
        return species;
    }

    @Override
    public void eat(Food food, Player player, int indexChosen, int amountOfFood) { //Cats eat meat/milk
        if (food instanceof Veggies) {
            System.out.println("I don't want eat that");
        } else if ((food instanceof Meat) || (food instanceof Milk)) {
            System.out.println("Yum yum");
            gainMoreEnergy(food,player,indexChosen,amountOfFood);
        }

    }


    @Override
    public void gainMoreEnergy(Food food, Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).healthLevel;
        if (food instanceof Meat) {
            if (food.name.equals("Chicken")) {
                player.animalList.get(indexChosen).healthLevel = healthLv + 20 * amountOfFood;
            } else {
                player.animalList.get(indexChosen).healthLevel = healthLv + 10 * amountOfFood;
            }
        } else {
            player.animalList.get(indexChosen).healthLevel= healthLv + 5 * amountOfFood;
        }
        seeIfBecameFull(player, indexChosen);
    }


}



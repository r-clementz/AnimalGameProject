package com.animalgame.animals;


import com.animalgame.Animal;
import com.animalgame.Food;
import com.animalgame.Player;

public class Unicorn extends Animal {  //all

    public Unicorn(String name, String sex) {
        super(name, sex);
        super.price=150;
        super.healthLevel=400;
    }

    @Override
    public int getOriginalHL() {
        int originalHL =400;
        return originalHL;
    }

    @Override
    public void eat(Food food, Player player, int indexChosen, int amountOfFood) { //Unicorns eat all

        System.out.println("I eat everything, yum yum");
        gainMoreEnergy(food,player,indexChosen,amountOfFood);
    }



    @Override
    public void gainMoreEnergy(Food food,Player player, int indexChosen, int amountOfFood) {
        int healthLv = player.animalList.get(indexChosen).healthLevel;
        if (food.name.equals("Oats Milk")){
            player.animalList.get(indexChosen).healthLevel = healthLv + 20 * amountOfFood;
        }
        else{
            player.animalList.get(indexChosen).healthLevel = healthLv + 5 * amountOfFood;}
        seeIfBecameFull(player, indexChosen);
    }


}
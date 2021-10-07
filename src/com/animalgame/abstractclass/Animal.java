package com.animalgame.abstractclass;

import com.animalgame.Player;
import com.animalgame.animals.*;

//superclass Animal
public abstract class Animal {
    public String name;
    private String sex;
    public int healthLevel;
    public int price;


    public Animal(String name, String sex) {
        this.name = name;
        this.sex = sex;
        this.healthLevel = healthLevel;
        this.price=price;

    }

    public abstract String getSpecies();
    public abstract int  getOriginalHL();
    public abstract String getSpecies();
    public abstract void eat(Food food, Player player, int indexChosen, int amountOfFood);
    public abstract void gainMoreEnergy(Food food,Player player, int indexChosen, int amountOfFood);
    public void seeIfBecameFull(Player player,int indexChosen){// if
        int currentHealth= player.animalList.get(indexChosen).healthLevel;
        if(currentHealth>=this.getOriginalHL()){
            currentHealth=this.getOriginalHL();
        }
    }

    public void die(Player player) {
        System.out.println(this + "is dead:( You can't reach" + this + " anymore");
        player.animalList.remove(this);
    }

    public void babyborn(Animal animal, Player player, String babyName) {//TESTED!
        int sexDecision = (int) (Math.random() * 2)+1;
        switch (sexDecision) {
            case 1:
                System.out.println("you got a baby boy!");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog(babyName,"male"));
                } else if (animal instanceof Cat) {
                    player.animalList.add(new Cat(babyName,"male"));
                } else if (animal instanceof Unicorn) {
                    player.animalList.add(new Unicorn(babyName,"male"));
                } else if (animal instanceof Rabbit) {
                    player.animalList.add(new Rabbit(babyName,"male"));
                } else if (animal instanceof Bat) {
                    player.animalList.add(new Bat(babyName,"male"));
                }
                break;

            case 2: {
                System.out.println("you got a baby girl!");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog(babyName,"female"));
                } else if (animal instanceof Cat) {
                    player.animalList.add(new Cat(babyName,"female"));
                } else if (animal instanceof Unicorn) {
                    player.animalList.add(new Unicorn(babyName,"female"));
                } else if (animal instanceof Rabbit) {
                    player.animalList.add(new Rabbit(babyName,"female"));
                } else if (animal instanceof Bat) {
                    player.animalList.add(new Bat(babyName,"female"));
                }
                break;
            }

        }
    }

    public String getAnimalsSex() {
        return this.sex;
    }
}


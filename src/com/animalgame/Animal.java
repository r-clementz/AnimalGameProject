package com.animalgame;

import com.animalgame.animals.Dog;
import com.animalgame.animals.Cat;
import com.animalgame.animals.Unicorn;
import com.animalgame.animals.Rabbit;
import com.animalgame.animals.Bat;

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


    public abstract int  getOriginalHL();
    public abstract void eat(Food food);
    public abstract void gainMoreEnergy(Food food, int amountOfFood);

    public void seeIfBecameFull(){// if
        int currentHealth= this.healthLevel;
        if(currentHealth>this.getOriginalHL()){
            this.healthLevel=this.getOriginalHL();
        }
    }



    public void updateHealthStatus(Player player) {
        for (int i = 0; i < player.animalList.size(); i++) {
            player.animalList.get(i).healthLevel = (int) (player.animalList.get(i).healthLevel * 0.9);
            if (player.animalList.get(i).healthLevel == 0) {
                player.animalList.get(i).die(player);
            }
        }
    }

    public void die(Player player) {
        System.out.println(this + "is dead:( You can't reach" + this + " anymore");
        player.animalList.remove(this);
    }

    public void babyborn(Animal animal, Player player) {
        int sexDecision = (int) (Math.random() * 1);
        switch (sexDecision) {
            case 0:
                System.out.println("you got a baby boy!");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog("","male"));
                } else if (animal instanceof Cat) {
                    player.animalList.add(new Cat("","male"));
                } else if (animal instanceof Unicorn) {
                    player.animalList.add(new Unicorn("","male"));
                } else if (animal instanceof Rabbit) {
                    player.animalList.add(new Rabbit("","male"));
                } else if (animal instanceof Bat) {
                    player.animalList.add(new Bat("","male"));
                }
                break;

            case 1: {
                System.out.println("you got a baby girl!");
                if (animal instanceof Dog) {
                    player.animalList.add(new Dog("","female"));
                } else if (animal instanceof Cat) {
                    player.animalList.add(new Cat("","female"));
                } else if (animal instanceof Unicorn) {
                    player.animalList.add(new Unicorn("","female"));
                } else if (animal instanceof Rabbit) {
                    player.animalList.add(new Rabbit("","female"));
                } else if (animal instanceof Bat) {
                    player.animalList.add(new Bat("","female"));
                }
                break;
            }

        }
    }

    public String getAnimalsSex() {
        return this.sex;
    }
}


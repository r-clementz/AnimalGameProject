package mainpackage;

//superclass Animal
public abstract class Animal {
    public String name;
    private String sex;
    public int healthLevel;

    public Animal(String name, String sex) {
        this.name = name;
        this.sex = sex;
        this.healthLevel = healthLevel;
    }


    public abstract int  getOriginalHL();
    public abstract void eat(Food food);
    public abstract void gainMoreEnergy(Food food, int amountOfFood);


    // Completely overridden in subclasses, this method is never reached for Animal Class
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

class Dog extends Animal {

    public Dog(String name, String sex) {
        super(name, sex);
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
            this.healthLevel = this.healthLevel + 10 * amountOfFood;
        } else {
            this.healthLevel = this.healthLevel + 5 * amountOfFood;
        }
    }


}

class Cat extends Animal { // meat milk

    public Cat(String name, String sex) {
        super(name, sex);
    }

    @Override
    public int getOriginalHL() {
        this.healthLevel = 100;
        return healthLevel;
    }

    @Override
    public void eat(Food food) { //Cats eat meat/milk
        if (getOriginalHL() == this.healthLevel) {
            System.out.println("I'm full now");
        } else { // Health Lv is not full
            if (food instanceof Veggies) {
                System.out.println("I don't want eat that");
            } else if ((food instanceof Meat) || (food instanceof Milk)) {
                System.out.println("Yum yum");

            }
        }
    }

    @Override
    public void gainMoreEnergy(Food food, int amountOfFood) {
        if (food instanceof Meat) {
            this.healthLevel = this.healthLevel + 10 * amountOfFood;
        } else {
            this.healthLevel = this.healthLevel + 5 * amountOfFood;
        }
    }


}


class Unicorn extends Animal {  //all
    public Unicorn(String name, String sex) {
        super(name, sex);
    }

    @Override
    public int getOriginalHL() {
        this.healthLevel = 400;
        return healthLevel;
    }

    @Override
    public void eat(Food food) { //unicorn eats everything!
        System.out.println("I eat everything, yum yum");
    }


    @Override
    public void gainMoreEnergy(Food food, int amountOfFood) {
        this.healthLevel = this.healthLevel + 5 * amountOfFood;
    }


}

class Rabbit extends Animal {
    public Rabbit(String name, String sex) {
        super(name, sex);
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
    }


}

class Bat extends Animal {
    public Bat(String name, String sex) {
        super(name, sex);
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
        this.healthLevel = this.healthLevel + 15 * amountOfFood;
    }


}

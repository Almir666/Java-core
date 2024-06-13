package DesignPatterns.Bridge;

public class Bridge {
    public static void main(String[] args) {
        Animal lion = new LandAnimal(new Lion());
        lion.move();

        Animal shark = new Fish(new Shark());
        shark.move();
    }

}

abstract class Animal {
    Model model;
    public Animal(Model model) {
        this.model = model;
    }

    abstract void move();
}

class LandAnimal extends Animal {
    public LandAnimal(Model model) {
        super(model);
    }

    @Override
    void move() {
        model.move("Run");
    }
}

class Bird extends Animal {
    public Bird(Model model) {
        super(model);
    }

    @Override
    void move() {
        model.move("Flght");
    }
}

class Fish extends Animal {
    public Fish(Model model) {
        super(model);
    }

    @Override
    void move() {
        model.move("Swim");
    }
}


class Lion implements Model {
    @Override
    public void move(String str) {
        
        System.out.println("Lion " + str);
    }
    
}

class Shark implements Model {
    @Override
    public void move(String str) {
        
        System.out.println("Shark " + str);
    }
    
}

interface Model {

    void move(String str);
}

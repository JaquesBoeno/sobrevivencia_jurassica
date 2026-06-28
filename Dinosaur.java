package TrabalhoPOO;

import java.util.Random;

public abstract class Dinosaur extends Entity {
    protected int dano;
    protected int ataca() {
        return dano;
    }

    public void move(){
        Random random = new Random();
        this.setDirection( random.nextInt(0, 4));
        super.move();
    }

    // abstract void recebeAtaque();
}
package TrabalhoPOO;

import java.util.Random;
import java.util.Vector;

public abstract class Dinosaur extends Entity {
    protected int dano;
    protected Vector<Dinosaur> dinosaurs;

    public Dinosaur(){
        super();
    }
    public Dinosaur(Vector<Dinosaur> dinosaurs){
        super(); this.dinosaurs = dinosaurs;}
    public Dinosaur(Map map, Vector<Dinosaur> dinosaurs){
        super();
        Random random = new Random();
        this.map = map;

        Cord c = new Cord(0, 0);
        do {
            c.setPosX(random.nextInt(0, 20));
            c.setPosY(random.nextInt(0, 20));
        } while (!map.isValid(c) || (c.getPosX() == map.getSize() - 1 && c.getPosY() == map.getSize() - 1) || (c.getPosX() == 0 && c.getPosY() == 0));

        Cell p = new Cell();
        p.setEntity(this);
        this.position = c;
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
        this.dinosaurs = dinosaurs;
    }
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
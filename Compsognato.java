package TrabalhoPOO;

import java.util.Random;
import java.util.Vector;

public class Compsognato extends Dinosaur {
    public Compsognato(Map map, Vector<Dinosaur> dinosaurs){
        super(map, dinosaurs);
        this.health=1;
    }

    public Compsognato(int posX, int posY, Map map, Vector<Dinosaur> dinosaurs){
        super(dinosaurs);
        this.map = map;
        Cell p = map.getCellAt(posX, posY);
        p.setEntity(this);
        this.position = new Cord(posX, posY);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
        this.health=1;
    }

    public void move(){
        super.move();
    }

    protected int ataca(){
        return super.ataca();
    }

    public String render(){
        return TextColor.color("C", TextColor.Color.RED);
    }
    public EntityType getEntityType() {
        return EntityType.COMPSOGNATO;
    }
}
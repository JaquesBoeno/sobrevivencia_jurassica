package TrabalhoPOO;

import java.util.Vector;

public class Tiranossauro extends Dinosaur{

    public Tiranossauro(Map map, Vector<Dinosaur> dinosaurs) {
        super (dinosaurs);
        this.map = map;
        Cell p = new Cell();
        p.setEntity(this);
        this.position = new Cord(map.getSize()-1, map.getSize()-1);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
        this.health = 3;
    }

    public void move(){

    }

    protected int ataca(){
        return super.ataca();
    }

    public String render(){
        return TextColor.color("R", TextColor.Color.RED);

    }
    public EntityType getEntityType() {
        return EntityType.TIRANOSSAURO;
    }
}

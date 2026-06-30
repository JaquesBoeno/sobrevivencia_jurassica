package TrabalhoPOO;

import java.util.Random;
import java.util.Vector;

public class Troodonte extends Dinosaur{

    public Troodonte(Map map , Vector<Dinosaur> dinosaurs){
        super(map, dinosaurs);
        this.health=2;
    }

    public void move(){
        super.move();
    }

    protected int ataca(){
        return super.ataca();
    }

    public String render(){
        return TextColor.color("T", TextColor.Color.RED);
    }
    public EntityType getEntityType() {
        return EntityType.TROODONTE;
    }
}

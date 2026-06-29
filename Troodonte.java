package TrabalhoPOO;

import java.util.Random;

public class Troodonte extends Dinosaur{

    public Troodonte(Map map){
        Random random = new Random();
        this.map = map;

        int x = 0;
        int y = 0;

        do {
            x = random.nextInt(0, map.getSize());
            y = random.nextInt(0, map.getSize());
        } while (!map.isValid(x, y) || (x == map.getSize() - 1 && y == map.getSize() - 1) || (x == 0 && y == 0));

        Cell p = new Cell();
        p.setEntity(this);
        this.position = new Cord(x, y);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
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
}

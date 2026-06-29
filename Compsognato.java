package TrabalhoPOO;

import java.util.Random;

public class Compsognato extends Dinosaur {
    public Compsognato(Map map){
        Random random = new Random();
        this.map = map;

        int x = 0;
        int y = 0;

        do {
            x = random.nextInt(0, map.getSize());
            y = random.nextInt(0, map.getSize());
        } while (!map.isValid(x, y) || (x == map.getSize() - 1 && y == map.getSize() - 1) || (x == 0 && y == 0));

        Cell p = map.getCellAt(x, y);
        p.setEntity(this);
        this.position = new Cord(x, y);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
    }

    public Compsognato(int posX, int posY, Map map){
        this.map = map;

        Cell p = map.getCellAt(posX, posY);
        p.setEntity(this);
        this.position = new Cord(posX, posY);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
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
}
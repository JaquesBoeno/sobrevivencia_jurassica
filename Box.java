package TrabalhoPOO;

import java.util.Random;
import java.util.Vector;

public class Box {
    private int type;
    private static int[] available = new int[]{1, 2, 1, 1};
    private Cord position;
    private Map map;
    private Vector<Dinosaur> dinos;

    public Box(Map map, Vector<Dinosaur> dinos) {
        this.map = map;
        this.dinos = dinos;
        Random random = new Random();
        do {
            type = random.nextInt(0, 4);
        } while (available[type] == 0);
        available[type]--;

        Cord c = new Cord(0, 0);
        do {
            c.setPosX(random.nextInt(0, 20));
            c.setPosY(random.nextInt(0, 20));
        } while (!map.isValid(c) || (c.getPosX() == map.getSize() - 1 && c.getPosY() == map.getSize() - 1) || (c.getPosX() == 0 && c.getPosY() == 0));

        Cell p = new Cell();
        p.setBox(this);
        this.position = c;
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
    }

    public String render(){
        return TextColor.color("X", TextColor.Color.YELLOW);
    }

    public Dinosaur putItem(Inventory i) {
        if (type < 3) {
            i.receiveItem(type);

            Cell c = map.getCellAt(position.getPosX(), position.getPosY());
            c.setBox(null);
            map.setCellAt(position.getPosX(), position.getPosY(), c);

            return null;
        } else {
            Dinosaur comp = new Compsognato(position.getPosX(), position.getPosY(), map, this.dinos);
            dinos.add(comp);

            Cell c = map.getCellAt(position.getPosX(), position.getPosY());
            c.setBox(null);
            map.setCellAt(position.getPosX(), position.getPosY(), c);

            return comp;
        }
    }

    public int getType(){ return type; }
    public boolean hasCompsognato(){
        return type == 3;
    }
}

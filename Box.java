package TrabalhoPOO;

import java.util.Random;

public class Box {
    private int type;
    private static int[] available = new int[]{1, 2, 1, 1};
    private Cord position;
    private Map map;
    private Dinosaur[] dinos;

    public Box(Map map, Dinosaur[] dinos) {
        this.map = map;
        this.dinos = dinos;
        Random random = new Random();
        do {
            type = random.nextInt(0, 4);
        } while (available[type] == 0);
        available[type]--;

        int x;
        int y;

        do {
            x = random.nextInt(0, 20);
            y = random.nextInt(0, 20);
        } while (!map.isValid(x, y) || (x == map.getSize() - 1 && y == map.getSize() - 1) || (x == 0 && y == 0));

        Cell p = new Cell();
        p.setBox(this);
        this.position = new Cord(x, y);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
    }

    public char render(){
        return 'X';
    }

    public void putItem(Inventory i){
        if(type < 3) {
            i.receiveItem(type);
        } else{
            dinos[dinos.length - 1] = new Compsognato(position.getPosX(), position.getPosY(), map);
        }

        Cell c = map.getCellAt(position.getPosX(), position.getPosY());
        c.setBox(null);
    }

    public int getType(){ return type; }
}

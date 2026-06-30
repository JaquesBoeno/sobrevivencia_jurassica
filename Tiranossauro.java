package TrabalhoPOO;

public class Tiranossauro extends Dinosaur{

    public Tiranossauro(Map map, int index, Dinosaur[] dinos) {
        this.map = map;
        Cell p = new Cell();
        p.setEntity(this);
        this.position = new Cord(map.getSize()-1, map.getSize()-1);
        map.setCellAt(this.position.getPosX(), this.position.getPosY(), p);
        this.health = 3;
        this.index = index;
        this.dinos = dinos;
    }

    public void move(){

    }

    protected int ataca(){
        return super.ataca();
    }

    public String render(){
        return TextColor.color("R", TextColor.Color.RED);

    }
}

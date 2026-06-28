package TrabalhoPOO;

public class Player extends Entity {
    private int percepcao;

    public Player(Map map){
        this.map = map;
        Cell p = new Cell();
        p.setEntity(this);
        map.setCellAt(0, 0, p);
        this.position = new Cord(0, 0);
    }

    public char render(){
        return 'P';
    }
}

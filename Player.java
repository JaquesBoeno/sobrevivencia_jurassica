package TrabalhoPOO;

public class Player extends Entity {
    private int percepcao;
    private Inventory inventory;

    public Player(Map map){
        this.map = map;
        Cell p = new Cell();
        p.setEntity(this);
        map.setCellAt(0, 0, p);
        this.position = new Cord(0, 0);
        this.health = 5;
        this.inventory = new Inventory();
    }

    public char render(){
        return 'P';
    }
    public String renderInventory(){
        return this.inventory.renderInventory();
    }
}

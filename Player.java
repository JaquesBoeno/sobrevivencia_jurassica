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

    public String render(){
        return TextColor.color("P", TextColor.Color.BLUE);
    }
    public String renderInventory(){
        return this.inventory.renderInventory();
    }

    public void move(){
        super.move();

        Box b = map.getCellAt(position.getPosX(), position.getPosY()).getBox();

        if(b != null){
            b.putItem(inventory);
        }

        Cell c = map.getCellAt(position.getPosX(), position.getPosY());
        c.setBox(null);
        map.setCellAt(position.getPosX(), position.getPosY(), c);
    }
    public Cord getPos(){
        return this.position;
    }
}

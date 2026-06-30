package TrabalhoPOO;

public class Player extends Entity {
    private int percepcao;
    private Inventory inventory;

    public Player(Map map){
        super();
        this.map = map;
        Cell p = new Cell();
        p.setEntity(this);
        map.setCellAt(0, 0, p);
        this.position = new Cord(0, 0);
        this.health = 5;
        this.maxHealth = 5;
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
        boolean haveCompsognato = false;
        Cell c =map.getCellAt(nextPos.getPosX(), nextPos.getPosY());
        Box b = c.getBox();

        if(b != null){
            haveCompsognato = b.hasCompsognato();
            b.putItem(inventory);
        }
        if (haveCompsognato){
            startFight(c.getEntity());
        }

        c.setBox(null);
        map.setCellAt(position.getPosX(), position.getPosY(), c);
    }
    public Cord getPos(){
        return this.position;
    }

    public EntityType getEntityType() {
        return EntityType.PLAYER;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getPercepcao() {
        return percepcao;
    }
}

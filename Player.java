package TrabalhoPOO;

public class Player extends Entity {
    private int percepcao = 2;
    private Inventory inventory;

    public Player(Map map, Dinosaur[] dinos){
        this.map = map;
        Cell p = new Cell();
        p.setEntity(this);
        map.setCellAt(0, 0, p);
        this.position = new Cord(0, 0);
        this.health = 5;
        this.inventory = new Inventory();
        this.dinos = dinos;
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
            b.putItem(this.inventory);
        }

        Cell c = map.getCellAt(position.getPosX(), position.getPosY());
        c.setBox(null);
        map.setCellAt(position.getPosX(), position.getPosY(), c);


        if(!map.isWall(nextPos.getPosX(), nextPos.getPosY())){
            c = map.getCellAt(nextPos.getPosX(), nextPos.getPosY());
            if(c.getEntity() != null && c.getEntity().getClass() != Player.class) {
                Entity dino = c.getEntity();
                Combate.luta(this, (Dinosaur) dino, this.inventory, this.map, this.dinos, 0);
                map.setCellAt(nextPos.getPosX(), nextPos.getPosY(), c);
            }
        }
    }
    public Cord getPos(){
        return this.position;
    }

    public int getPercepcao(){ return this.percepcao; }

    public Inventory getInventory(){ return inventory; }
}

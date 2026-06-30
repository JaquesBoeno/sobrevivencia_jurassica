package TrabalhoPOO;

import java.util.Random;

public abstract class Dinosaur extends Entity {
    protected int dano;
    protected int ataca() {
        return dano;
    }
    protected int index;

    public void move(){
        Random random = new Random();
        this.setDirection( random.nextInt(0, 4));
        super.move();
        if(!map.isWall(nextPos.getPosX(), nextPos.getPosY())){
            Cell c = map.getCellAt(nextPos.getPosX(), nextPos.getPosY());
            if(c.getEntity() != null && c.getEntity().getClass() == Player.class) {
                Player player = (Player) c.getEntity();
                String tipoInimigo = this.dinos[this.getIndex()].getClass().toString();
                System.out.println("Você foi atacado por um " + tipoInimigo.substring(18) + "!");
                Combate.luta((Player) c.getEntity(), this, player.getInventory(), map, dinos, 1);
            }
        }
    }

    public int getIndex() { return index; }

    // abstract void recebeAtaque();
}
package TrabalhoPOO;

import java.util.Scanner;
import java.util.Random;


public abstract class Entity {
    protected int health;
    protected int maxHealth;
    protected Cord position;
    protected Cord nextPos;
    protected int direction;
    protected Map map;
    protected boolean isAlive = true;
    protected int ID;
    private static int qtt =0;
    public enum EntityType {
        PLAYER("player"), TIRANOSSAURO("tiranossauro"), TROODONTE("troodonte"), VELOCIRAPTOR("velociraptor"), COMPSOGNATO("compsognato");

        private final String type;

        EntityType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }
    public Entity(){
        this.ID = qtt;
        qtt+=1;
    }
    public void move(){
        this.nextPos = calcNewPos(this.direction);

        if (map.isInsideMap(nextPos)){
            Cell dest = map.getCellAt(nextPos.getPosX(), nextPos.getPosY());
            if (!dest.isWall()) {
                Box b =  dest.getBox();
                boolean hcomp = false;
                if (b != null)
                    hcomp = b.hasCompsognato();
                if (dest.hasEntity()) {
                    if (this instanceof Player || (this instanceof Dinosaur && dest.getEntity() instanceof Player)){
                        this.startFight(dest.getEntity());
                    }
                } else if (!hcomp) {
                    map.moveEntity(this.position, nextPos);
                    this.position = nextPos;
                }
            }
        }
    };

    protected void startFight(Entity e) {
        System.out.println("====================");
        System.out.println("Combate Iniciado");
        System.out.println("====================");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int num;
        char escolha = 'M';

        Player player;
        Dinosaur dino;

        if (e instanceof Player p) {
            player = p;
            dino = (Dinosaur) this;
        } else {
            player = (Player) this;
            dino = (Dinosaur) e;
        }
        boolean fujir = false;
        Inventory inventario = player.getInventory();

        while (player.getHealth() > 0 && dino.getHealth() > 0 && !fujir) {
            System.out.println("---------------------");
            System.out.println("Vida: " + player.getHealth() + "\tVida Dinossauro: " + dino.getHealth());
            System.out.println("---------------------");
            System.out.println("Escolha o que fazer:");
            System.out.print("M- Ataque corpo-a-corpo " + (inventario.getItems()[0] == 0 ? "com as mãos" : "com bastão elétrico"));
            System.out.print(inventario.getItems()[1] == 0 ? "" : "\nR- Ataque com arma de dardos " + inventario.getItems()[1] + "m");
            System.out.print(inventario.getItems()[2] == 0 ? "" : "\nH- Se curar");
            System.out.println("\nF- Fugir");

            do {
                if (escolha != 'M') {
                    System.out.println("Opção inválida");
                }
                escolha = scanner.next().charAt(0);
            } while (escolha != 'M' && !(escolha == 'R' && inventario.getItems()[1] != 0) && !(escolha == 'H' && inventario.getItems()[2] != 0) && escolha != 'F');

            switch (escolha) {
                case 'M':
                    num = random.nextInt(1, 7);
                    if (inventario.getItems()[0] != 0) {
                        if (num >= 5) {
                            dino.ApplyDamage(2);
                        } else if (num > 1) {
                            dino.ApplyDamage(1);
                        }
                    } else if (dino.getEntityType() != EntityType.TIRANOSSAURO) {
                        if (num == 6) {
                            dino.ApplyDamage(2);
                        } else if (num > 2) {
                            dino.ApplyDamage(1);
                        }
                    }
                    break;
                case 'R':
                    inventario.takeItem(1);
                    if (dino.getEntityType() != EntityType.VELOCIRAPTOR) {
                        dino.ApplyDamage(2);
                    } else {
                        System.out.println("Armas de dardos são inefetivas contra velociraptors");
                    }
                    break;
                case 'H':
                    player.Heal(1);
                    inventario.takeItem(2);
                    break;
                case 'F':
                    fujir = true;
                    break;
            }

            if (dino.getHealth() <= 0) {
                dino.kill();
                break;
            }

            num = random.nextInt(1, 4);
            if (player.getPercepcao() < num) {
                System.out.println("Você recebeu dano");
                player.ApplyDamage(1);
            }

            escolha = 'M';
        }
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    protected Cord calcNewPos(int direction){
        int[] dy = { 0, 0, -1, 1};
        int[] dx = { -1, 1, 0, 0};
        int x = this.position.getPosX() + dx[direction];
        int y = this.position.getPosY() + dy[direction];
        return new Cord( x, y);
    }

    public abstract String render();

    public int getHealth() {
        return health;
    }

    public void ApplyDamage(int damage){
        this.health -= damage;
    }

    public void Heal(int healAmount){
        this.health += healAmount;
        if( this.health > this.maxHealth){
            this.health = this.maxHealth;
        }
    }
    public void kill(){
        if (isAlive) {
            this.isAlive = false;
            Cell c = map.getCellAt(this.position.getPosX(), this.position.getPosY());
            c.setEntity(null);
        }
    }
    public boolean isAlive() {
        return isAlive;
    }

    public abstract EntityType getEntityType();
}

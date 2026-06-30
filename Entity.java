package TrabalhoPOO;

public abstract class Entity {
    protected int health;
    protected Cord position;
    protected Cord nextPos;
    protected int direction;
    protected Map map;
    protected Dinosaur[] dinos;

    public void move(){
        this.nextPos = calcNewPos(this.direction);
        if(!map.isValid(nextPos.getPosX(), nextPos.getPosY())){
            return;
        }
        map.moveEntity(this.position, nextPos);
        this.position = nextPos;

    };


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

    public void recebeAtaque(int dano){
        health -= dano;
    }
}

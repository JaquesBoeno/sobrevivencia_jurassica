package TrabalhoPOO;

public class Cord {
    private int posX;
    private int posY;

    public Cord(){
        this.posX = 0;
        this.posY =0;
    }
    public Cord(int x, int y){
        this.posX = x;
        this.posY = y;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getSquareDistance(Cord b){
        int dx = this.getPosX() - b.getPosX();
        int dy = this.getPosY() - b.getPosY();

        return  dx*dx + dy*dy;
    }
}

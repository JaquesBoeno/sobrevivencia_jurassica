package TrabalhoPOO;

import java.util.Random;

public class Map {
    private final int size;
    private Cell[][] map;

    public Map(int size){
        this.map = new Cell[size][size];
        this.size = size;
        this.generateWalls();
    }

    private void generateWalls(){
        Random random = new Random();

        for (int i = 0; i < this.size; i += 1){
            for (int j = 0; j < this.size; j += 1){
                int p = random.nextInt(0, 100);
                if (p < 20){
                    map[i][j] = new Cell(true);
                } else {
                    map[i][j] = new Cell();
                }
            }
        }
    }

    public boolean isInsideMap(Cord c){
        return c.getPosX() >= 0 && c.getPosX() < this.size && c.getPosY() >= 0 && c.getPosY() < this.size;
    }

    public boolean isValid(Cord c){
        return isInsideMap(c) && (this.map[c.getPosX()][c.getPosY()].isEmpty()) ;
    }

    public Cell getCellAt(int posX, int posY){
        return map[posX][posY];
    }

    public void setCellAt(int posX, int posY, Cell newCell){
        map[posX][posY] = newCell;
    }

    public void moveEntity(Cord from, Cord to) {
        Cell source = getCellAt(from.getPosX(), from.getPosY());
        Entity e = source.getEntity();
        source.setEntity(null);
        setCellAt(from.getPosX(), from.getPosY(), source);

        Cell dest = getCellAt(to.getPosX(), to.getPosY());
        dest.setEntity(e);
        setCellAt(to.getPosX(), to.getPosY(), dest);
    }

    public void renderMap(){
        for (int i = 0; i < this.size; i += 1) {
            for (int j = 0; j < this.size; j += 1) {
                System.out.print(map[j][this.size - i -1].render() + " ");
            }

            System.out.println();
        }
    }

    public void renderMap(Cord player_cord, int radius){
        Cord current_cord = new Cord();
        for (int i = 0; i < this.size; i += 1) {
            for (int j = 0; j < this.size; j += 1) {
                current_cord.setPosX(j);
                current_cord.setPosY(this.size - i -1);
                String str = "";
                if (player_cord.getSquareDistance(current_cord) <= radius*radius){
                    str = map[current_cord.getPosX()][current_cord.getPosY()].render();
                } else {
                    str = TextColor.color("?", TextColor.Color.GRAY);;
                }
                System.out.print( str + " ");
            }

            System.out.println();
        }
    }

    public int getSize() {
        return this.size;
    }
}

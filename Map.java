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
                int p = random.nextInt(0, 101);
                if (p <= 20){
                    map[i][j] = new Cell(true);
                } else {
                    map[i][j] = new Cell();
                }
            }
        }
    }

    public boolean isValid(int posX, int posY){
        // fora dos limites do mapa
        if (posX < 0 || posX >= this.size || posY < 0 || posY >= this.size)
            return false;

        // contrario do se tem parede (se tem retorna falso, caso não tenha retorna true)
        return (this.map[posX][posY].isEmpty());
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
                System.out.print(map[i][j].render() + " ");
            }

            System.out.println();
        }
    }

    public int getSize() {
        return this.size;
    }
}

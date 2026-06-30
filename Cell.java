package TrabalhoPOO;

public class Cell {
    private boolean isWall;
    private Entity entity;
    private Box box;

    public Cell() {
        this.isWall = false;
        this.entity = null;
        this.box = null;
    }

    public Cell(boolean wall) {
        this.isWall = wall;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setBox(Box box) {
        this.box = box;
    }

    public Box getBox(){ return box; }

    public boolean isEmpty(){
        return !isWall && entity == null;
    }
    public boolean isWall() {
        return this.isWall;
    }
    public boolean hasEntity(){
        return this.entity != null;
    }

    public String render(){
        String r = "";
        if (isWall) r += '#';
        if (this.entity!= null) r += entity.render();
        if (this.box != null) r += box.render();
        if (r.isEmpty()) r += ".";
        return r;
    }
}

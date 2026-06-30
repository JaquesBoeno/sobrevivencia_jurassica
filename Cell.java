package TrabalhoPOO;

public class Cell {
    private boolean hasWall;
    private Entity entity;
    private Box box;

    public Cell() {
        this.hasWall = false;
        this.entity = null;
        this.box = null;
    }

    public Cell(boolean wall) {
        this.hasWall = wall;
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
        return !hasWall && entity == null;
    }
    public boolean hasWall() {
        return this.hasWall;
    }
    public boolean hasEntity(){
        return this.entity == null;
    }

    public String render(){
        String r = "";
        if (hasWall) r += '#';
        if (this.entity!= null) r += entity.render();
        if (this.box != null) r += box.render();
        if (r.isEmpty()) r += ".";
        return r;
    }
}

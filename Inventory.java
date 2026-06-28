package TrabalhoPOO;

public class Inventory {
    private Item[] items;
    private int qttKitHealth;
    public Inventory(){
        this.items = new Item[3]; // 0 -> bastao 1->arma de dardos
        this.qttKitHealth = 0;
    }

    public String renderInventory(){
        String str = "";
        str +=  "[1] " + (this.items[0] == null ? "N/A" : "Bastão Eletrico");
        str += " | [2] " + (this.items[1] == null ? "N/A" : "Arma de dardos (0 m)" );
        return str;
    }
}

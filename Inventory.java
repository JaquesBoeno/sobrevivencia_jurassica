package TrabalhoPOO;

public class Inventory {
    private int[] items;
    public Inventory(){
        this.items = new int[] {0, 0, 0}; // 0 -> bastao 1-> arma de dardos 2-> kit médico
    }

    public String renderInventory(){
        String str = "";
        str +=  "[1] " + (this.items[0] == 0 ? "N/A" : "Bastão Elétrico");
        str += " | [2] " + (this.items[1] == 0 ? "N/A" : "Arma de dardos (" + this.items[1] + " m)");
        str += " | [3] " + (this.items[2] == 0 ? "N/A" : "Kit médico");
        return str;
    }

    public void receiveItem(int t){
        items[t]++;
        System.out.println(items[t]);
    }
    public void takeItem(int index){
        items[index]--;
    }

    public int[] getItems() { return items; }

}

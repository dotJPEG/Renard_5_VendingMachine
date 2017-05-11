/*
 * object for vending machine
 * 
 * 
 */
package renard_5_vendingmachine;
/**
 *
 * @author root
 */

public class Machine {
    Item[][] stock = new Item[3][3];
    double money;
    
    public Machine(){
        this.money=0.00;
        gen();
    }
    
    //first fillup/reset stock
    public void gen(){
        String[][] names = {{"M&Ms","Heath","Twix"},
                            {"Lays","Temp","Nuts"},
                           {"Water","Coke","Pepsi"}};
        String[][] types = {{"candy","candy","candy"},{"salty snack","salty snack","salty snack"},{"drink","drink","drink"}};
        int[][] calories = {{80,70,85},{120,135,60},{0,100,120}};
        double[][] prices = {{1.50,1.50,1.50},{2.00,2.00,2.00},{2.00,1.50,1.50}};

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.stock[i][j] = new Item(names[i][j], types[i][j], calories[i][j], prices[i][j], 3);
            }
        }
    }
    
    //restock vending machine (add 3 to every item)
    public void restock(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                stock[i][j].upAmount();
                stock[i][j].upAmount();
                stock[i][j].upAmount();
            }
        }
    }
    
    //remove one item from a certain slot
    public void take(int i, int j){
        stock[i][j].downAmount();
        this.money+=stock[i][j].getPrice();
    }
    
    //returns how much moeny is in the machine
    public double getMoney(){
        return this.money;
    }
    
    //returns a specific slot in the stock array
    public Item getStock(int one, int two){
        return this.stock[one][two];
    }
    //i have this because i was putting 1,1 instead if 0,0 on a bunch of lines (the view command) on accident and i was to lazy to fix it
    public Item getStocks(int one, int two){
        return this.stock[one-1][two-1];
    }
    
    //adds or subtracts money from the machine depencing on the input int
    public void changeMoney(double change){
        money+=change;
    }
    
    //sets the quantity of all items in the machine to 0
    public void empty(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.stock[i][j].setAmount(0);
            }
        }
    }
    
}


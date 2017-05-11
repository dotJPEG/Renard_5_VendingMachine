/*
 * 
 * object for items within vending machine
 * 
 */
package renard_5_vendingmachine;
import java.util.*;
import java.math.*;
/**
 *
 * @author root
 */
public class Item {
    String name;
    String type;
    int calories;
    double price;
    int amount;
    
    public Item(String namee, String typee, int caloriess, double pricee, int amountt){
        name = namee;
        type = typee;
        calories = caloriess;
        price = pricee;
        amount = amountt;
    }
    
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }

    public double getPrice() {
        return price;
    }
    
    public int getAmount(){
        return this.amount;
    }
    
    //adds one to amount
    public void upAmount(){
        this.amount++;
    }
    //subtracts one from amount
    public void downAmount(){
        this.amount--;
    }
    //sets amount to a specific value
    public void setAmount(int amountt){
        this.amount = amountt;
    }
}

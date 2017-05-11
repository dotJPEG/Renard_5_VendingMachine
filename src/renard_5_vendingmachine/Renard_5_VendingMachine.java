/*******************************************************************************
 * Filename:    Renard_5_VendingMachine
 * Author:      Bob Renard
 * Date:        05-10-17
 * Description: Vending machine simulator
 * Input:       Basic commands via terminal
 * Output:      Text based output depicting events
 *******************************************************************************/

package renard_5_vendingmachine;
import java.util.*;
import java.text.DecimalFormat;
public class Renard_5_VendingMachine {
static Scanner input = new Scanner(System.in);
    static double money;

    //used to print out correct statement for money (5.00 instead of 5.0)
    private static DecimalFormat df2 = new DecimalFormat("#.00");

    public static void main(String[] args) {
        money = 5.00;//wallet starts at 5 bucks
        System.out.println("Its a vending machine, you can type things to do things");
        
        boolean game = true;//run the game based on this boolean
        Machine machine = new Machine();//creates a vending machine
        while(game){//loop for game
            System.out.println("You have $" + df2.format(money) + " in your pocket.");
        System.out.println("Commands:\n"
                + "<view>(prints out a graphical representation of the machine)\n"  //
                + "<buy>(buy an item) \n"                                           //
                + "<restock>(add 3 to the quantity of all items)\n"                 //
                + "<money>(check how much money is in the machine)\n"               //lists off the commands you can enter into the machine
                + "<more>(extra command really only useful for debugging)\n"        //
                + "<quit>(quits)");                                                 //
            String command = input.next();  //users input tracked by this string
                for (int i = 0; i < 100; i++) {
                    System.out.println("");
            }
            if(command.equalsIgnoreCase("buy")){//user wishes to buy
                System.out.println("Please enter coordinates for item you wish to purchase (ex: \"1 2\")");
                int one, two; //one is for collum, two is for row
                one = input.nextInt()-1; two = input.nextInt()-1; //set this equal to scanner-1 so the user can use the number 3 for the 3rd slot
                System.out.println("Do you wish to pay $" + machine.getStock(one, two).getPrice() + " for one " +
                        machine.getStock(one, two).getName() + " of type "+ machine.getStock(one, two).getType() +"?"); //asks user if they are sure about their choice
                System.out.println("<yes> <no>");
                command = input.next();
                if(command.equalsIgnoreCase("yes")){//user is happy with their choice
                    if(money >= machine.getStock(one, two).getPrice() && machine.getStock(one, two).getAmount()>0){ //if you have enout money and there is enough items
                        money-=machine.getStock(one, two).getPrice();//take money away from you
                        machine.changeMoney(machine.getStock(one, two).getPrice());//give it to the machine
                    }else{//if you dont have enough money or there arent enough items
                        if(money<=machine.getStock(one, two).getPrice()){
                            System.out.println("You don't have enough money");
                        }else{
                            System.out.println("Out of stock");
                        }
                    }                    
                }else if(command.equalsIgnoreCase("no")){//user does not wish to go through with their decision
                    System.out.println("Returning to menu");
                }else{//user is dumb
                    System.out.println("That is not a valid answer, returning to menu");
                }
            }else if(command.equalsIgnoreCase("view")){//user wishes to see a graphical representation of the machine
                System.out.println(//commenting for this section is after the code part of this 'else if'
                "_____________________\n" +
                "_"+machine.getStocks(1, 1).getName()+space(machine.getStocks(1, 1).getName())+"__"+machine.getStocks(2, 1).getName()+space(machine.getStocks(2, 1).getName())+"__"+machine.getStocks(3, 1).getName()+space(machine.getStocks(3, 1).getName())+"_\n" +
                "_$"+df2.format(machine.getStocks(1, 1).getPrice())+"__$"+df2.format(machine.getStocks(2, 1).getPrice())+"__$"+df2.format(machine.getStocks(3, 1).getPrice())+"_\n" +
                "_"+1+"   "+1+"__"+2+"   "+1+"__"+3+"   "+1+"_\n" +
                "_"+machine.getStocks(1, 1).getAmount()+"LEFT__"+machine.getStocks(2, 1).getAmount()+"LEFT__"+machine.getStocks(3, 1).getAmount()+"LEFT_\n" +
                "_____________________\n" +
                "_"+machine.getStocks(1, 2).getName()+space(machine.getStocks(1, 2).getName())+"__"+machine.getStocks(2, 2).getName()+space(machine.getStocks(2, 2).getName())+"__"+machine.getStocks(3, 2).getName()+space(machine.getStocks(3, 2).getName())+"_\n" +
                "_$"+df2.format(machine.getStocks(1, 2).getPrice())+"__$"+df2.format(machine.getStocks(2, 2).getPrice())+"__$"+df2.format(machine.getStocks(3, 2).getPrice())+"_\n" +
                "_"+1+"   "+2+"__"+2+"   "+2+"__"+3+"   "+2+"_\n" +
                "_"+machine.getStocks(1, 2).getAmount()+"LEFT__"+machine.getStocks(2, 2).getAmount()+"LEFT__"+machine.getStocks(3, 2).getAmount()+"LEFT_\n" +
                "_____________________\n" +
                "_"+machine.getStocks(1, 3).getName()+space(machine.getStocks(1, 3).getName())+"__"+machine.getStocks(2, 3).getName()+space(machine.getStocks(2, 3).getName())+"__"+machine.getStocks(3, 3).getName()+space(machine.getStocks(3, 3).getName())+"_\n" +
                "_$"+df2.format(machine.getStocks(1, 3).getPrice())+"__$"+df2.format(machine.getStocks(2, 3).getPrice())+"__$"+df2.format(machine.getStocks(3, 3).getPrice())+"_\n" +
                "_"+1+"   "+3+"__"+2+"   "+3+"__"+3+"   "+3+"_\n" +
                "_"+machine.getStocks(1, 3).getAmount()+"LEFT__"+machine.getStocks(2, 3).getAmount()+"LEFT__"+machine.getStocks(3, 3).getAmount()+"LEFT_\n" +
                "_____________________"
                );             
//_____________________
//_NAMES__NAMES__NAMES_ //names of the items
//_PRICE__PRICE__PRICE_ //prices of the items
//_CALLS__CALLS__CALLS_ //call sign for the items
//_QUANT__QUANT__QUANT_ //amount of said item within machine
//_____________________
//_NAMES__NAMES__NAMES_
//_PRICE__PRICE__PRICE_
//_CALLS__CALLS__CALLS_
//_QUANT__QUANT__QUANT_
//_____________________
//_NAMES__NAMES__NAMES_
//_PRICE__PRICE__PRICE_
//_CALLS__CALLS__CALLS_
//_QUANT__QUANT__QUANT_
//_____________________
           
            }else if(command.equalsIgnoreCase("restock")){ //restocks the machine to have a quantity of 3 for all items
                System.out.println("Setting all items within the machine to a quantity of 3.");
                machine.empty(); //sets amount to 0
                machine.restock(); //adds 3 to all
            }else if(command.equalsIgnoreCase("money")){ //user wants to know how much money they've spent
                System.out.println("This vending machine has $" + machine.getMoney() + " in it");
            }else if(command.equalsIgnoreCase("more")){//extra commands that arent useful to the average person, used mainly for debugging
                System.out.println("Extra Commands:");
                System.out.println("<addMoney>(gives you more money)\n" 
                                 + "<resetMachine>(resets machine's money and stock)"); 
             }else if(command.equalsIgnoreCase("addMoney")){//resets you money to $5.00
                System.out.println("Resetting your money to $5.00");
                money = 5.00;
             }else if(command.equalsIgnoreCase("resetMachine")){//reset machine to original stock
                System.out.println("Resseting machine");
                machine.gen();
            }else if(command.equalsIgnoreCase("quit")){//user wishes to not use the machine anymore
                System.out.println("Good bye");
                game = false;
            }else{//user is dumb
                System.out.println("Not a valid command, returning to menu");
            }
        }
    }
    
    //takes a string and returns a string equal to 5-input.length()
    //used to print out name correctly in the machine view command
    public static String space(String name){
        int meme = 5-name.length();
        String end = "";
        for (int i = 0; i < meme; i++) {
            end = end + " ";
        }
        return end;
    }
    
    
}

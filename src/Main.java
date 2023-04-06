import java.util.Scanner;
import java.util.Calendar;

public class Main {
    public static int numberofkeychains;
    public static double tax = 8.25;
    public static int base_shipping = 5;
    public static double price_per_keychain_shipping = 1;
    public static double keychaincost = 10;
    public static double total;
    public static double subtotal;
    public static boolean wknddiscount = false;


    public static void main(String[] args) {
        startgame(numberofkeychains);
        //public static int numberofkeychains = 0;

    }
    public static void startgame(int numberofkeychains){
        Calendar c = Calendar.getInstance();
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        //System.out.println(dayOfWeek);
       // LLLLLLLLLLLLL;
        if (dayOfWeek == 5|| dayOfWeek == 6|| dayOfWeek==7){
            System.out.println("Reminder: Weekend Discount is today, if you order more than 5 keychains you get the 6th one FREE!" );
            wknddiscount = true;
        }
        else {}
        Scanner scanner = new Scanner(System.in);
       // int numberofkeychains = 0;
        int priceperkeychain = 10;
        System.out.println("\n Ye olde key shoppey \n 1. Add keychains to order \n 2. Remove keychains from order" +
                "\n 3. View current order \n 4. Checkout");

        try {
            int input = scanner.nextInt();
            if (input > 4 || input < 1){
                System.out.println("Input a valid number silly!");
                startgame(numberofkeychains);
            }
            switch (input) {
                case 1:
                    numberofkeychains = add_keychains(numberofkeychains);
                    System.out.println(numberofkeychains);
                    break;
                case 2:
                    System.out.println(numberofkeychains);
                    remove_keychains(numberofkeychains);
                    //remove_keychains(numberofkeychains);

                    break;
                case 3:
                    //Viewcurrentorder();
                    //Integer yargh = add_keychains();
                    view_order(tax, keychaincost, base_shipping, numberofkeychains, price_per_keychain_shipping);

                    break;
                case 4:
                    checkout(numberofkeychains, keychaincost, tax, base_shipping, price_per_keychain_shipping);
                    break;
            }
        }catch(Exception e) {
            System.out.println("Input a valid number! ");
            startgame(numberofkeychains);
        }
    }
    public static int add_keychains(int numberofkeychains){
        System.out.println("ADD KEYCHAINS");
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many keychains would you like to add?");
        try {
        int addedkeychains = scanner.nextInt();
            numberofkeychains = (numberofkeychains + addedkeychains);
            System.out.println("you now have " + numberofkeychains );
            startgame(numberofkeychains);
        }catch(Exception e){
            System.out.println("input a whole NUMBER of keychains you want to add");
            add_keychains(numberofkeychains);
        }
        return numberofkeychains;

    }

    public static int remove_keychains(int numberofkeychains){
        System.out.println("REMOVE KEYCHAINS");
        Scanner scanner = new Scanner(System.in);
        System.out.println("You currently have " + numberofkeychains + " keychains. ");
        if (numberofkeychains == 0) {
            System.out.println("You cannot remove keychains.");
            startgame(numberofkeychains);
        }
        else {
            System.out.println("How many keychains would you like to remove?");
            try {

                int removedkeychains = scanner.nextInt();
                if (removedkeychains>numberofkeychains){
                    System.out.println("oopsies! you cant remove a number bigger than the amount of keychains you have.");
                    remove_keychains(numberofkeychains);
                }
                else{
                    numberofkeychains = (numberofkeychains - removedkeychains);
                    System.out.println("you now have " + numberofkeychains);
                }

                startgame(numberofkeychains);
            }catch(Exception e){
                System.out.println("input a valid whole integer");
                remove_keychains(numberofkeychains);
            }
        }
        return numberofkeychains;
    }
    public static void view_order(double tax, double keychaincost, int base_shipping, int numberofkeychains, double price_per_keychain_shipping){
        subtotal = ((numberofkeychains * keychaincost) + base_shipping + (numberofkeychains * price_per_keychain_shipping));
        if (wknddiscount == true){
            if (numberofkeychains> 5) {
                subtotal = (((numberofkeychains - 1) * keychaincost) + base_shipping + (numberofkeychains * price_per_keychain_shipping));
            }
            else{}
        }
        System.out.println("number of keychains is " + numberofkeychains);
        System.out.println("The shipping charges on this order are:" + (numberofkeychains * price_per_keychain_shipping) + base_shipping + "$");
        System.out.println("the price per keychain shipped is " + price_per_keychain_shipping);
        System.out.println("the base shipping cost per order is " + base_shipping + "$");
        System.out.println("the subtotal before tax is: " + subtotal);
        double l = (subtotal * (tax/100));
        total = (subtotal + l);
        System.out.println("the tax is:" + l);
        System.out.println("Your total is $" + (total));


        startgame(numberofkeychains);
    }




    public static void checkout(int numberofkeychains, double keychaincost, double tax, int base_shipping, double price_per_keychain_shipping){
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHECKOUT \n What is your name? ");
        String name = scanner.nextLine();
        //int total = (numberofkeychains * 10);
        //System.out.println(total);
        System.out.println(" You have purchased " + numberofkeychains + " keychains. \n Keychains cost " +keychaincost+ " each. \n Total cost is " + (total)+ ". \n Thanks for your order, " +name+"!" );

    }


    public static void orderhistory(String name){

    }

}
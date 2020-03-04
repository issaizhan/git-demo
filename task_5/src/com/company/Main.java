package com.company;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {
        // Task 1 check
        order Order1 = new order(10001, 7717, "Margarita", 2);
        Order1.namePizza = Order1.checkName();
        System.out.println(Order1.displayOrder());
        Scanner n = new Scanner(System.in);
        System.out.println("Do you want to change amount of Pizza ordered? Enter y/n");
        char ansAmount = n.next().charAt(0);
        if (ansAmount == 'y') {
            System.out.println("Enter new amount: ");
            int newAm = n.nextInt();
            Order1.changeAmount(newAm);
            System.out.println("New order is: " + Order1.displayOrder());
        }

        // Task 2 check
        // String[] oldIng = new String[7];
        // oldIng[0] = "Corn";
        // oldIng[1] = "Cheese";
        // String[] newIng = new String[7];
        // newIng[0] = "Bacon";
        // newIng[1] = "Olives";
        // oldIng = Order1.addIngredients(newIng, oldIng);
        // for (int i = 0; i < 7; i++) {
        // System.out.println(oldIng[i]);
        //}

        //Task 3 check
        char wantCalzoni = 'y';
        String[] oldIng = new String[7];
        oldIng[0] = "Tomato paste";
        oldIng[1] = "Cheese";
        String[] newIng = new String[7];
        newIng[0] = "Bacon";
        newIng[1] = "Olives";
        Order1.ToString(wantCalzoni, Order1.addIngredients(newIng, oldIng));

        //Task 4 check
        System.out.println("Client number " + Order1.clientNumber + " wants to order " + Order1.amountPizza + " of " + Order1.checkName() + ".");
        Order1.localtime();
    }


}

class order {
    int orderNumber;
    int clientNumber;
    String namePizza;
    int amountPizza;


    // Task 1
    order(int ordN, int clN, String nP, int amP) {
        orderNumber = ordN;
        clientNumber = clN;
        namePizza = nP;
        amountPizza = amP;
    }

    String checkName() {
        char c[] = namePizza.toCharArray();
        int l = 0;
        for (char i : c) {
            l++;
        }
        if (l < 4) {
            namePizza = Integer.toString(clientNumber) + "_" + Integer.toString(orderNumber);
        }
        return namePizza;
    }

    String displayOrder() {
        String disp;
        disp = "[" + Integer.toString(orderNumber) + ": " + Integer.toString(clientNumber) + ": " + namePizza + ": " + Integer.toString(amountPizza) + "]";
        return disp;
    }

    void changeAmount(int newAm) {
        amountPizza = newAm;
    }

    //Task 2
    String[] addIngredients(String[] newIngredArray , String[] oldIng) {
        //Ingredients that have already been ordered previously
        String [] prevIngredArray = oldIng;
        int numberIngr = 7;
        for (int j = 0; j < 7; j++) {
            if (prevIngredArray[j] == null) {
                numberIngr--;
            }
        }

        int newNumberIngr = 7;
        for (int j = 0; j < 7; j++) {
            if (newIngredArray[j] == null) {
                newNumberIngr--;
            }
        }

        if (numberIngr + newNumberIngr > 7) {
            System.out.println("You have ordered more than 7 ingredients.");
        }

        boolean statusSame = false;
        int k = 0;
        for (int i = 0; i < newNumberIngr; i++) {
            for (int j = 0; j < numberIngr; j++) {
                if (newIngredArray[i] == prevIngredArray[j]) {
                    System.out.println("You have already ordered " + newIngredArray[i]);
                    statusSame = true;
                }
            }
            if (statusSame == false && numberIngr + k < 7) {
                prevIngredArray[numberIngr + k] = newIngredArray[i];
                k++;
            }
            statusSame = false;
        }

        return prevIngredArray;
    }

    // Task 3
    void ToString(char ansBase, String[] listIng) {
        double costBaze = 1.0;
        double costIngr;
        double sum = 0;
        int numberIng = 7;

        System.out.println("```");
        System.out.println("******************************** ");
        System.out.println("Order: " + orderNumber);
        System.out.println("Client: " + clientNumber);
        System.out.println("Name: " + namePizza);
        System.out.println("--------------------------------");
        if (ansBase == 'y')
        {
            costBaze = costBaze + 0.5;
            System.out.println("Pizza Base (Calzone)" + costBaze + "€" );
        } else
        {
            System.out.println("Pizza Base" + costBaze + "€" );
        }
        for (int i = 0; i < 7; i++)
        {
            if (listIng[i] == null) {
                numberIng--;
            }
        }
        for (int j = 0; j < numberIng; j++)
        {
            if (listIng[j] == "Tomato paste" || listIng[j] == "Cheese")
            {
                sum = sum + 1.0;
                System.out.println(listIng[j] + " - " + 1 + "€");
            }
            if (listIng[j] == "Salami")
            {
                sum = sum + 1.5;
                System.out.println(listIng[j] + " - " + 1.5 + "€");
            }
            if (listIng[j] == "Bacon")
            {
                sum = sum + 1.2;
                System.out.println(listIng[j] + " - " + 1.2 + "€");
            }
            if (listIng[j] == "Garlic")
            {
                sum = sum + 0.3;
                System.out.println(listIng[j] + " - " + 0.3 + "€");
            }
            if (listIng[j] == "Corn")
            {
                sum = sum + 0.7;
                System.out.println(listIng[j] + " - " + 0.7 + "€");
            }
            if (listIng[j] == "Pepperoni")
            {
                sum = sum + 0.6;
                System.out.println(listIng[j] + " - " + 0.6 + "€");
            }
            if (listIng[j] == "Olives")
            {
                sum = sum + 0.5;
                System.out.println(listIng[j] + " - " + 0.5 + "€");
            }
        }
        System.out.println("--------------------------------");
        System.out.println("Total: " + sum + "€");
        System.out.println("Amount: " + amountPizza);
        System.out.println("--------------------------------");
        System.out.println("Overall sum for order: " + sum*amountPizza);
        System.out.println("********************************");
        System.out.println("```");

    }

    void localtime()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("Local time is: " + dtf.format(now));
    }

}


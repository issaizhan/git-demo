package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    //Printing name
        Scanner s = new Scanner (System.in);
	    System.out.println("Enter your name: ");
	    String name;
	    name = s.nextLine();
	    System.out.println("Hello " + name + "!");

	    //Calculating sum and product
        Scanner n = new Scanner(System.in);
        System.out.println("Enter amount of elements: ");
        int number;
        number = n.nextInt();

        int elements[] = new int[number];
        System.out.println("Enter " + number + " elements:");
        int sum = 0;
        int product = 1;
        for(int i = 0; i < number; i++)
        {
            elements[i] = n.nextInt();
            sum = sum + elements[i];
            product = product*elements[i];
        }
        System.out.println("Sum is equal to " + sum + ". Product is equal to " + product + ".");
    }
}

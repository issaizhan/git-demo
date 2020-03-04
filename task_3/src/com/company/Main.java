package com.company;

import java.util.Scanner;
import java.time.Month;

public class Main {

    public static void main(String[] args) {
	    // Accepting year and month
        Scanner n = new Scanner(System.in);
        int input[] = new int[2];
        int year = 0, m = 0;
        System.out.println("Enter year: ");
        year = n.nextInt();
        System.out.println("Enter month: ");
        m = n.nextInt();

        //Validation

        while (year < 0)
        {
            System.out.println("You entered non-existing year. Please enter year again.");
            year = n.nextInt();
        }
        while (m < 1 || m > 12)
        {
            System.out.println("You entered non-existing month. Please enter month again.");
            m = n.nextInt();
        }

        //Showing the date in right format
        Month month = Month.of(m);
        System.out.print(year + " " + month);
        if (year % 4 == 0)
        {
            System.out.println( " - leap year");
        } else
        {
            System.out.println(" - not a leap year");
        }
    }
}

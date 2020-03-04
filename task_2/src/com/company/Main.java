package com.company;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

	    //Taking n integers from the user
        Scanner n = new Scanner(System.in);
        System.out.println("Enter amount of elements: ");
        int number = 0;
        number = n.nextInt();
        System.out.println("Enter " + number + " elements:");
        int elements[] = new int[number];
        int el[] = new int[number];
        int lengthes[] = new int[number];
        for(int i = 0; i < number; i++)
        {
            elements[i] = n.nextInt();
            el[i] = elements[i];
            while(elements[i] != 0)
            {
                elements[i] = elements[i]/10;
                lengthes[i]++;
            }
        }

        //Find the shortest and the longest numbers
        int min = 10000, max = 0;
        int index_min = 0, index_max = 0;
        for (int i = 0; i < number; i++)
        {
            if (lengthes[i] < min) {
                min = lengthes[i];
                index_min = i;
            }
            if (lengthes[i] > max) {
                max = lengthes[i];
                index_max = i;
            }
        }
        System.out.println("The first shortest number is " + el[index_min] + " and its length is " + min + ". The first longest number is " + el[index_max] + " and its length is " + max + ".");

        //Minimum amount of different digits
        int alldifdig[] = new int[number];
        int[][] digits = new int[number][max];
        boolean areSame = false;
        for (int i = 0; i < number; i++)
        {
            elements[i] = el[i];
            for (int j = 0; j <= lengthes[i]-1; j++)
            {
                digits[i][max-1-j] = el[i] % 10;
                el[i] = el[i] / 10;
            }
        }
        for (int i = 0; i < number; i++)
        {
            alldifdig[i] = 1;
            for (int j = max - lengthes[i] + 1; j < max; j++)
            {
                for  (int k = max - lengthes[i]; k < j; k++)
                {
                    if (digits[i][j] == digits[i][k]) {
                        areSame = true;
                    }
                 }
                if (areSame == false) {
                    alldifdig[i]++;
                }
                areSame = false;
            }
        }
        int mindiff = 1000000;
        int index_mindiff = 0;
        for (int k = 0; k < number; k++) {
            if (alldifdig[k] < mindiff) {
                mindiff = alldifdig[k];
                index_mindiff = k;
            }
        }
        System.out.println("The number which has the smallest amount of different digits is " + elements[index_mindiff] + " and it has " + mindiff + " different digits.");

        //In the ascending order
        int countAscending = 1, countNumbers = 0;
        for (int i = 0; i < number; i++)
        {
            for (int j = max - lengthes[i] + 1; j < max; j++)
            {
                if (digits[i][j] > digits[i][j-1])
                {
                    countAscending++;
                }
            }
            if (countAscending == lengthes[i] )
            {
                System.out.println("The first number which digits are in ascending order is " + elements[i] + ".");
                break;
            } else {
                countNumbers++;
            }
            countAscending = 1;
        }
        if (countNumbers == number)
        {
            System.out.println("The are no numbers which digits are in ascending order");
        }

        //Number which consists of all different digits
        boolean statusDiff = false;
        for (int i = 0; i < number; i++)
        {
            if (alldifdig[i] == lengthes[i])
            {
                System.out.println("The first number which consists of only different digits is " + elements[i] + ".");
                statusDiff = true;
                break;
            }
        }
        if (statusDiff == false)
        {
            System.out.println("There are no numbers which have all digits different.");
        }
    }
}

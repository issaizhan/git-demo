package com.company;


import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //1. Input matrix, find its size, validate
        Scanner n = new Scanner(System.in);
        int row, column;
        System.out.println("Enter number of rows of matrix:");
        row = n.nextInt();
        System.out.println("Enter number of columns of matrix:");
        column = n.nextInt();
        while (row <= 0 || column <= 0) {
            System.out.println("Invalid size of matrix. Please enter size again.");
            row = n.nextInt();
            column = n.nextInt();
        }

        //2. Filling matrix with random numbers
        System.out.println("Enter M (max element possible for matrix)");
        int M;
        M = n.nextInt();
        int[][] matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = (int)(Math.random()*2*M + 1) - M;
            }
        }
        //To check initial matrix
        //      for (int i = 0; i < row; i++)
        //      {
        //          for (int j = 0; j < column; j++)
        //          {
        //              System.out.print(matrix[i][j] + " ");
        //          }
        //          System.out.println();
        //      }


        //3. Order rows and columns
        System.out.println("Enter the kth column based on which matrix will be rearranged (from 1 to " + column + ")."); // Columns starts from first not from zeroes for user
        int k;
        k = n.nextInt();
        while (k < 1 || k > column) {
            System.out.println("Out of range of matrix. Select another k.");
            k = n.nextInt();
        }
        int minVal = M * 100;
        int[] intermed;
        int a = 0;
        for (int i = 0; i < row; i++) //place
        {
            for (int j = i; j < row; j++) {
                if (matrix[j][k - 1] < minVal) {
                    minVal = matrix[j][k - 1];
                    a = j;
                }
            }
            intermed = matrix[i];
            matrix[i] = matrix[a];
            matrix[a] = intermed;
            a++;
            minVal = M * 100;
        }
        System.out.println("The matrix after rearrangement is: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        //4. Find sum between two positive elements
        int count = 0, firstPos = 0, secondPos = 0, firstInd = 0, secondInd = 0, sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > 0) {
                    secondPos = matrix[i][j];
                    secondInd = j;
                    count++;
                }
                if (count == 2) {
                    break;
                }
                firstPos = secondPos;
                firstInd = secondInd;
            }
            for (int j = firstInd + 1; j < secondInd; j++) // excluding the two numbers themselves
            {
                sum = sum + matrix[i][j];
            }
            if (count < 2) {
                System.out.println("Row number " + i + ". No two positive numbers in the row");
            } else {
                System.out.println("Row number " + i + ". Elements: " + firstPos + " and " + secondPos + ". Sum: " + sum);
            }
            count = 0;
            sum = 0;
        }

        // 5. Find max element, delete the rows and columns with max element
        int maxEl;
        if (M > 0) {
            maxEl = -M * 100;
        } else {
            maxEl = M * 100;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] > maxEl) {
                    maxEl = matrix[i][j];
                }
            }
        }
        System.out.println("Matrix after deleting columns and rows with max element: ");
        boolean statusRow = true, statusCol = true, newLine = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                for (int s = 0; s < column; s++) {
                    if (matrix[i][s] == maxEl)
                        {
                            statusRow = false;
                            newLine = false;
                        }
                }
                for (int p = 0; p < row; p++)
                {
                    if (matrix[p][j] == maxEl)
                    {
                        statusCol = false;
                    }
                }
                if (statusCol == true && statusRow == true)
                {
                    System.out.print(matrix[i][j] + " ");
                }
                statusCol = true;
                statusRow = true;
            }
            if (newLine == true)
            {
                System.out.println();
            }
            newLine = true;
        }
    }
}

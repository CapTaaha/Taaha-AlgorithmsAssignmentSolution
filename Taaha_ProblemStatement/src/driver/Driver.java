package driver;

import java.util.Scanner;

import sort.MergeSortAscending;
import sort.MergeSortDecending;

public class Driver {
    public static void main(String[] args) {

        // Taking number of companies
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter the number of companies:");
        int n = scn.nextInt();

        // creatind an array and boolean counts
        Double[] array = new Double[n];
        int boolTrue = 0;
        int boolFalse = 0;

        // Loop for each company
        for (int i = 0; i < n; i++) {
            System.out.println("Enter current stock price of the company " + (i + 1));
            Double stock = scn.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            Boolean bool = scn.nextBoolean();
            array[i] = stock;

            if (bool == true) {
                boolTrue++;
            } else {
                boolFalse++;
            }
        }

        // Displaying operations
        System.out.println(
                "Enter the operation that you want to perform:\n 1. Display the companies stock prices in ascending order\n 2. Display the companies stock prices in descending order\n 3. Display the total no of companies for which stock prices rose today\n 4. Display the total no of companies for which stock prices declined today\n 5. Search a specific stock price\n 6. press 0 to exit");

        // Switch for taking in operation required
        int operation = scn.nextInt();

        switch (operation) {
            case 1: {
                System.out.println("Stock prices in ascending order are :");
                MergeSortAscending msa = new MergeSortAscending();
                msa.sort(array, 0, array.length - 1);
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i] + "");
                }
                break;
            }

            case 2: {
                System.out.println("Stock prices in descending order are :");
                MergeSortDecending msd = new MergeSortDecending();
                msd.sort(array, 0, array.length - 1);
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i] + "");
                }
                break;
            }

            case 3: {
                System.out.println("Total no of companies whose stock price rose today : " + boolTrue);
                break;
            }

            case 4: {
                System.out.println("Total no of companies whose stock price declined today : " + boolFalse);
                break;
            }

            case 5: {
                System.out.println("Enter the key value:");
                Double key = scn.nextDouble();
                BinarySearch bs = new BinarySearch();
                Double result = bs.binarySearch(array, 0, array.length - 1, key);
                if (result == -1) {
                    System.out.println("Stock of value " + key + " is not present");
                } else {
                    System.out.println("Stock of value " + key + " is present");
                }
                break;
            }

            case 0: {
                System.out.println("Exited Successfully!");
                break;
            }

            default: {
                System.out.println("Please enter the valid number!");
            }

        }

        scn.close();

    }
}



/*
/ ---------------------------------------------------------
//LAB 2
// TASK 4 - Array Sorting And Searching
// Author : Aditya Rakesh Kakadia (2868381), Adham Selo (2811093)
//
 **/

import java.util.Random; // import random class to generate random numbers
import java.util.Scanner; // import scanner class to read user input

public class ArraySortingAndSearching {

    // bubble sort algorithm: repeatedly swap adjacent elements if they are out of order
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int t = arr[j]; // temporary variable for swap
                    arr[j] = arr[j + 1]; // move smaller element left
                    arr[j + 1] = t; // move larger element right
                }
            }
        }
    }

    // linear search: check each element one by one until target is found
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i; // return index if found
        }
        return -1; // return -1 if not found
    }

    // binary search: efficient search on sorted array by dividing search space in half
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1; // define search boundaries

        while (left <= right) {
            int mid = (left + right) / 2; // find middle index

            if (arr[mid] == target) return mid; // return index if found

            if (arr[mid] < target) left = mid + 1; // search right half if target is larger
            else right = mid - 1; // search left half if target is smaller
        }
        return -1; // return -1 if not found
    }

    // helper method to print array contents in readable format
    public static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]); // print element
            if (i < arr.length - 1) {
                System.out.print(", "); // add comma between elements
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        Random random = new Random(); // create random object
        int[] arr = new int[10]; // create an array of 10 integers

        // fill the array with random numbers between 1 and 100
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100) + 1;
        }

        System.out.print("Original: ");
        print(arr); // print unsorted array
        bubbleSort(arr); // sort array using bubble sort
        System.out.print("Sorted: ");
        print(arr); // print sorted array

        Scanner sc = new Scanner(System.in); // create scanner for user input
        System.out.print("Search value: "); // ask user for value to search
        int target = sc.nextInt(); // read target value

        // perform both searches and print results
        System.out.println("Linear search index: " + linearSearch(arr, target));
        System.out.println("Binary search index: " + binarySearch(arr, target));

        sc.close();
    }
}
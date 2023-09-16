package sort;
// Optimized java implementation of Bubble sort
// https://www.geeksforgeeks.org/bubble-sort/
import java.io.*;

public class BubbleSort {

    // An optimized version of Bubble Sort
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {

                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // If no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    public static void sort(int[] array) {
        bubbleSort(array, array.length);
    }
}

// This code is contributed
// by Nikita Tiwari.

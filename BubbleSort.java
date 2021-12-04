/**
 * Bubble Sort algorithm
 * This sorting technique moves the largest value to the right at each iteration
 * No extra space is required since this uses swapping the values within the array itself
 * Time Complexity - O(n2)
 * Space Complexity - O(n)
 */

import java.util.*;

class BubbleSort {

    public static void main(String[] args) {

        String str[] = {"C", "D", "A", "B","C"};
        sort(str);
        System.out.println(Arrays.toString(str));

        String str1[] = {"C", "D", "A", "B","C"};
        improvedSort_1(str1);
        System.out.println(Arrays.toString(str1));

        String str2[] = {"C", "D", "A", "B","C"};
        improvedSort_2(str2);
        System.out.println(Arrays.toString(str2));
    }

    /** 
     * Compate adjcent elements and move the grater element to right
     * Moves the max element to the rightmost eligible position in each iteration
     */
    public static void sort(String[] values) {
        //iterate through array
        for(int i=0; i<values.length; i++) {
            for(int j=0; j<values.length - 1; j++) { 
                if(values[j].compareTo(values[j+1]) > 0) {
                    String temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }
    }

    public static void improvedSort_1(String[] values) {
        //iterate through array
        for(int i=0; i<values.length; i++) {
            //use a swapped variable to update swap status
            //if no swap is taken place it means array is sorted, we can exit the loop
            boolean swapped = false;
            for(int j=0; j<values.length - 1 - i; j++) {
                if(values[j].compareTo(values[j+1]) > 0) {
                    String temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    /** 
     * since the max value is move to rightmost eligible position, 
     * it is possible to ignore max element from right in the next iteration
     */
    public static void improvedSort_2(String[] values) {
        //iterate through array
        for(int i=0; i<values.length; i++) {
            //use a swapped variable to update swap status
            //if no swap has taken place it means array is sorted, then exit the loop
            boolean swapped = false;
            for(int j=0; j<values.length - 1; j++) {
                if(values[j].compareTo(values[j+1]) > 0) {
                    String temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

}
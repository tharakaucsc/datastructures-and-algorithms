import java.util.*;

/**
 * Insertion sort works using a sorted sub array at the left side within the same array
 * For each element in array, it compares adjacent values to identify the small element and keep/move it to left side
 * Then for each such swap/keep it compares the current element with adjecent elements in sorted array and do the swap if requires
 * This way smaller values always moves to the left side of the array
 */
public class InsertionSort {

    public static void main(String[] args) {

        String[] strArray = {"E", "I", "H", "A", "B","E", "D", "C", "A", "B"};
        improvedSort_1(strArray);
        System.out.println(Arrays.toString(strArray));

    }

    /**
     * Outer loop swaps elements in unsorted part of the array (compares element to the right of the current element)
     * Inner loop swaps the elements in sorted sub array (compares elements to the left of the current element)
     */
    public static void sort(String[] values) {
        for(int i=0; i<values.length - 1; i++) {
            if(values[i+1].compareTo(values[i]) < 0) {
                String tempVal = values[i];
                values[i] = values[i+1];
                values[i+1] = tempVal;
            }
            for(int j=i; j>0; j--) {
                if(values[j].compareTo(values[j-1]) < 0) {
                    String tempVal = values[j];
                    values[j] = values[j-1];
                    values[j-1] = tempVal;
                }
            }
        }
    }

    /**
     * Improvement can be done by introducing checks in 2 places
     * RUn inner loop for sorted sub array only if values are swapped in outer loop
     * breaking from inner loop if no swap has taken place
     */
    public static void improvedSort_1(String[] values) {
        for(int i=0; i<values.length - 1; i++) {
            boolean isSwappedOuter = false;
            if(values[i+1].compareTo(values[i]) < 0) {
                String tempVal = values[i];
                values[i] = values[i+1];
                values[i+1] = tempVal;
                isSwappedOuter = true;
            }
            if(isSwappedOuter) {
                for(int j=i; j>0; j--) {
                    boolean isSwappedInner = false;
                    if(values[j].compareTo(values[j-1]) < 0) {
                        String tempVal = values[j];
                        values[j] = values[j-1];
                        values[j-1] = tempVal;
                        isSwappedInner = true;
                    }
                    if(!isSwappedInner) {
                        break;
                    }
                }
            }
        }
    }
}
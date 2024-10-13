package HoganRules;

import java.util.Arrays;

/**
 * This class has code for the rule EXP02 (Do not use the Object.equals() method
 * to compare two arrays).
 * This code shows an example of using the Arrays.equals method to compare
 * arrays instead of the Object.equals method. The Arrays.equals method compares
 * the elements in the arrays while the Object.equals method compares the
 * references of the arrays.
 */
public class EXP02 {

    public static void main(String[] args) {

        int[] arr1 = new int[5]; // Initialized to 0
        int[] arr2 = new int[5]; // Initialized to 0
        int[] arr3 = { 1, 2, 3, 4 };
        int[] arr4 = { 1, 2, 3, 4 };
        System.out.println(Arrays.equals(arr1, arr2)); // Should print true because its comparing the elements in each
                                                       // array. Each array has 0 as each of its elements.
        System.out.println(Arrays.equals(arr3, arr4)); // Prints true because both arrays have the same values.
        System.out.println(arr1.equals(arr2)); // Prints false as intended. The arrays are not pointing to the same
                                               // object reference.
        System.out.println(arr1 == arr2);
    }
}

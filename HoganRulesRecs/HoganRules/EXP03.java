package HoganRules;

/**
 * This class has code for the rule EXP03 (Do not use the equality operators
 * when comparing values of boxed primitives).
 * This code compares boxed primitives using the equals method and == operator.
 * It shows that the == does not compare the values of the boxed primitives,
 * rather it compares their references, which are different.
 * The equals method compares the actual values of the boxed primitives.
 */
public class EXP03 {
    public static void main(String[] args) {
        Integer i1 = 130;
        Integer i2 = 130;
        Double i3 = 12.5;
        Double i4 = 12.5;
        Double i5 = 15.5;
        System.out.println(i1.equals(i2)); // This should print true because i1 and i2 have the same value.
        System.out.println(i1 == i2); // This should print false because 130 is outside the integer value range (-128
                                      // to 127) and i1 and i2 are not pointing to the same reference
        System.out.println(i3.equals(i4)); // True
        System.out.println(i3 == i4); // False
        System.out.println(i4.equals(i5)); // False because i4 and i5 do not have equal values
    }
}

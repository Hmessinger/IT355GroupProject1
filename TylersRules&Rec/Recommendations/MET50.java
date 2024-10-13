package Recommendations;

public class MET50 {
    //instead of confusing overloading, we have a method
    //for each case
    
    public void printInteger(int number) {
        System.out.println("Integer: " + number);
    }

    public void printDouble(double number) {
        System.out.println("Double: " + number);
    }

    public void printString(String text) {
        System.out.println("String: " + text);
    }
}

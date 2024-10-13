package Rules;

public class NUM11 {
    /*
     * Correctly demonstrates an alternative method of comparing floating
     * point numbers without converting them to strings.
     */
    public boolean compareFloats(double a, double b, double epsilon){
        return Math.abs(a - b) < epsilon;
    }
}

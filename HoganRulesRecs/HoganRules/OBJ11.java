package HoganRules;

/**
 * This class has code for the rule OBJ11-J (Be wary of letting constructors
 * throw exceptions.)
 * This code validates the input parameters for the constructor before the
 * constructor is actually called. If the values are invalid then an error
 * message wil be displayed and the constructor will not be called. Validating
 * the parameters before they are used prevents the constructor from throwing an
 * exception and creating a partially initialized object.
 */
public class OBJ11 {

    private static String year;
    private static double gpa;

    // Private constructor that can't called unless the input values are validated
    // and won't cause the constructor to throw an exception.
    private OBJ11(String year, double gpa) {
        this.year = year;
        this.gpa = gpa;
    }

    // Method that validates the inputs being used to create an OBJ11 object. This
    // ensures that the constructor doesn't throw an exception.
    public static OBJ11 createOBJ11(String year, double gpa) {
        if (year == null || year.isEmpty()) {
            System.out.println(
                    "The year input is invalid so OBJ11 creation is unsuccessful. The year cannot be null or an empty string.");
            return null;
        }
        if (!(gpa > 0.0 && gpa < 4.0)) {
            System.out.println(
                    "The year gpa is invalid so OBJ11 creation is unsuccessful. The gpa needs to be a double value between 0.0 and 4.0.");
            return null;
        }
        return new OBJ11(year, gpa);
    }

    // Main would be in a different main file so it would not be able to access the
    // private constructor. We will treat it that way for example purposes.
    public static void main(String[] args) {
        OBJ11 ob1 = OBJ11.createOBJ11("Senior", 3.8);
        if (ob1 != null) {
            System.out.println("OBJ11 created successfully.");
        }
        OBJ11 ob2 = OBJ11.createOBJ11("", 2.6);
        if (ob2 != null) {
            System.out.println("OBJ11 created successfully.");
        }
    }
}

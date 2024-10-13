package HoganRecommendations;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has code for the recommendation MET55 (Return an empty array or
 * collection instead of a null value for the methods that return an array or
 * collection).
 * The getRoster method will add a member to the roster if the roster size is
 * greater than or equal to 1. The method will then return the roster even if
 * the size of the roster is 0. This is an example of returning an empty list
 * rather than returning null.
 */
public class MET55 {

    // This method returns the roster, and if the roster size is greater than 1,
    // then a member gets added to the roster. The roster will still get returned
    // even if it is empty.
    private static List<String> getRoster(List<String> roster) {
        if (roster.size() >= 1) {
            roster.add("Tom P.");
        }
        return roster; // Possibly returns an empty arraylist.
    }

    public static void main(String[] args) {
        List<String> roster1 = new ArrayList<String>();
        List<String> roster2 = new ArrayList<String>();

        roster1.add("Sam H.");

        System.out.println("Roster1 size: " + getRoster(roster1).size());
        System.out.println("Roster2 size: " + getRoster(roster2).size()); // Roster2 is empty and its size should be 0.
    }
}

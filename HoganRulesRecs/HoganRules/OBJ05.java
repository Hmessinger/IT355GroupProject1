package HoganRules;

import java.util.ArrayList;
import java.util.List;

/**
 * This class has code for the rule OBJ05-J (Do not return references to private
 * mutable class members.)
 * This class has a private mutable List named studentNum. In the getStudentNum
 * method, instead of returning studentNum, we create a copy of it to be
 * returned. This prevents the studentNum from being modified in the main code.
 */
public class OBJ05 {

    private List<Integer> studentNum;

    public OBJ05() {
        studentNum = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            studentNum.add(i);
        }
    }

    // Rather than returning the private mutable studentNum List, we create a copy
    // of it and return the copy.
    public List<Integer> getStudentNum() {
        return new ArrayList<>(studentNum);
    }

    public static void main(String[] args) {
        OBJ05 object = new OBJ05();

        List<Integer> numStudents = object.getStudentNum();
        numStudents.add(10);

        System.out.println(numStudents);
        System.out.println(object.studentNum); // The mutable studentNum List should be unchanged because the
                                               // getStudentNum method returns a copy of it.
    }

}

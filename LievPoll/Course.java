package LievPoll;
import java.util.*;

/**
 * This standard class instantiate Object Course
 * @author Huijun Hu
 * @version 1.0
 */

public class Course {
    private final int courseID;
    private final int studentNum;
    private List<Student> studentList;

    public Course(int courseID, int studentNum){
        this.courseID = courseID;
        this.studentNum = studentNum;
        studentList = = new ArrayList<>();
        for (int i=0; i<studentNum; i++){
            this.studentList.add(new Student());
        }
    }

    public List<Student> getStudentList(){
        return studentList;
    }
}

import java.util.*;

public class Course {
    private int courseID;
    private int studentNum;
    private List<Student> studentList = new ArrayList<>();


    public Course(int courseID, int studentNum){
        this.courseID = courseID;
        this.studentNum = studentNum;
        for (int i=0; i<studentNum; i++){
            this.studentList.add(new Student());
        }
    }

    public List<Student> getStudentList(){
        return studentList;
    }
}

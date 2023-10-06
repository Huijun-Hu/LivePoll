import java.lang.Math;

/**
 * This standard class instantiate Object Student
 * @author Huijun Hu
 * @version 1.0
 */

public class Student {
    private final int studentID;

    public Student(){
        this.studentID = (int)(Math.random()*100000000);
    }

    int getStudentID(){
        return this.studentID;
    }

    void submitAnswer(VotingService vs){
        vs.answer(this);
    }
}

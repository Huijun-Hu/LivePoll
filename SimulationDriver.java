import java.util.*;

/**
 * This standard class automatically simulate the whole Live Poll process
 * @author Huijun Hu
 */

public class SimulationDriver {
    public static void main(String[] args) {
        int questionType1 = 1;
        int questionType2 = 0;
        int questionType3 = 0;
        int studentNum;

        String[] a1 = { "A" , "B" , "C" , "D" , "E" };
        String[] a2 = { "1. Right" , "2. Wrong" };
        String[] a3 = { "2", "4/5" , "11" , "5.13" };

        VotingService poll1 = new VotingService(questionType1, a1);
        VotingService poll2 = new VotingService(questionType2, a2);
        VotingService poll3 = new VotingService(questionType3, a3);

        studentNum= (int)(Math.random()*100) + 30;
        Course cs3560 = new Course(3560, studentNum);
        studentNum= (int)(Math.random()*100) + 30;
        Course cs4750 = new Course(4750, studentNum);
        studentNum= (int)(Math.random()*100) + 30;
        Course cs4080 = new Course(4080, studentNum);

        Iterator<Student> studentIn3560 = cs3560.getStudentList().iterator();
        Iterator<Student> studentIn4750 = cs4750.getStudentList().iterator();
        Iterator<Student> studentIn4080 = cs4080.getStudentList().iterator();

        // Test Multiple Choice Question Poll
        while(studentIn3560.hasNext()){
            studentIn3560.next().submitAnswer(poll1);
        }
        System.out.println("\n---[CS3560]Live Poll---");
        poll1.output();
        System.out.println("-----------------------");

        // Test Single Choice Question Poll
        while(studentIn4750.hasNext()){
            studentIn4750.next().submitAnswer(poll2);
        }
        System.out.println("\n---[CS4750]Live Poll---");
        poll2.output();
        System.out.println("-----------------------");

        
        while(studentIn4080.hasNext()){
            Student s = studentIn4080.next();

            // imitate the situation that student has multiple submission
            // statistics only show the last submission of every student
            // therefore total input count will still equal to # of students
            s.submitAnswer(poll3);
            s.submitAnswer(poll3);
            
        }

        System.out.println("\n---[CS4080]Live Poll---");
        poll3.output();
        System.out.println("-----------------------");
    }
}

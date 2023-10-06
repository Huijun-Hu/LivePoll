package LievPoll;
import java.util.*;

/**
 * This standard class instantiate Object VotingService which contains vary functionality to implement a Live Poll
 * @author Huijun Hu
 * @version 1.0
 */

public class VotingService{

    private final Question question;
    private int correctAnswer;
    private Dictionary<Student,Set<Integer>> StudentEntry;
    private Dictionary<Integer,Integer> statistics;   

    public VotingService(int questionType, String[] answers){
        StudentEntry = new Hashtable<>();
        statistics = new Hashtable<>();
        
        if (questionType==0){
            question = new SingleChoiceQuestion(answers);
        }else{
            question = new MultipleChoiceQuestion(answers);
        }
        for (int i = 0; i<answers.length; i++){
            statistics.put(i,0);
        }   
    }

    // imitate student answering the question by simulate random answer
    void answer(Student s){
        StudentEntry.put(s, this.question.possibleAnswer());
    }

    public void output(){

        System.out.printf("Poll Result of %d students\n", StudentEntry.size());
        Set<Integer> oneAnswerEntrySet;
        correctAnswer = 0;
        int entry = -1;
        double correctPercent = 0.00;
        Enumeration<Set<Integer>> allStudentEntry = StudentEntry.elements();
        while(allStudentEntry.hasMoreElements()){
            oneAnswerEntrySet = allStudentEntry.nextElement();

            // check if answer correct
            if(oneAnswerEntrySet.containsAll(this.question.getAnswer())){
                correctAnswer++;
            }
            
            // record answer entry
            Iterator<Integer> itr = oneAnswerEntrySet.iterator();
            while(itr.hasNext()){
                entry = itr.next();
                statistics.put(entry,statistics.get(entry)+1);
            }
        }

        for (int i = 0; i<statistics.size(); i++){
            System.out.printf("\n%s : %d",this.question.getCandidateAnswersPrompt().get(i), statistics.get(i));
            
        }   
        System.out.printf("\nCorrect entry number: %d", this.correctAnswer);
        correctPercent = (double)correctAnswer/StudentEntry.size() *100;
        System.out.printf("\nCorrect percentage: %.2f %%\n", correctPercent);     
    }

}

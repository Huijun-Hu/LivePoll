package LievPoll;
import java.util.*;

/**
 * This abstract class instantiate Object Question
 * @author Huijun Hu
 * @version 1.0
 */

abstract class Question {
    protected final List<String> candidateAnswersPrompt;
    protected List<Integer> candidateAnswers;
    protected Set<Integer> answer;

    public Question(String[] ans){
        candidateAnswersPrompt = new ArrayList<>();
        candidateAnswers = new ArrayList<>();
        for (int i = 0; i < ans.length; i++){
            this.candidateAnswersPrompt.add(ans[i]);
            this.candidateAnswers.add(i);
        }
        setAnswer();
    }

    public List<String> getCandidateAnswersPrompt(){
        return candidateAnswersPrompt;
    }

    abstract void setAnswer();
    abstract Set<Integer> getAnswer();
    abstract Set<Integer> possibleAnswer();
    
}

import java.util.*;

abstract class Question {
    protected List<String> candidateAnswersPrompt = new ArrayList<>();
    protected List<Integer> candidateAnswers = new ArrayList<>();
    protected Set<Integer> answer;

    public Question(String[] ans){
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
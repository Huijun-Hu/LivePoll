import java.util.*;
class SingleChoiceQuestion extends Question{
    
    //private Set<Integer> answer;

    public SingleChoiceQuestion(String[] ans){
        super(ans);
    }
    
    void setAnswer(){
        Collections.shuffle(this.candidateAnswers);
        this.answer = new HashSet<>(this.candidateAnswers.subList(0, 1));
    }
    
    Set<Integer> getAnswer(){
        return this.answer;
    }

    Set<Integer> possibleAnswer(){
        Collections.shuffle(this.candidateAnswers);
        return new HashSet<>(this.candidateAnswers.subList(0, 1));
    }
}

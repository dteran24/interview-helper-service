package Questions.demo.exception;

public class QuestionDoesNotExist extends Exception{
    public QuestionDoesNotExist(){
        super();
    }
    public QuestionDoesNotExist(String message){
        super(message);
    }
}

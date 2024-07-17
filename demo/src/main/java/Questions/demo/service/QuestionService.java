package Questions.demo.service;

import Questions.demo.dto.QuestionDto;
import Questions.demo.entity.Question;
import Questions.demo.exception.QuestionDoesNotExist;

import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    Question createQuestion(String question, String answer, String type, List<String> tags, String difficulty);
    void deleteQuestion(int id) throws QuestionDoesNotExist;
    void updateQuestion(int id, QuestionDto questionDto) throws QuestionDoesNotExist;

}

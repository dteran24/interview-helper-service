package Questions.demo.service;

import Questions.demo.dto.QuestionDto;
import Questions.demo.entity.Question;
import Questions.demo.exception.QuestionDoesNotExist;
import Questions.demo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository){
        super();
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.getAllQuestionsWithTags();
    }

    @Override
    public Question createQuestion(String question, String answer, String type, List<String> tags, String difficulty) {
        Question newQuestion = new Question(question, answer, type, tags, difficulty);
        return questionRepository.save(newQuestion);
    }

    @Override
    public void deleteQuestion(int id) throws QuestionDoesNotExist {
        Question selectedQuestion = questionRepository.findById(id).orElseThrow(() -> new QuestionDoesNotExist("Question with id " + id + " does not exist"));
        questionRepository.deleteById(id);

    }

    public void updateQuestion(int id, QuestionDto questionDto) throws QuestionDoesNotExist {
        // Fetch the question or throw an exception if it does not exist
        Question originalQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new QuestionDoesNotExist("Question with id " + id + " does not exist"));

        // Update the question details
        updateQuestionDetails(originalQuestion, questionDto);

        // Save the updated question
        questionRepository.save(originalQuestion);
    }
    private void updateQuestionDetails(Question question, QuestionDto questionDto) {
        question.setQuestion(questionDto.getQuestion());
        question.setAnswer(questionDto.getAnswer());
        question.setDifficulty(questionDto.getDifficulty());
        question.setTags(questionDto.getTags());
    }

}

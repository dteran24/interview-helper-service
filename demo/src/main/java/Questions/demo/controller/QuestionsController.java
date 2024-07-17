package Questions.demo.controller;

import Questions.demo.dto.QuestionDto;
import Questions.demo.entity.Question;
import Questions.demo.exception.QuestionDoesNotExist;
import Questions.demo.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/questions")
public class QuestionsController {

    private final QuestionService questionService;
    @Autowired
    public QuestionsController(QuestionService questionService){
        super();
        this.questionService = questionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return ResponseEntity.ok(questionService.getAllQuestions());
    }
    @PostMapping("/add")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDto questionDto){
        return ResponseEntity.ok(questionService.createQuestion(questionDto.getQuestion(),questionDto.getAnswer(),questionDto.getType(),questionDto.getTags(),questionDto.getDifficulty()));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) throws QuestionDoesNotExist {
        try {
            questionService.deleteQuestion(id);
            return ResponseEntity.ok("Question deleted successfully");
            }
        catch (QuestionDoesNotExist ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable int id, @RequestBody QuestionDto questionDto) throws QuestionDoesNotExist {
        try{
            questionService.updateQuestion(id, questionDto);
            return ResponseEntity.ok("Question with id "+id+" has been updated");
        }catch (QuestionDoesNotExist ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }

    }
}

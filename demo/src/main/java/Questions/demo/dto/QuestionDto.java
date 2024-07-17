package Questions.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class QuestionDto {
    private String question;
    private String answer;
    private String type;
    private String difficulty;
    private List<String> tags;

}

package Questions.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_questions")
@Getter
@Setter
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue
    private int id;

    private String question;
    private String answer;
    private String type;
    @ElementCollection
    @CollectionTable(name = "question_tags", joinColumns = @JoinColumn(name = "question_id"))
    @Column(name = "tag")
    private List<String> tags = new ArrayList<>();
    private String difficulty;
    private String selected;

    public Question(String question, String answer, String type, List<String> tags, String difficulty){
        this.question =question;
        this.answer = answer;
        this.type = type;
        this.tags = tags;
        this.difficulty = difficulty;
        this.selected = "false";
    }

}

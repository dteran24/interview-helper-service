package Questions.demo.repository;

import Questions.demo.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    @Query(value = "SELECT user_questions.*, question_tags.*\n" +
            "FROM user_questions\n" +
            "INNER JOIN question_tags ON user_questions.id = question_tags.question_id;", nativeQuery = true)
    List<Question> getAllQuestionsWithTags();
}

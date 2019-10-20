package server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import server.models.Question;

import java.util.Set;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM challenges.QUESTION WHERE challenge_type_name = :type_name", nativeQuery = true)
    Set<Question> getQuestionsByChallengeTypeName(@Param("type_name") String typeName);

}

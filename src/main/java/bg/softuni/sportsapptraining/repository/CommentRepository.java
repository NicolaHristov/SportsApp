package bg.softuni.sportsapptraining.repository;

import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByDiscipline(Discipline discipline);

}

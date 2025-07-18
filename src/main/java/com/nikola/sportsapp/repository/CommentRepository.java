package com.nikola.sportsapp.repository;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByDiscipline(Discipline discipline);

}

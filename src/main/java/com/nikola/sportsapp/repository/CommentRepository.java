package com.nikola.sportsapp.repository;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query("SELECT c FROM Comment c JOIN FETCH c.user WHERE c.discipline.id = :disciplineId")
    List<Comment> findAllByDisciplineIdWithUser(@Param("disciplineId") Long disciplineId);

}

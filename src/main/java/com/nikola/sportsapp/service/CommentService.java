package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void addComment(String text, User user, Discipline discipline) {
        Comment comment = new Comment(text, user, discipline);
        commentRepository.save(comment);
    }

    public Comment save(Comment comment) {
        return this.commentRepository.save(comment);
    }

    public List<Comment> findByDiscipline(Discipline discipline) {
        return commentRepository.findByDiscipline(discipline);
    }
}

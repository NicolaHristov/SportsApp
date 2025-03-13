package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.Comment;
import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.model.User;
import bg.softuni.sportsapptraining.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {


    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public List<Comment> getCommentsForDiscipline(Discipline discipline) {
        return commentRepository.findByDiscipline(discipline);
    }

    public void addComment(String text, User user, Discipline discipline) {
        Comment comment = new Comment(text, user, discipline);
        commentRepository.save(comment);
    }

    public List<Comment> findAll() {
        return this.commentRepository.findAll();
    }

    public Comment save(Comment comment){
       return this.commentRepository.save(comment);
    }
}

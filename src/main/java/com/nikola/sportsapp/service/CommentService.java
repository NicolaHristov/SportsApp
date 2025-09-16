package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.model.dto.CommentDto;
import com.nikola.sportsapp.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.modelMapper = modelMapper;
    }

    public void addComment(String content, User user, Discipline discipline) {
        Comment comment = new Comment(content, user, discipline);
        commentRepository.save(comment);
    }


    public List<CommentDto> findAllByDiscipline(Long disciplineId) {
        return commentRepository.findAllByDisciplineIdWithUser(disciplineId)
                .stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }


    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}

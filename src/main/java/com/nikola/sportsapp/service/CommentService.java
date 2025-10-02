package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Comment;
import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.User;
import com.nikola.sportsapp.model.dto.CommentDto;
import com.nikola.sportsapp.repository.CommentRepository;
import com.nikola.sportsapp.repository.DisciplineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final DisciplineRepository disciplineRepository;
    private final ModelMapper modelMapper;

    public CommentService(CommentRepository commentRepository, DisciplineRepository disciplineRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.disciplineRepository = disciplineRepository;
        this.modelMapper = modelMapper;
    }


    public void addComment(String content, Long disciplineId, User user) {
        Discipline discipline = disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found with id: " + disciplineId));

        Comment comment = new Comment(content, user, discipline);
        commentRepository.save(comment);
    }

    public List<CommentDto> findAllByDiscipline(Long disciplineId) {
        return commentRepository.findAllByDisciplineIdWithUser(disciplineId)
                .stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }
}

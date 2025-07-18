package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import static com.nikola.sportsapp.constant.ExceptionMessages.DISCIPLINE_NOT_FOUND_BY_ID;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public Discipline getDisciplineById(Long disciplineId) {
        return disciplineRepository.findById(disciplineId)
                .orElseThrow(() -> new IllegalArgumentException(String.format(DISCIPLINE_NOT_FOUND_BY_ID, disciplineId)));
    }

}

package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.dto.DisciplineDto;
import com.nikola.sportsapp.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import static com.nikola.sportsapp.constant.ExceptionMessages.DISCIPLINE_NOT_FOUND_BY_ID;

@Service
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public DisciplineService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public DisciplineDto getDisciplineById(Long disciplineId) {
        Discipline discipline = disciplineRepository.findByIdWithSport(disciplineId)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(DISCIPLINE_NOT_FOUND_BY_ID, disciplineId)));

        return new DisciplineDto(
                discipline.getId(),
                discipline.getName(),
                discipline.getSport() != null ? discipline.getSport().getName() : null,
                discipline.getWorldRecordHolder(),
                discipline.getWorldRecordTime()
        );
    }

}

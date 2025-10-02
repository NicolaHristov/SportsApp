package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.dto.DisciplineDto;
import com.nikola.sportsapp.repository.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.nikola.sportsapp.constant.DisciplineConstants.Athletics.*;
import static com.nikola.sportsapp.constant.DisciplineConstants.Athletics.ATHLETICS_EIGHT_HUNDRED_METRES;
import static com.nikola.sportsapp.constant.DisciplineConstants.Athletics.ATHLETICS_FIFTEEN_HUNDRED_METRES;
import static com.nikola.sportsapp.constant.ImageUrlConstants.Athletics.*;
import static com.nikola.sportsapp.constant.ImageUrlConstants.Swimming.DEFAULT_URL;

@Service
@RequiredArgsConstructor
public class AthleticsService {

    private final DisciplineRepository disciplineRepository;
    private final ModelMapper modelMapper;

    public List<DisciplineDto> getAllDisciplineDtos() {
        return disciplineRepository.findAllBySportNameWithSport("Athletics")
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public DisciplineDto getDisciplineByName(String name) {
        Discipline discipline = disciplineRepository.findByNameWithSport(name);
        if (discipline == null) {
            throw new IllegalArgumentException("Discipline not found: " + name);
        }
        return mapToDto(discipline);
    }

    public DisciplineDto getDisciplineById(Long id) {
        Discipline discipline = disciplineRepository.findByIdWithSport(id)
                .orElseThrow(() -> new IllegalArgumentException("Discipline not found with id: " + id));
        return mapToDto(discipline);
    }

    private DisciplineDto mapToDto(Discipline discipline) {
        return new DisciplineDto(
                discipline.getId(),
                discipline.getName(),
                discipline.getSport() != null ? discipline.getSport().getName() : null,
                discipline.getWorldRecordHolder(),
                discipline.getWorldRecordTime()
        );
    }

    public Discipline updateDiscipline(Discipline discipline) {
        return disciplineRepository.save(discipline);
    }

    public String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case ATHLETICS_HUNDRED_METRES -> HUNDRED_METRES_URL;
            case ATHLETICS_TWO_HUNDRED_METRES -> TWO_HUNDRED_METRES_URL;
            case ATHLETICS_FOUR_HUNDRED_METRES -> FOUR_HUNDRED_METRES_URL;
            case ATHLETICS_EIGHT_HUNDRED_METRES -> EIGHT_HUNDRED_METRES_URL;
            case ATHLETICS_FIFTEEN_HUNDRED_METRES -> FIFTEEN_HUNDRED_METRES_URL;
            default -> DEFAULT_URL;
        };
    }
}



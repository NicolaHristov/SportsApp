package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.model.dto.DisciplineDto;
import com.nikola.sportsapp.repository.DisciplineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.nikola.sportsapp.constant.DisciplineConstants.Swimming.*;
import static com.nikola.sportsapp.constant.DisciplineConstants.Swimming.SWIMMING_BREASTSTROKE_100M;
import static com.nikola.sportsapp.constant.DisciplineConstants.Swimming.SWIMMING_BREASTSTROKE_200M;
import static com.nikola.sportsapp.constant.DisciplineConstants.Swimming.SWIMMING_BREASTSTROKE_50M;
import static com.nikola.sportsapp.constant.DisciplineConstants.Swimming.SWIMMING_FREESTYLE_400M;
import static com.nikola.sportsapp.constant.ExceptionMessages.DISCIPLINE_NOT_FOUND;
import static com.nikola.sportsapp.constant.ImageUrlConstants.Swimming.*;
import static com.nikola.sportsapp.constant.ImageUrlConstants.Swimming.DEFAULT_URL;

@Service
public class SwimmingService {

    private final DisciplineRepository disciplineRepository;
    private final ModelMapper modelMapper;

    public SwimmingService(DisciplineRepository disciplineRepository, ModelMapper modelMapper) {
        this.disciplineRepository = disciplineRepository;
        this.modelMapper = modelMapper;
    }

    public List<DisciplineDto> getAllDisciplineDtos() {
        return disciplineRepository.findAllBySportNameWithSport("Swimming")
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public DisciplineDto getDisciplineById(Long id) {
        Discipline discipline = disciplineRepository.findByIdWithSport(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(DISCIPLINE_NOT_FOUND, id)));

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

    public DisciplineDto getDisciplineByName(String name) {
        Discipline discipline = disciplineRepository.findByNameWithSport(name);
        if (discipline == null) {
            throw new IllegalArgumentException("Swimming discipline not found: " + name);
        }
        return modelMapper.map(discipline, DisciplineDto.class);
    }

    public String getChampionImageUrl(String discipline) {
        return switch (discipline) {
            case  SWIMMING_FREESTYLE_50M  -> FREESTYLE_50M_URL;
            case  SWIMMING_FREESTYLE_100M -> FREESTYLE_100M_URL;
            case  SWIMMING_FREESTYLE_200M ->
                    FREESTYLE_200M_URL;
            case  SWIMMING_FREESTYLE_400M->
                    FREESTYLE_400M_URL;
            case  SWIMMING_BREASTSTROKE_50M ->
                    BREASTSTROKE_50M_URL ;
            case  SWIMMING_BREASTSTROKE_100M ->
                    BREASTSTROKE_100M_URL;
            case SWIMMING_BREASTSTROKE_200M ->
                    BREASTSTROKE_200M_URL;
            default -> DEFAULT_URL;
        };
    }

}

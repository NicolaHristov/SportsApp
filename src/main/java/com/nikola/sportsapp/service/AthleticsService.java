package com.nikola.sportsapp.service;

import com.nikola.sportsapp.model.Discipline;
import com.nikola.sportsapp.repository.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.nikola.sportsapp.constant.DisciplineConstants.Athletics.*;
import static com.nikola.sportsapp.constant.DisciplineConstants.Athletics.ATHLETICS_EIGHT_HUNDRED_METRES;
import static com.nikola.sportsapp.constant.DisciplineConstants.Athletics.ATHLETICS_FIFTEEN_HUNDRED_METRES;
import static com.nikola.sportsapp.constant.ImageUrlConstants.Athletics.*;
import static com.nikola.sportsapp.constant.ImageUrlConstants.Swimming.DEFAULT_URL;

@Service
@RequiredArgsConstructor
public class AthleticsService {

    private final DisciplineRepository disciplineRepository;

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAllBySportName("Athletics");
    }

    public Discipline getDisciplineByName(String name) {
        return disciplineRepository.findByName(name);
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



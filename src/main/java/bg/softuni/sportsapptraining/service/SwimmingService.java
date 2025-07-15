package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Swimming.*;
import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Swimming.SWIMMING_BREASTSTROKE_100M;
import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Swimming.SWIMMING_BREASTSTROKE_200M;
import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Swimming.SWIMMING_BREASTSTROKE_50M;
import static bg.softuni.sportsapptraining.constant.DisciplineConstants.Swimming.SWIMMING_FREESTYLE_400M;
import static bg.softuni.sportsapptraining.constant.ExceptionMessages.DISCIPLINE_NOT_FOUND;
import static bg.softuni.sportsapptraining.constant.ImageUrlConstants.Swimming.*;
import static bg.softuni.sportsapptraining.constant.ImageUrlConstants.Swimming.DEFAULT_URL;

@Service
public class SwimmingService {

    private final DisciplineRepository disciplineRepository;

    public SwimmingService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }
    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAllBySportName("Swimming");
    }

    public Discipline getDisciplineByName(String name) {
        return disciplineRepository.findByName(name);
    }
    public Discipline getDisciplineById(Long id) {
        return disciplineRepository
                .findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format(DISCIPLINE_NOT_FOUND, id)));
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

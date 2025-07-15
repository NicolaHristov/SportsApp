package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static bg.softuni.sportsapptraining.constant.ExceptionMessages.DISCIPLINE_NOT_FOUND_BY_ID;

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

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

}

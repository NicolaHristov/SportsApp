package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.model.dto.AthleticsDto;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AthleticsService {

    private final DisciplineRepository disciplineRepository;

    public AthleticsService(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    public List<Discipline> getAllDisciplines() {
        return disciplineRepository.findAll();
    }

    public Discipline getDisciplineByName(String name) {
        return disciplineRepository.findByName(name);
        // findByName is a method you define in your repository interface
    }

    public Discipline updateDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }
}



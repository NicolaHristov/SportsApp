package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
                        new IllegalArgumentException("Discipline with id " + id + " not found"));
    }
}

package bg.softuni.sportsapptraining.service;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Discipline updateDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }
}



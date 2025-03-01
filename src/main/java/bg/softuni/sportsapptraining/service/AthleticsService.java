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

    public List<AthleticsDto> getAllDisciplines() {
        return List.of(
                new AthleticsDto("100 метра", "Фред Кърли", "9.58 сек (Юсейн Болт)",
                        "https://res.cloudinary.com/demo/image/upload/v1610000000/sprint_champion.jpg"),
                new AthleticsDto("200 метра", "Ноа Лайлс", "19.19 сек (Юсейн Болт)",
                        "https://res.cloudinary.com/demo/image/upload/v1610000000/200m_champion.jpg")
        );
    }

//    public List<Discipline> getAllDisciplines() {
//        return disciplineRepository.findAll();
//    }

    public Discipline getDisciplineByName(String name) {
        return disciplineRepository.findByName(name);
        // findByName is a method you define in your repository interface
    }

    public Discipline updateDiscipline(Discipline discipline){
        return disciplineRepository.save(discipline);
    }
}
//    public List<AthleticsDto> getAllDisciplines() {
//        return List.of(
//                new AthleticsDto("100 метра", "Фред Кърли", "9.58 сек (Юсейн Болт)"),
//                new AthleticsDto("200 метра", "Ноа Лайлс", "19.19 сек (Юсейн Болт)"),
//                new AthleticsDto("400 метра", "Майкъл Норман", "43.03 сек (Уейд ван Нийкерк)")
//        );
//    }
//
//    public AthleticsDto getDisciplineByName(String name) {
//        return getAllDisciplines().stream()
//                .filter(d -> d.getDiscipline().equalsIgnoreCase(name))
//                .findFirst()
//                .orElse(null);
//    }


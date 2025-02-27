package bg.softuni.sportsapptraining.config;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DisciplineRepository disciplineRepository;

    public DataSeeder(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public void run(String... args) {
        if (disciplineRepository.count() == 0) {
            disciplineRepository.save(new Discipline("100 метра", "Фред Кърли", "9.58 сек (Юсейн Болт)"));
            disciplineRepository.save(new Discipline("200 метра", "Ноа Лайлс", "19.19 сек (Юсейн Болт)"));
        }
    }
}

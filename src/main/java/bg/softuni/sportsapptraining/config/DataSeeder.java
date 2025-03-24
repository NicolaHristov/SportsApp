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
        seedDiscipline("100 metres", "Fred Kerley", "9.58 (Usain Bolt)");
        seedDiscipline("200 metres", "Noah Lyles", "19.19 (Usain Bolt)");
        seedDiscipline("400 metres", "Michael Norman", "43.03 (Wayde van Niekerk)");
        seedDiscipline("800 metres", "Emmanuel Korir", "1:40.91 (David Rudisha)");
        seedDiscipline("1500 metres", "Jakob Ingebrigtsen", "3:26.00 (Hicham El Guerrouj)");
    }

    private void seedDiscipline(String name, String champion, String record) {
        if (!disciplineRepository.existsByName(name)) {
            disciplineRepository.save(new Discipline(name, champion, record));
        }
    }

}

package bg.softuni.sportsapptraining.config;

import bg.softuni.sportsapptraining.model.Discipline;
import bg.softuni.sportsapptraining.model.Sport;
import bg.softuni.sportsapptraining.repository.DisciplineRepository;
import bg.softuni.sportsapptraining.repository.SportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final DisciplineRepository disciplineRepository;
    private final SportRepository sportRepository;

    public DataSeeder(DisciplineRepository disciplineRepository, SportRepository sportRepository) {
        this.disciplineRepository = disciplineRepository;
        this.sportRepository = sportRepository;
    }

    @Override
    public void run(String... args) {
        disciplineRepository.deleteAll();
        sportRepository.deleteAll();

        Sport athletics = new Sport("Athletics");
        Sport swimming = new Sport("Swimming");

        sportRepository.save(athletics);
        sportRepository.save(swimming);

        seedDiscipline("100 metres", "Fred Kerley", "9.58 (Usain Bolt)",athletics);
        seedDiscipline("200 metres", "Noah Lyles", "19.19 (Usain Bolt)",athletics);
        seedDiscipline("400 metres", "Aleksander Doom", "43.03 (Wayde van Niekerk)",athletics);
        seedDiscipline("800 metres", "Marco Arop", "1:40.91 (David Rudisha)",athletics);
        seedDiscipline("1500 metres", "Joshua Kerr", "3:26.00 (Hicham El Guerrouj)",athletics);

        seedDiscipline("50m freestyle", "Ben Proud", "20.91 (Cesar Cielo)", swimming);
        seedDiscipline("100m freestyle", "David Popovici", "46.40 (Pan Zha Le)", swimming);
        seedDiscipline("200m freestyle", "Hwang Sun-woo", "1:42.00 (Paul Biedermann)", swimming);
        seedDiscipline("400m freestyle", "Ahmed Hafnaoui", "3:40.00 (Paul Biedermann)", swimming);
        seedDiscipline("50m breaststroke", "Nicolo Martinenghi", "25.95 (Adam Peaty)", swimming);
        seedDiscipline("100m breaststroke", "Adam Peaty", "56.88 (Adam Peaty)", swimming);
        seedDiscipline("200m breaststroke", "Dong Zhihao", "2:05.48 (Qin Haiyang )", swimming);


    }

    private void seedDiscipline(String name, String champion, String record, Sport sport) {
        if (!disciplineRepository.existsByName(name)) {

            Discipline discipline = new Discipline(name, champion, record);
            discipline.setSport(sport);
            disciplineRepository.save(discipline);
        }
    }

}

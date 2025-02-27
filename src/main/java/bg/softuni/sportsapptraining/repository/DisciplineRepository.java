package bg.softuni.sportsapptraining.repository;

import bg.softuni.sportsapptraining.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline,Long> {
    Discipline findByName(String name);
}

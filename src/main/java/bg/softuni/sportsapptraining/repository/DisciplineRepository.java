package bg.softuni.sportsapptraining.repository;

import bg.softuni.sportsapptraining.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,Long> {
    Discipline findByName(String name);

    Optional<Discipline> findById(Long id);
    boolean existsByName(String name);
    List<Discipline> findAllBySportName(String name);
}

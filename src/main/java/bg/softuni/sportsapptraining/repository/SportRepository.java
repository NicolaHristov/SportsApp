package bg.softuni.sportsapptraining.repository;

import bg.softuni.sportsapptraining.model.Sport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportRepository extends JpaRepository<Sport,Long> {
}

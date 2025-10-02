package com.nikola.sportsapp.repository;

import com.nikola.sportsapp.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,Long> {

    Discipline findByName(String name);

    List<Discipline> findAllBySportName(String name);

    @Query("SELECT d FROM Discipline d JOIN FETCH d.sport WHERE d.sport.name = :sportName")
    List<Discipline> findAllBySportNameWithSport(@Param("sportName") String sportName);

    @Query("SELECT d FROM Discipline d JOIN FETCH d.sport WHERE d.name = :name")
    Discipline findByNameWithSport(@Param("name") String name);

    @Query("SELECT d FROM Discipline d JOIN FETCH d.sport WHERE d.id = :id")
    Optional<Discipline> findByIdWithSport(@Param("id") Long id);

}

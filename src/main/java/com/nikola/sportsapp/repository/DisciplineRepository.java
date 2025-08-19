package com.nikola.sportsapp.repository;

import com.nikola.sportsapp.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplineRepository extends JpaRepository<Discipline,Long> {

    Discipline findByName(String name);

    List<Discipline> findAllBySportName(String name);

}

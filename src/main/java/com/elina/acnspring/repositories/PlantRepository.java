package com.elina.acnspring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elina.acnspring.model.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

}

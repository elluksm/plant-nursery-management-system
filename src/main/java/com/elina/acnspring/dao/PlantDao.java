package com.elina.acnspring.dao;

import java.util.List;

import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantType;

public interface PlantDao {
    void removePlant(Plant p);
    void addPlant(Plant p);

    void changeAmount(Plant p, int newAmount);

    Plant findPlantById(Long id);
    List<Plant> getPlants();
    List<Plant> getPlantsByType(PlantType type);

}

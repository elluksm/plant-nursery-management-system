package com.elina.acnspring.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elina.acnspring.dao.PlantDao;
import com.elina.acnspring.dao.PlantRegistry;
import com.elina.acnspring.repositories.PlantRepository;

import java.util.List;

@Component
public class PlantNursery implements PlantDao {

    private String name;

    @Autowired
    private PlantRegistry plantRegistry;
	@Autowired
	PlantRepository plantRepository;

    public PlantNursery() {
        this.name = "Plant Nursery";
    }
    public PlantNursery(String name) {
        this();
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Plant> getPlants() {
        return plantRegistry.getPlants();
    }

    public void removePlant(Plant plant) {
        this.plantRegistry.removePlant(plant);
    }

    public void addPlant(Plant plant) {
        this.plantRegistry.addPlant(plant);
    }

    public void changeAmount(Plant plant, int newAmount) {
        this.plantRegistry.changeAmount(plant, newAmount);
    }

    public Plant findPlantById(Long id){
        return this.plantRegistry.findPlantById(id);
    };

    public List<Plant> getPlantsByType(PlantType type) {
        return this.plantRegistry.getPlantsByType(type);
    }

}

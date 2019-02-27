package com.elina.acnspring;

import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantNursery;
import com.elina.acnspring.model.PlantType;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantNursery plantNursery;

    public PlantNursery getPlantNursery() {
        return plantNursery;
    }

    public Plant findPlantById(Long id) {
        return plantNursery.findPlantById(id);
    }

    public List<Plant> getPlants(PlantType type) {
        if (type == null) {
            return plantNursery.getPlants();
        }
        return plantNursery.getPlantsByType(type);
    }

    public void addPlant(String title, int amount, PlantType type, String description) {
        if (title == null) {
            return;
        }
        Plant newPlant = new Plant(title, amount, type, description);
        plantNursery.addPlant(newPlant);
    }

    public void removePlant(Long id) {
        Plant p = plantNursery.findPlantById(id);
        plantNursery.removePlant(p);
    }

    public void changeAmount(Long id, int newAmount) {
        Plant p = plantNursery.findPlantById(id);
        plantNursery.changeAmount(p, newAmount);
    }

}

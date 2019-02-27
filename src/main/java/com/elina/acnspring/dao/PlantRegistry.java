package com.elina.acnspring.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantType;
import com.elina.acnspring.repositories.PlantRepository;

import java.util.Optional;

@Component
public class PlantRegistry {
	
	@Autowired
	PlantRepository plantRepository;
	
	public PlantRegistry(){
	}
    
    public List<Plant> getPlants() {
        return this.plantRepository.findAll();
    }
    
    public void removePlant(Plant p){
        if (p == null) {
            return;
        }
        this.plantRepository.delete(p);
    }

    public void addPlant(Plant p) {
        this.plantRepository.save(p);
    }

    public void changeAmount(Plant p, int newAmount) {
    	p.setAmount(newAmount);
    	this.plantRepository.save(p);
    }

    public Plant findPlantById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<Plant> p = this.plantRepository.findById(id);
        if (p.isPresent())
        	return p.get();
        else return null;        
    }

    public List<Plant> getPlantsByType(PlantType type) {
        return this.getPlants().stream()
                .filter(plant -> plant.getType() ==  type)
                .collect(Collectors.toList());
    }

}

package plantnursery.model;

import plantnursery.dao.PlantRegistry;
import plantnursery.dao.PlantDao;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PlantNursery implements PlantDao {

    private String name;

    private PlantRegistry plantRegistry;

    public PlantNursery() {
        this.name = "Plant Nursery";
        this.plantRegistry = new PlantRegistry();
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

    public Plant findPlantByTitle(String plantTitle){
        return this.plantRegistry.findPlantByTitle(plantTitle);
    };

    public List<Plant> getPlantsByType(PlantType type) {
        return this.plantRegistry.getPlantsByType(type);
    }



}

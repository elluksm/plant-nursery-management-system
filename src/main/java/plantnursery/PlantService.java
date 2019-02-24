package plantnursery;

import plantnursery.model.PlantNursery;
import plantnursery.model.Plant;
import plantnursery.model.PlantType;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PlantService {

    @Autowired
    private PlantNursery plantNursery;

    @PostConstruct
    public void init() {
        plantNursery.setName("Test Drive Library");
        plantNursery.addPlant(new Plant("War and Peace", 5, PlantType.FLOWER));
        plantNursery.addPlant(new Plant("Great Expectations", 8, PlantType.VEGERTABLE));
    }

    public PlantNursery getPlantNursery() {
        return plantNursery;
    }

    public Plant findPlantByTitle(String title) {
        return plantNursery.findPlantByTitle(title);
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
        Plant newPlant = (description == null || description.isEmpty()) ? new Plant(title, amount, type ) : new Plant(title, amount, type, description);
        plantNursery.addPlant(newPlant);
    }

    public void removePlant(String title) {
        Plant p = plantNursery.findPlantByTitle(title);
        plantNursery.removePlant(p);
    }

    public void changeAmount(String title, int newAmount) {
        Plant p = plantNursery.findPlantByTitle(title);
        plantNursery.changeAmount(p, newAmount);
    }

}



package plantnursery.dao;

import plantnursery.model.Plant;
import plantnursery.model.PlantType;

import java.util.List;

public interface PlantDao {
    void removePlant(Plant p);
    void addPlant(Plant p);

    void changeAmount(Plant p, int newAmount);

    Plant findPlantByTitle(String plantTitle);
    List<Plant> getPlants();
    List<Plant> getPlantsByType(PlantType type);

}

package plantnursery.dao;

import plantnursery.model.Plant;
import plantnursery.model.PlantType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Objects;

public class PlantRegistry implements PlantDao {

    private List<Plant> plants = new ArrayList<>();

    public void removePlant(Plant p){
        if (p == null) {
            return;
        }
        this.plants.remove(p);
    };

    public void addPlant(Plant p) {
        this.plants.add(p);
    };

    public void changeAmount(Plant p, int newAmount) {
        p.setAmount(newAmount);
    };

    public Plant findPlantByTitle(String plantTitle) {
        if (plantTitle == null) {
            return null;
        }
        return plants.stream()
                .filter(b -> Objects.equals(b.getTitle().toLowerCase(), plantTitle.toLowerCase()))
                .findFirst()
                .orElse(null);
    }

    public List<Plant> getPlants() {
        return plants;
    };
    public List<Plant> getPlantsByType(PlantType type) {
        return this.getPlants().stream()
                .filter(plant -> plant.getType() ==  type)
                .collect(Collectors.toList());
    };

}

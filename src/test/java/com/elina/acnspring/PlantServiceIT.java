package com.elina.acnspring;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AcnSpringApplication.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlantServiceIT {

    @Autowired
    PlantService plantService;

    private static final List<Plant> expectedAllPlants = new ArrayList<>();
    private static final List<Plant> expectedVegetables = new ArrayList<>();
    private static final List<Plant> expectedFlowers = new ArrayList<>();
    private static final List<Plant> expectedHerbs = new ArrayList<>();


    @BeforeClass
    public static void setUp(){

    	Plant herb = new Plant(10001l, "Cinnamon basil", 20, PlantType.HERB, "has a spicy, fragrant aroma and flavor.");
    	Plant vegetable = new Plant(10002l, "Cherry tomato", 15, PlantType.VEGETABLE, "with small yellow fruits");
    	Plant flower = new Plant(10003l, "Petunia axillaris", 3, PlantType.FLOWER, "large white petunia");
    	Plant flower2 = new Plant(10004l, "Fuchsia", 1, PlantType.FLOWER, "Fuchsia boliviana. It has large drooping corymbs up to 20 cm long borne in late summer and autumn of scarlet red flowers with the individual flowers 3–7 cm long.");
    	Plant flower3 = new Plant(10005l, "Sunflower", 9, PlantType.FLOWER, "yellow");
    

    	expectedAllPlants.add(herb);
    	expectedAllPlants.add(vegetable);
    	expectedAllPlants.add(flower);
    	expectedAllPlants.add(flower2);
    	expectedAllPlants.add(flower3);
    	

    	expectedVegetables.add(vegetable);

    	expectedFlowers.add(flower);
    	expectedFlowers.add(flower2);
    	expectedFlowers.add(flower3);

    	expectedHerbs.add(herb);

    }

    @Test
    public void ATestGetPlants() {
    	assertThat(plantService.getPlants(null), is(expectedAllPlants));
    	assertThat(plantService.getPlants(PlantType.VEGETABLE), is(expectedVegetables));
    	assertThat(plantService.getPlants(PlantType.FLOWER), is(expectedFlowers));
    	assertThat(plantService.getPlants(PlantType.HERB), is(expectedHerbs));
    }


    @Test
    public void BTestAddAndRemovePlant() {
        assertThat(plantService.getPlants(null), is(expectedAllPlants));
        
        plantService.addPlant("newPetunia", 2, PlantType.FLOWER, "white");
        List<Plant> expectedPlantsAfterAdd = new ArrayList<>(expectedAllPlants);
        expectedPlantsAfterAdd.add(0, new Plant(1l, "newPetunia", 2, PlantType.FLOWER, "white"));
        
        assertThat(plantService.getPlants(null), is(expectedPlantsAfterAdd));
        
        plantService.removePlant(1l);
        assertThat(plantService.getPlants(null), is(expectedAllPlants));
    }
    

    @Test
    public void CTestChangeAmount(){
    	List<Plant> expectedPlantsAfterChangeAmount = new ArrayList<>(expectedAllPlants);
    	expectedPlantsAfterChangeAmount.set(2, new Plant(10003l, "Petunia axillaris", 2, PlantType.FLOWER, "large white petunia"));
    	plantService.changeAmount(10003l,2);
    	assertThat(plantService.getPlants(null), is(expectedPlantsAfterChangeAmount));
    }

    @Test
    public void CTestfindPlantById(){
    	assertThat(plantService.findPlantById(10005l), is(new Plant(10005l, "Sunflower", 9, PlantType.FLOWER, "yellow")));
    }
}
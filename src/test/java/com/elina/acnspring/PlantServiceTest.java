package com.elina.acnspring;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantNursery;
import com.elina.acnspring.model.PlantType;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PlantServiceTest {

    @InjectMocks
    PlantService plantService;

    @Mock
    PlantNursery nurseryMock;
    private final List<Plant> allPlants = new ArrayList<>();
    private final List<Plant> vegetables = new ArrayList<>();
    private final List<Plant> flowers = new ArrayList<>();
    private final List<Plant> herbs = new ArrayList<>();
    private final Plant plant = new Plant("Pumpkin", 15, PlantType.VEGETABLE, "green");

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        
        Plant herb = new Plant(10001l, "Cinnamon basil", 20, PlantType.HERB, "has a spicy, fragrant aroma and flavor.");
        herbs.add(herb);
        
        vegetables.add(new Plant(10002l, "Cherry tomato", 15, PlantType.VEGETABLE, "with small yellow fruits"));

        flowers.add(new Plant(10005l, "Sunflower", 9, PlantType.FLOWER, "yellow"));
        flowers.add(new Plant(10003l, "Petunia axillaris", 3, PlantType.FLOWER, "large white petunia"));

        allPlants.addAll(vegetables);
        allPlants.addAll(herbs);
        allPlants.addAll(flowers);

        Mockito.doReturn(herbs).when(nurseryMock).getPlantsByType(PlantType.HERB);
        Mockito.doReturn(vegetables).when(nurseryMock).getPlantsByType(PlantType.VEGETABLE);
        Mockito.doReturn(flowers).when(nurseryMock).getPlantsByType(PlantType.FLOWER);
        Mockito.doReturn(allPlants).when(nurseryMock).getPlants();

        Mockito.doNothing().when(nurseryMock).removePlant(herb);        
        Mockito.doReturn(herb).when(nurseryMock).findPlantById(10001l);
        Mockito.doNothing().when(nurseryMock).addPlant(plant); 
    }

    @Test
    public void testGetPlants() {
        assertThat(plantService.getPlants(null), is(allPlants));
        assertThat(plantService.getPlants(PlantType.VEGETABLE), is(vegetables));
        assertThat(plantService.getPlants(PlantType.HERB), is(herbs));
        assertThat(plantService.getPlants(PlantType.FLOWER), is(flowers));

    }

    @Test
    public void testAddPlant() {
        assertThat(plantService.getPlants(null), is(allPlants));
        plantService.addPlant("Pumpkin", 15, PlantType.VEGETABLE, "green");
        Mockito.verify(nurseryMock, Mockito.times(1)).addPlant(plant);

    }

    @Test
    public void testRemovePlant() {
    	assertThat(plantService.getPlants(null), is(allPlants));
    	plantService.removePlant(10001l);
        Mockito.verify(nurseryMock, Mockito.times(1)).findPlantById(10001l);
        Mockito.verify(nurseryMock, Mockito.times(1)).removePlant(herbs.get(0));

    }

}
package com.elina.acnspring.plantcontroller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elina.acnspring.PlantService;
import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantType;

@Controller
public class PlantController {
    @Autowired
    private PlantService plantService;

    @GetMapping("plantNursery")
    public String getPlantNursery(ModelMap model) {
        model.addAttribute("plantNursery", plantService.getPlantNursery());
        model.addAttribute("flowers", plantService.getPlants(PlantType.FLOWER));
        model.addAttribute("herbs", plantService.getPlants(PlantType.HERB));
        model.addAttribute("vegetables", plantService.getPlants(PlantType.VEGETABLE));

        //Plant veidi
        List<String> enumNames = Stream.of(PlantType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        model.addAttribute("plantTypes", enumNames);
        
        
        return "plantnursery";
    }

    @GetMapping("plantNursery/hello")
    @ResponseBody
    public String sayHello()
    {
        return "Hello light!";
    }

    @GetMapping("edit-plant")
    public String getPlant(
    		@RequestParam("id") Long id, 
    		ModelMap model
	) {
    	Plant thePlant = plantService.findPlantById(id);
        model.addAttribute("plant", thePlant);
        
      //Plant veidi
        List<String> enumNames = Stream.of(PlantType.values())
                .map(Enum::name)
                .collect(Collectors.toList());
        model.addAttribute("plantTypes", enumNames);
        
        
        return "plant";
    }

    @PostMapping("plantNursery/plant/add")
    public String addPlant(
            @RequestParam("title") String title,
            @RequestParam("amount") int amount,
            @RequestParam("type") String type,
            @RequestParam(value = "description", required = false) String description) {
        
    	PlantType typeEnum = Enum.valueOf (PlantType.class, type);

    	plantService.addPlant(title, amount, typeEnum, description);
        return "redirect:/plantNursery";
    }
    
    @PostMapping("plantNursery/plant/remove")
    public String removePlant(
            @RequestParam("id") Long id
    ) {
        plantService.removePlant(id);
        return "redirect:/plantNursery";
    }
    
    @PostMapping("plantNursery/plant/edit")
    public String changeAmount(
            @RequestParam("id") Long id,
            @RequestParam("newAmount") int amount) {
          	
    	plantService.changeAmount(id, amount);
    	
        return "redirect:/plantNursery";
    }

}

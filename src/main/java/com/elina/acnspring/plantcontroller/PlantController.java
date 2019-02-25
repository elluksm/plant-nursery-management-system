package com.elina.acnspring.plantcontroller;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elina.acnspring.PlantService;
import com.elina.acnspring.model.Plant;
import com.elina.acnspring.model.PlantType;

@Controller
//@RequestMapping("/plantNursery") //- Salauž apakšā esošos routingus;
public class PlantController {
    @Autowired
    private PlantService plantService;

//    @RequestMapping(value="test", method = RequestMethod.GET)
    @GetMapping("plantNursery")
    public String getPlantNursery(ModelMap model) {
        model.addAttribute("plantNursery", plantService.getPlantNursery());

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

//    @RequestMapping(value = "/plant", method = RequestMethod.GET)
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

    @RequestMapping(value = "plantNursery/plant/add", method = RequestMethod.POST)
    public String addPlant(
            @RequestParam("title") String title,
            @RequestParam("amount") int amount,
            @RequestParam("type") String type,
            @RequestParam(value = "description", required = false) String description) {
        
    	PlantType typeEnum = Enum.valueOf (PlantType.class, type);

    	plantService.addPlant(title, amount, typeEnum, description);
        return "redirect:/plantNursery";
    }

    @RequestMapping(value = "plantNursery/plant/remove", method = RequestMethod.POST)
    public String removePlant(
            @RequestParam("id") Long id
    ) {
        plantService.removePlant(id);
        return "redirect:/plantNursery";
    }

    @RequestMapping(value = "plantNursery/plant/edit", method = RequestMethod.POST)
    public String changeAmount(
            @RequestParam("id") Long id,
            @RequestParam("newTitle") String title,
            @RequestParam("newAmount") int amount,
            @RequestParam("newType") String type,
            @RequestParam(value = "newDescription", required = false) String description) {
        
    	PlantType typeEnum = Enum.valueOf (PlantType.class, type);
    	
    	
    	plantService.changeAmount(id, amount);
    	
        return "redirect:/plantNursery";
    }

}
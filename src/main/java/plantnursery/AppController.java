package plantnursery;

import org.springframework.web.bind.annotation.*;
import plantnursery.model.Plant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import plantnursery.model.PlantType;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/plantnursery")

public class AppController {
    @Autowired
    private PlantService plantService;

//    @RequestMapping(value="test", method = RequestMethod.GET)
        @GetMapping(path = "/test2")
    public String getPlantNursery(ModelMap model) {
        model.addAttribute("plantNursery", plantService.getPlantNursery());
        return "test";
    }

    @GetMapping(path = "/hello")
    @ResponseBody
    public String sayHello()
    {
        return "Hello light!";
    }

//    @RequestMapping(value = "/plant", method = RequestMethod.GET)
//    public String getPlant(
//            @RequestParam("title") String title,
//            ModelMap model) {
//        model.addAttribute("plant", plantService.findPlantByTitle(title));
//        return "plant";
//    }
//
//    @RequestMapping(value = "/plant/add", method = RequestMethod.POST)
//    public String addPlant(
//            @RequestParam("title") String title,
//            @RequestParam("amount") int amount,
//            @RequestParam("type") PlantType type,
//            @RequestParam(value = "description", required = false) String description) {
//        plantService.addPlant(title, amount, type, description);
//        return "redirect:/plantNursery";
//    }
//
//    @RequestMapping(value = "/plant/remove", method = RequestMethod.POST)
//    public String removePlant(
//            @RequestParam("title") String title
//    ) {
//        plantService.removePlant(title);
//        return "redirect:/plantNursery";
//    }
//
//    @RequestMapping(value = "/plant/changeAmount", method = RequestMethod.POST)
//    public String changeAmount(
//            @RequestParam("title") String title,
//            @RequestParam("newAmount") int newAmount) {
//        plantService.changeAmount(title, newAmount);
//        return "redirect:/plantNursery";
//    }

}

package plantnursery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import plantnursery.model.PlantType;


@RestController
@RequestMapping("/test")
public class TestController
{

    @GetMapping(path = "/hello")
    @ResponseBody
    public String sayHello()
    {
        return "Hello light!";
    }


}
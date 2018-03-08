package weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@Controller
public class FormController {

    @RequestMapping(value="/pogodynka", method = RequestMethod.GET)
    public String register(Model model) {
        return "pogodynka";
    }

    @PostMapping("/pogodynka")
    public String registerPost(String name, Model model){
        model.addAttribute("isValidRegister", name);
        return "register";
    }
}

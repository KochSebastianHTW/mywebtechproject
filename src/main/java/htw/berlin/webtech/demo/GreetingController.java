package htw.berlin.webtech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

    @RestController
    public class GreetingController {

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";
        }


        @RequestMapping("/answer/{name}/{age}")
        public String pathParams(@PathVariable("name") String name,
                                 @PathVariable("age") String age) {
            return String.format("%s is %s years old", name, age);
        }

    }

package htw.berlin.webtech.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @Controller
    public class GreetingController {

        @GetMapping("/greeting")
        public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
            model.addAttribute("name", name);
            return "greeting";
        }

        // funktioniert nicht, kein template?!
        @RequestMapping("/answer/{name}/{age}")
        public String pathParams(@PathVariable("name") String name,
                                 @PathVariable("age") String age) {
            return String.format("%s is %s years old", name, age);
        }

    }

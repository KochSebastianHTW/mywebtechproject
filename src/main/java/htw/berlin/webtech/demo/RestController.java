package htw.berlin.webtech.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @RequestMapping("/answer/{name}/{age}")
    public String pathParams(@PathVariable("name") String name,
                             @PathVariable("age") String age) {
        return String.format("%s is %s years old", name, age);
    }
}

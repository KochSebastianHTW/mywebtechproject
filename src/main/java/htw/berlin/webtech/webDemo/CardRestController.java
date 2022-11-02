package htw.berlin.webtech.webDemo;

import htw.berlin.webtech.service.CardService;
import htw.berlin.webtech.webDemo.api.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardRestController {

    private final CardService cardService;

    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "/api/v1/cards")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cardService.findAll());
    }


    @RequestMapping("/answer/{name}/{age}")
    public String pathParams(@PathVariable("name") String name,
                             @PathVariable("age") String age) {
        return String.format("%s is %s years old", name, age);
    }

    @RequestMapping("/{unit}/{rank}/{name}") // RequestMapping testen
    public String pathParamsMilitary(@PathVariable("unit") String unit,
                          @PathVariable("rank") String rank,
                          @PathVariable("name") String name) {
        return String.format(
                "Einheit: %s" +
                "Rang: %s" +
                "Name: %s",
                unit, rank, name
        );
    }

    @RequestMapping("/sentence")
    public String queryParams(@RequestParam("say") String say) {
        return String.format("%s",say);
    }

    @RequestMapping("/")
    public String home() {return "Hier jibtet nüscht zu sehen! Did kannst mir glooben.";}
}

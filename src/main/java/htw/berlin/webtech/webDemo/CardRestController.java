package htw.berlin.webtech.webDemo;

import htw.berlin.webtech.service.CardService;
import htw.berlin.webtech.webDemo.api.Card;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/RoR/AVP/{rank}/{name}")
    public String rankAvp(@PathVariable("rank") String rank,
                          @PathVariable("name") String name) {
        return "%s %s ist ein richtig guter Pilot!";
    }
}

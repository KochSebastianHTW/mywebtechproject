package htw.berlin.webtech.webDemo;

import htw.berlin.webtech.webDemo.api.Card;
import htw.berlin.webtech.webDemo.api.Register;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CardRestController {

    private final List<Card> cards;

    public CardRestController() {
        cards = new ArrayList<>();
        cards.add(new Card(1L, "webTech Projekt M2", "Spring App hat REST-Schnittstelle, ist zu Heroku deployed und kann Daten in Datenbank speichern ", LocalDateTime.of(2022,11,13,23,59,59), new Register(1L,"im Gange")));
        cards.add(new Card(2L, "webTech Projekt M3", "Vue.js „Hello World“ erstellt und zu GitHub gepusht", LocalDateTime.of(2022,12,4,23,59,59), new Register(2L,"offen")));
    }

    @GetMapping(path = "/api/v1/cards")
    public ResponseEntity<List<Card>> getAllCards() {
        return ResponseEntity.ok(cards);
    }


    @RequestMapping("/answer/{name}/{age}")
    public String pathParams(@PathVariable("name") String name,
                             @PathVariable("age") String age) {
        return String.format("%s is %s years old", name, age);
    }
}

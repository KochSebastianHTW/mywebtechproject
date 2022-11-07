package htw.berlin.webtech.webDemo;

import htw.berlin.webtech.service.CardService;
import htw.berlin.webtech.webDemo.api.Card;
import htw.berlin.webtech.webDemo.api.CardManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CardRestController {

    private final CardService cardService;

    public CardRestController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "/api/v1/cards")
    public ResponseEntity<List<Card>> fetchCards() {
        return ResponseEntity.ok(cardService.findAll());
    }

    @GetMapping(path = "/api/v1/cards/{id}")
    public ResponseEntity<Card> fetchCardById(@PathVariable Long id) {
        var card = cardService.findById(id);
        return card != null ? ResponseEntity.ok(card) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/cards")
    public ResponseEntity<Void> createCard (@RequestBody CardManipulationRequest request) throws URISyntaxException {
        var card = cardService.create(request);
        URI uri = new URI("/api/v1/cards/" + card.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "api/v1/cards/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @RequestBody CardManipulationRequest request) {
        var card = cardService.update(id, request);
        return card != null ? ResponseEntity.ok(card) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/cards/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        boolean successful = cardService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @RequestMapping(path= "api/v1/cards/search")
    public ResponseEntity<List<Card>> fetchCardByName(@RequestParam("q") String q) { //NameContainsIgnoreCase
        var cards = cardService.findByName(q);
        return cards != null ? ResponseEntity.ok(cards) : ResponseEntity.notFound().build();
    }

    @RequestMapping("/") //home Seite später?!
    public ResponseEntity<String> home() {return ResponseEntity.ok("Hier jibtet nüscht zu sehen! Did kannst mir glooben.");}
}

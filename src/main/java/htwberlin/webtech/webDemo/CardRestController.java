package htwberlin.webtech.webDemo;

import htwberlin.webtech.service.CardService;
import htwberlin.webtech.service.LabelService;
import htwberlin.webtech.webDemo.api.Card;
import htwberlin.webtech.webDemo.api.CardManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class CardRestController {

    private final CardService cardService;

    private final LabelService labelService;

    public CardRestController(CardService cardService, LabelService labelService) {
        this.cardService = cardService;
        this.labelService = labelService;
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
    public ResponseEntity<Void> createCard(@Valid @RequestBody CardManipulationRequest request) throws URISyntaxException {
        var valid = validate(request);
        if (valid) {
            var card = cardService.create(request);
            URI uri = new URI("/api/v1/cards/" + card.getId());
            return ResponseEntity.created(uri).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping(path = "/api/v1/cards/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable Long id, @Valid @RequestBody CardManipulationRequest request) {
        var card = cardService.update(id, request);
        return card != null ? ResponseEntity.ok(card) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/cards/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        boolean successful = cardService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @RequestMapping(path= "/api/v1/cards/search")
    public ResponseEntity<List<Card>> fetchCardByName(@RequestParam("q") String q) { //NameContainsIgnoreCase
        return ResponseEntity.ok(cardService.findByName(q));
    }

    private boolean validate(CardManipulationRequest request) {
        if (request.getLabel() == null) {
            return true;
        }
        return labelService.findById(request.getLabel()) != null;
    }
}

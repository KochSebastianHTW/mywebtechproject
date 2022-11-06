package htw.berlin.webtech.webDemo;

import htw.berlin.webtech.service.CardService;
import htw.berlin.webtech.service.LabelService;
import htw.berlin.webtech.webDemo.api.Card;
import htw.berlin.webtech.webDemo.api.CardManipulationRequest;
import htw.berlin.webtech.webDemo.api.Label;
import htw.berlin.webtech.webDemo.api.LabelManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class LabelRestController {

    private final LabelService labelService;

    public LabelRestController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping(path = "/api/v1/labels")
    public ResponseEntity<List<Label>> fetchCards() {
        return ResponseEntity.ok(labelService.findAll());
    }

    @GetMapping(path = "/api/v1/labels/{id}")
    public ResponseEntity<Label> fetchCardById(@PathVariable Long id) {
        var label = labelService.findById(id);
        return label != null ? ResponseEntity.ok(label) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/labels")
    public ResponseEntity<Void> createCard (@RequestBody LabelManipulationRequest request) throws URISyntaxException {
        var label = labelService.create(request);
        URI uri = new URI("/api/v1/labels/" + label.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "api/v1/labels/{id}")
    public ResponseEntity<Label> updateCard(@PathVariable Long id, @RequestBody LabelManipulationRequest request) {
        var card = labelService.update(id, request);
        return card != null ? ResponseEntity.ok(card) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/labels/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable Long id) {
        boolean successful = labelService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

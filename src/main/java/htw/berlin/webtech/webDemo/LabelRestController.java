package htw.berlin.webtech.webDemo;

import htw.berlin.webtech.persistence.LabelEntity;
import htw.berlin.webtech.service.LabelService;
import htw.berlin.webtech.webDemo.api.Label;
import htw.berlin.webtech.webDemo.api.LabelManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class LabelRestController {

    @Autowired
    private final LabelService labelService;

    public LabelRestController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping(path = "/api/v1/labels")
    public ResponseEntity<List<Label>> fetchLabels() {
        return ResponseEntity.ok(labelService.findAll());
    }

    @GetMapping(path = "/api/v1/labels/{id}")
    public ResponseEntity<Label> fetchLabelById(@PathVariable Long id) {
        var label = labelService.findById(id);
        return label != null ? ResponseEntity.ok(label) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/labels")
    public ResponseEntity<Void> createLabel (@RequestBody LabelManipulationRequest request) throws URISyntaxException {
        var label = labelService.create(request);
        URI uri = new URI("/api/v1/labels/" + label.getId());
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "/api/v1/labels/{id}")
    public ResponseEntity<Label> updateLabel(@PathVariable Long id, @RequestBody LabelManipulationRequest request) {
        var label = labelService.update(id, request);
        return label != null ? ResponseEntity.ok(label) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/labels/{id}")
    public ResponseEntity<Void> deleteLabel(@PathVariable Long id) {
        boolean successful = labelService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @RequestMapping(path = "api/v1/labels/search")
    public ResponseEntity<List<Label>> fetchLabelByName(@RequestParam("q") String q) {
        return ResponseEntity.ok(labelService.findByName(q));
    }
}

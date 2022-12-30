package htwberlin.webtech.service;

import htwberlin.webtech.persistence.CardEntity;
import htwberlin.webtech.persistence.CardRepository;
import htwberlin.webtech.persistence.LabelEntity;
import htwberlin.webtech.persistence.LabelRepository;
import htwberlin.webtech.webDemo.api.Label;
import htwberlin.webtech.webDemo.api.LabelManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelService {

    @Autowired
    private final LabelRepository labelRepository;

    @Autowired
    private final CardRepository cardRepository;

    public LabelService(LabelRepository labelRepository, CardRepository cardRepository) {
        this.labelRepository = labelRepository;
        this.cardRepository = cardRepository;
    }

    public List<Label> findAll() {
        List<LabelEntity> labels = labelRepository.findAll();
        return labels.stream()
                .map(this::transformEntity)
                .sorted(Comparator.comparing(Label::getName, String.CASE_INSENSITIVE_ORDER))
                .collect(Collectors.toList());
    }

    public Label findById(Long id) {
        var labelEntity = labelRepository.findById(id);
        return labelEntity.map(this::transformEntity).orElse(null);
    }

    public  List<Label> findByName(String search) {
        List<LabelEntity> labels = labelRepository.findByNameContainsIgnoreCase(search);
        return labels.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Label create(LabelManipulationRequest request) {
        var labelEntity = new LabelEntity(request.getName(), request.getColor());
        labelEntity = labelRepository.save(labelEntity);
        return transformEntity(labelEntity);
    }

    public Label update(Long id, LabelManipulationRequest request) {
        var labelEntityOptional = labelRepository.findById(id);
        if (labelEntityOptional.isEmpty()) {
            return null;
        }

        var labelEntity = labelEntityOptional.get();
        labelEntity.setName(request.getName());
        labelEntity.setColor(request.getColor());

        labelEntity = labelRepository.save(labelEntity);

        return transformEntity(labelEntity);
    }

    public boolean deleteById(Long id) {
        if (!labelRepository.existsById(id)) {
            return false;
        }

        var cardEntityList = cardRepository.findAll();
        for (CardEntity cE: cardEntityList) {
            var cardEntityOptional = cardRepository.findById(cE.getId());
            var cardEntity = cardEntityOptional.get();
            var labelEntityOptional = labelRepository.findById(id);
            var labelEntity = labelEntityOptional.get();
            if (labelEntity == cardEntity.getLabel()) {
                cardEntity.setLabel(null);
            }
            cardRepository.save(cardEntity);
        }

        labelRepository.deleteById(id);
        return true;
    }

    private Label transformEntity(LabelEntity labelEntity) {
        LabelTransformer labelTransformer = new LabelTransformer();
        return labelTransformer.transformEntity(labelEntity);
    }
}

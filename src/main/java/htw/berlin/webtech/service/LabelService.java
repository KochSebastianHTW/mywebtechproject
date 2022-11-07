package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.CardEntity;
import htw.berlin.webtech.persistence.CardRepository;
import htw.berlin.webtech.persistence.LabelEntity;
import htw.berlin.webtech.persistence.LabelRepository;
import htw.berlin.webtech.webDemo.api.Label;
import htw.berlin.webtech.webDemo.api.LabelManipulationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .collect(Collectors.toList());
    }

    public Label findById(Long id) {
        var labelEntity = labelRepository.findById(id);
        return labelEntity.map(this::transformEntity).orElse(null);
    }

    public Label create(LabelManipulationRequest request) {
        var usingCardsIds = request.getUsingCardsIds();
        List<CardEntity> usingCards = new ArrayList<>();
        for (Long index: usingCardsIds) {
            usingCards.add(cardRepository.findById(index).orElseThrow());

        }
        var labelEntity = new LabelEntity(request.getName(), request.getColour(), usingCards);
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
        labelEntity.setName(labelEntity.getColour());
        labelEntity.setUsingCards(labelEntity.getUsingCards());
        labelEntity = labelRepository.save(labelEntity);

        return transformEntity(labelEntity);
    }

    public boolean deleteById(Long id) {
        if (!labelRepository.existsById(id)) {
            return false;
        }

        labelRepository.deleteById(id);
        return true;
    }

    private Label transformEntity(LabelEntity labelEntity) {
        LabelTransformer labelTransformer = new LabelTransformer();
        return labelTransformer.transformEntity(labelEntity);
        /*
        List<LabelEntity> usingCardsIds = new ArrayList<>();
        labelRepository.findById(labelEntity.getId());

        return new Label(
                labelEntity.getId(),
                labelEntity.getName(),
                labelEntity.getColour(),
                usingCardsIds
        );
        */
    }
}

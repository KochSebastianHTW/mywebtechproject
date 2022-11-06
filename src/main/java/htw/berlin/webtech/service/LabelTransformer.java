package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.CardEntity;
import htw.berlin.webtech.persistence.LabelEntity;
import htw.berlin.webtech.webDemo.api.Label;

import java.util.stream.Collectors;

public class LabelTransformer {

    public Label transformEntity(LabelEntity labelEntity) {
        var cardIds = labelEntity.getUsingCards() != null ? labelEntity.getUsingCards().stream().map(CardEntity::getId).collect(Collectors.toList()) : null;
        return new Label(
                labelEntity.getId(),
                labelEntity.getName(),
                labelEntity.getColour(),
                cardIds
        );
    }
}

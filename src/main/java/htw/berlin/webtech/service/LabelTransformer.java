package htw.berlin.webtech.service;

import htw.berlin.webtech.persistence.LabelEntity;
import htw.berlin.webtech.webDemo.api.Label;

public class LabelTransformer {

    public Label transformEntity(LabelEntity labelEntity) {
        return new Label(
                labelEntity.getId(),
                labelEntity.getName(),
                labelEntity.getColour()
        );
    }
}

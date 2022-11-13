package htwberlin.webtech.service;

import htwberlin.webtech.persistence.LabelEntity;
import htwberlin.webtech.webDemo.api.Label;

public class LabelTransformer {

    public Label transformEntity(LabelEntity labelEntity) {
        return new Label(
                labelEntity.getId(),
                labelEntity.getName(),
                labelEntity.getColour()
        );
    }
}

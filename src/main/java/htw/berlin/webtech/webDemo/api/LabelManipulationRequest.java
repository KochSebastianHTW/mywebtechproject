package htw.berlin.webtech.webDemo.api;

import java.util.List;

public class LabelManipulationRequest {

    private String name; // Name der Karte
    private String colour; // Beschreibung zum to-do
    private List<Long> usingCardsIds;

    public LabelManipulationRequest(String name, String colour, List<Long> usingCardsIds) {
        this.name = name;
        this.colour = colour;
        this.usingCardsIds = usingCardsIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String description) {
        this.colour = description;
    }

    public List<Long> getUsingCardsIds() {
        return usingCardsIds;
    }

    public void setUsingCardsIds(List<Long> usingCardsIds) {
        this.usingCardsIds = usingCardsIds;
    }
}

package htw.berlin.webtech.webDemo.api;

import java.util.ArrayList;
import java.util.List;

public class LabelManipulationRequest {

    private String name;
    private String colour;

    public LabelManipulationRequest(String name, String colour) {
        this.name = name;
        this.colour = colour;
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
}

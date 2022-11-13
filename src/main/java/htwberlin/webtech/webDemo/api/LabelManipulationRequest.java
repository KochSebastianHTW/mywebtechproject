package htwberlin.webtech.webDemo.api;


public class LabelManipulationRequest {

    private String name;
    private String colour;

    public LabelManipulationRequest(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    public LabelManipulationRequest() {}

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

package htwberlin.webtech.webDemo.api;


public class LabelManipulationRequest {

    private String name;
    private String color;

    public LabelManipulationRequest(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public LabelManipulationRequest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String description) {
        this.color = description;
    }
}

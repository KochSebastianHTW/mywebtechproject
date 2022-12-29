package htwberlin.webtech.webDemo.api;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LabelManipulationRequest {

    @Size(min = 1, message = "Please provide a name with 1 letter or more")
    private String name;
    @Pattern(
            regexp = "#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$",
            message = "Please provide a hex color code -> '#' plus 3 or 6 digits of 1-6 A-F and/or a-f"
    )
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

package htw.berlin.webtech.demo.api;

public class Label {

    private long id;
    private String name;
    private String colour; // TODO: eine Möglichkeit finden diese Farbe dann im Frontend darzustellen

    public Label(long id, String name, String colour) {
        this.id = id;
        this.name = name;
        this.colour = colour;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setColour(String colour) {
        this.colour = colour;
    }
}

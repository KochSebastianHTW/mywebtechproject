package htw.berlin.webtech.webDemo.api;

import java.util.List;

public class Label {

    private long id;
    private String name;
    private String colour; //TODO: eine Möglichkeit finden diese Farbe dann im Frontend darzustellen
    private List<Long> usingCardIds;

    public Label(long id, String name, String colour, List<Long> usingCardIds) {
        this.id = id;
        this.name = name;
        this.colour = colour;
        this.usingCardIds = usingCardIds;
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

    public List<Long> getUsingCardIds() {
        return usingCardIds;
    }

    public void setUsingCardIds(List<Long> usingCardIds) {
        this.usingCardIds = usingCardIds;
    }
}

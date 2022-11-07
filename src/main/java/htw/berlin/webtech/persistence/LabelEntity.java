package htw.berlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "label")
public class LabelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "colour", nullable = false)
    private String colour;

    public LabelEntity(String name, String colour) {
        this.name = name;
        this.colour = colour;
    }

    protected LabelEntity() {}

    public Long getId() {
        return id;
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

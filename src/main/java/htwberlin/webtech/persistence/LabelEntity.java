package htwberlin.webtech.persistence;

import javax.persistence.*;

@Entity(name = "label")
public class LabelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id; // eindeutige ID des Labels

    @Column(name = "name", nullable = false)
    private String name; // Name des Labels

    @Column(name = "colour", nullable = false)
    private String color; // Hex-Code des Labels

    public LabelEntity(String name, String color) {
        this.name = name;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

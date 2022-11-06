package htw.berlin.webtech.persistence;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LabelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "colour")
    private String colour;

    @OneToMany(mappedBy = "id", fetch = FetchType.EAGER)
    private List<CardEntity> usingCards = new ArrayList<>();

    public LabelEntity(String name, String colour, List<CardEntity> usingCards) {
        this.name = name;
        this.colour = colour;
        this.usingCards = usingCards;
    }

    public LabelEntity() {}

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

    public List<CardEntity> getUsingCards() {
        return usingCards;
    }

    public void setUsingCards(List<CardEntity> cards) {
        this.usingCards = cards;
    }
}

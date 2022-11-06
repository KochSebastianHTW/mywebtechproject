package htw.berlin.webtech.persistence;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity (name = "card")
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "register", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Register register;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "label_id", referencedColumnName = "id")
    private LabelEntity label;

    public CardEntity(String name, String description, LocalDateTime dueDate, Register register, LabelEntity label) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.register = register;
        this.label = label;
    }

    protected CardEntity() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }

    public LabelEntity getLabel() {
        return label;
    }

    public void setLabel(LabelEntity label) {
        this.label = label;
    }
}

package htw.berlin.webtech.persistence;

//import htw.berlin.webtech.webDemo.api.Label;
//import htw.berlin.webtech.webDemo.api.Register;

import javax.persistence.*;
import java.time.LocalDateTime;
//import java.util.List;

@Entity (name = "card")
public class CardEntity { // Dataclip wird nicht erzeugt, DB-connection bei Database-Reiter verbindet nicht, wegen falscher Credentials?!

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    /*
    @Column(name = "labels")
    private List<Label> labels;

    @Column(name = "activity")
    private List<String> activity;

    @Column(name = "register")
    private Register register;
    */

    public CardEntity(Long id, String name, String description, LocalDateTime dueDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        /*
        this.labels = labels;
        this.activity = activity;
        this.register = register;
        */
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

    /*
    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<String> getActivity() {
        return activity;
    }

    public void setActivity(List<String> activity) {
        this.activity = activity;
    }

    public Register getRegister() {
        return register;
    }

    public void setRegister(Register register) {
        this.register = register;
    }
    */
}

package htw.berlin.webtech.webDemo.api;

import java.time.LocalDateTime;

public class Card {

    private Long id;
    private String name;
    private String description;
    private LocalDateTime dueDate;
    private String register;
    private Long label;

    public Card(Long id, String name, String description, LocalDateTime dueDate, String register, Long label) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.register = register;
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register;
    }

    public Long getLabel() {
        return label;
    }

    public void setLabel(Long label) {
        this.label = label;
    }
}
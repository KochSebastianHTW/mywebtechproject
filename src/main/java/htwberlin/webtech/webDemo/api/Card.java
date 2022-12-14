package htwberlin.webtech.webDemo.api;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Card {

    private Long id;
    private String name;
    private String description;
    //@JsonFormat(pattern = "dd.MM.yyyy HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dueDate;
    private String register;
    private Long labelId;

    public Card(Long id, String name, String description, LocalDateTime dueDate, String register, Long labelId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.register = register;
        this.labelId = labelId;
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

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }
}

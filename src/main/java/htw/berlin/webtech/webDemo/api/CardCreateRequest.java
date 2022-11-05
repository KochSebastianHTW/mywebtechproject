package htw.berlin.webtech.webDemo.api;

import java.time.LocalDateTime;
import java.util.List;

public class CardCreateRequest {
    private String name; // Name der Karte
    private String description; // Beschreibung zum to-do
    private LocalDateTime dueDate; // Fälligkeitsdatum und Uhrzeit
    private List<Label> labels; // Labels der Karte
    private List<String> activity; // Aktivität auf der Karte; wie: Fälligkeitsdatum geändert etc.
    //private Register register; // Liste

    public CardCreateRequest(String name, String description, LocalDateTime dueDate) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        //this.register = register;
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

    public List<String> getActivity() {
        return activity;
    }

    public void setActivity(List<String> activity) {
        this.activity = activity;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    /*
    public Register getRegister() { return register; }

    public void setRegister(Register register) { this.register = register; }
    */
}

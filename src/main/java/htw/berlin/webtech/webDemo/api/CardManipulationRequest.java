package htw.berlin.webtech.webDemo.api;

import java.time.LocalDateTime;

public class CardManipulationRequest {
    private String name; // Name der Karte
    private String description; // Beschreibung zum to-do
    private LocalDateTime dueDate; // Fälligkeitsdatum und Uhrzeit

    private String register;
    /*
    private List<Label> labels; // Labels der Karte
    private List<String> activity; // Aktivität auf der Karte; wie: Fälligkeitsdatum geändert etc.
    private Register register; // Liste
     */

    public CardManipulationRequest(String name, String description, LocalDateTime dueDate, String register) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.register = register;
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

    public String getRegister() { return register; }

    public void setRegister(String register) { this.register = register; }
}

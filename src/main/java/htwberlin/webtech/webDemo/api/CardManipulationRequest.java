package htwberlin.webtech.webDemo.api;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class CardManipulationRequest {
    @Size(min = 1, message = "Please provide a name with 1 letter or more")
    private String name;
    private String description;
    private LocalDateTime dueDate;
    @Pattern(
        regexp = "OPEN|IN_PROGRESS|DONE|ARCHIVE",
        message = "Please provide 'OPEN', 'IN_PROGRESS', 'DONE' or 'ARCHIVE' for register"
    )
    private String register;
    private Long labelId;

    public CardManipulationRequest(String name, String description, LocalDateTime dueDate, String register, Long labelId) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.register = register;
        this.labelId = labelId;
    }

    public CardManipulationRequest() {}

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

    public Long getLabelId() {
        return labelId;
    }

    public void setLabelId(Long labelId) {
        this.labelId = labelId;
    }
}

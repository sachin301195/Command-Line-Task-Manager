import java.time.LocalDate;

public class Task{
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean isCompleted;

    // Constructor
    /**
     * @param title
     * @param description
     * @param dueDate
     */
    public Task(String title, String description, LocalDate dueDate){
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.isCompleted = false; // a new task is usually not completed
    }

    // Getter and Setter methods for each attribute
    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

     public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    // Override toString method for easy printing
    @Override
    public String toString(){
        return "Task{" +
                "titlt='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
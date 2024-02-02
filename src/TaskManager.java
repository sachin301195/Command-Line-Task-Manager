import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    //Constructor
    public TaskManager(){
        this.tasks = new ArrayList<>();
        // Load tasks from file when the TaskManager is created
        loadTaskFromFile();
    }

    // Method to add a new task
    /**
     * @param title
     * @param description
     * @param dueDate
     */
    public void addTask(String title, String description, LocalDate dueDate){
        Task newTask = new Task(title, description, dueDate);
        tasks.add(newTask);
        System.out.println("Task added successfully!");
        saveTasksToFile(); // Save tasks to file after adding a new task
    }

    // Method to view all tasks
    public void viewTasks(){
        if (tasks.isEmpty()){
            System.out.println("No tasks available");
        } else {
            for (int i = 0; i < tasks.size(); i++){
                System.out.println("Task " + (i + 1) + ":");
                System.out.println(tasks.get(i));
            }
        }
    }

    // Method to mark a task as complete
    public void markTaskAsComplete(int taskIndex){
        if (taskIndex >= 1 && taskIndex <= tasks.size()){
            Task task = tasks.get(taskIndex - 1);
            task.setCompleted(true);
            System.out.println("Task marked as completed!");
            saveTasksToFile();
        } else {
            System.out.println("Invalid task index");
        }
    }

    // Method to load Tasks from a file
    @SuppressWarnings("unchecked")
    private void loadTaskFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data/tasks.txt"))) {
            // Use generics to specify the expected type
            tasks = (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Handle exceptions, e.g., file not found or corrupted data
            System.out.println("Error loading tasks from file: " + e.getMessage());
        }
    }

    //Method to save tasks to a file
    private void saveTasksToFile(){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data/tasks.txt"))){
            oos.writeObject(tasks);
        }  catch (IOException e) {
            // Handle exceptions, e.g., file not found or unable to write
            System.out.println("Error saving tasks to file: " + e.getMessage());
        }
    }
}

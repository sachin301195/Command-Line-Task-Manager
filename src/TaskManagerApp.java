import java.time.LocalDate;
import java.util.Scanner;

public class TaskManagerApp {
    public static void main(String[] args) {
       try (Scanner scanner = new Scanner(System.in)) {
            TaskManager taskManager = new TaskManager();

            while (true) {
                // Display menu
                System.out.println("\n===== Task Manager Menu =====");
                System.out.println("1. Add Task");
                System.out.println("2. View Tasks");
                System.out.println("3. Mark Task as Complete");
                System.out.println("4. Exit");

                // Get user choice
                System.out.print("Enter your choice (1-4): ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                // Perform action based on user choice
                switch (choice) {
                case 1:
                    // Add Task
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter task due date (yyyy-mm-dd): ");
                    LocalDate dueDate = LocalDate.parse(scanner.nextLine());
                    taskManager.addTask(title, description, dueDate);
                    break;

                case 2:
                    // View Tasks
                    taskManager.viewTasks();
                    break;

                case 3:
                    // Mark Task as Complete
                    System.out.print("Enter the index of the task to mark as complete: ");
                    int taskIndex = scanner.nextInt();
                    taskManager.markTaskAsComplete(taskIndex);
                    break;

                case 4:
                    // Exit
                    System.out.println("Exiting Task Manager. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                }
            }
        }
    }
}
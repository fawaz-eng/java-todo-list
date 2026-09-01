import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {

    static class Task {
        String name;
        boolean completed;

        Task(String name) {
            this.name = name;
            this.completed = false;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            System.out.println("\n===== TO-DO LIST =====");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter your task: ");
                    String taskName = scanner.nextLine();

                    tasks.add(new Task(taskName));

                    System.out.println("Task added!");
                    break;

                case 2:
                    System.out.println("\n--- Your Tasks ---");

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks yet.");
                    } else {
                        for (int i = 0; i < tasks.size(); i++) {
                            Task task = tasks.get(i);

                            String status = task.completed ? "[✓]" : "[ ]";

                            System.out.println(
                                (i + 1) + ". " + status + " " + task.name
                            );
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("There are no tasks to complete.");
                        break;
                    }

                    System.out.print("Enter task number to complete: ");
                    int completeNumber = scanner.nextInt();

                    if (completeNumber >= 1 && completeNumber <= tasks.size()) {
                        tasks.get(completeNumber - 1).completed = true;
                        System.out.println("Task completed!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 4:
                    if (tasks.isEmpty()) {
                        System.out.println("There are no tasks to delete.");
                        break;
                    }

                    System.out.print("Enter task number to delete: ");
                    int deleteNumber = scanner.nextInt();

                    if (deleteNumber >= 1 && deleteNumber <= tasks.size()) {
                        tasks.remove(deleteNumber - 1);
                        System.out.println("Task deleted!");
                    } else {
                        System.out.println("Invalid task number.");
                    }
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}


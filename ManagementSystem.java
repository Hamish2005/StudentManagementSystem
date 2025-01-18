import java.util.Scanner;
import java.util.Stack;

public class ManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList studentList = new DoublyLinkedList();
        Stack<String> taskStack = new Stack<>();

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Remove the last student");
            System.out.println("4. Add a task ");
            System.out.println("5. Complete the most recent task ");
            System.out.println("6. Display all tasks");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter the number of grades: ");
                    int numGrades = scanner.nextInt();
                    int[] grades = new int[numGrades];
                    System.out.println("Enter grades separated by spaces:");
                    for (int i = 0; i < numGrades; i++) {
                        grades[i] = scanner.nextInt();
                    }
                    studentList.addStudent(name, grades);
                    taskStack.push("Added student: " + name);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    studentList.displayStudents();
                    break;

                case 3:
                    studentList.removeLastStudent();
                    taskStack.push("Removed the last student");
                    break;

                case 4:
                    System.out.print("Enter the task to add: ");
                    String task = scanner.nextLine();
                    taskStack.push(task);
                    System.out.println("Task added successfully!");
                    break;

                case 5:
                    if (!taskStack.isEmpty()) {
                        String recentTask = taskStack.pop();
                        System.out.println("Completed the most recent task: " + recentTask);
                    } else {
                        System.out.println("No tasks to complete.");
                    }
                    break;

                case 6:
                    if (taskStack.isEmpty()) {
                        System.out.println("No tasks to display.");
                    } else {
                        System.out.println("Current tasks (FILO order):");
                        for (int i = taskStack.size() - 1; i >= 0; i--) {
                            System.out.println(taskStack.get(i));
                        }
                    }
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}


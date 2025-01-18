import java.util.Scanner;
import java.util.Stack;

public class studentGrades {
    String name;
    int[] grades; // Array to store grades
    studentGrades prev;
    studentGrades next;

    public studentGrades(String name, int[] grades) {
        this.name = name;
        this.grades = grades;
        this.prev = null;
        this.next = null;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return grades.length > 0 ? (double) sum / grades.length : 0.0;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Grades: " + arrayToString(grades) + ", Average: " + calculateAverage();
    }

    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

// Doubly Linked List for Students
class DoublyLinkedList {
    private studentGrades head;
    private studentGrades tail;

    public void addStudent(String name, int[] grades) {
        studentGrades newNode = new studentGrades(name, grades);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void displayStudents() {
        if (head == null) {
            System.out.println("No students in the list.");
            return;
        }
        studentGrades current = head;
        System.out.println("Students in the list:");
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public void removeLastStudent() {
        if (tail == null) {
            System.out.println("No students to remove.");
            return;
        }
        System.out.println("Removing student: " + tail.name);
        if (tail == head) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
}

// Main Program


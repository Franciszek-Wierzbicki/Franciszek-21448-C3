package org.example;

import java.util.Scanner;

/**
 * Klasa zarządzająca działaniem Task Managera.
 */
public class TaskManagerApp {
    private TaskRepository taskRepository;
    private Scanner scanner;

    public TaskManagerApp() {
        taskRepository = new TaskRepository();
        scanner = new Scanner(System.in);
    }

    /**
     * Uruchamia Task Managera.
     */
    public void run() {
        int choice;
        do {
            displayMenu();
            choice = readChoice();
            executeChoice(choice);
        } while (choice != 5);
    }

    /**
     * Wyświetla menu główne.
     */
    private void displayMenu() {
        System.out.println("==== Task Manager ====");
        System.out.println("1. Dodaj zadanie");
        System.out.println("2. Wyświetl zadania");
        System.out.println("3. Usuń zadanie");
        System.out.println("4. Zmień status zadania");
        System.out.println("5. Wyjście");
        System.out.print("Wybierz opcję: ");
    }

    /**
     * Odczytuje wybór użytkownika.
     *
     * @return Wybór użytkownika
     */
    private int readChoice() {
        return scanner.nextInt();
    }

    /**
     * Wykonuje akcję związaną z wyborem użytkownika.
     *
     * @param choice Wybór użytkownika
     */
    private void executeChoice(int choice) {
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                displayTasks();
                break;
            case 3:
                removeTask();
                break;
            case 4:
                changeTaskStatus();
                break;
            case 5:
                exit();
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
        }
    }

    /**
     * Dodaje zadanie.
     */
    private void addTask() {
        System.out.println("Dodawanie nowego zadania");
        scanner.nextLine(); // Ignorowanie znaku nowej linii
        System.out.print("Podaj tytuł zadania: ");
        String title = scanner.nextLine();
        System.out.print("Podaj opis zadania: ");
        String description = scanner.nextLine();

        Task task = new Task(title, description);
        taskRepository.addTask(task);
        System.out.println("Zadanie dodane pomyślnie.");
    }

    /**
     * Wyświetla wszystkie zadania.
     */
    private void displayTasks() {
        System.out.println("Lista zadań:");
        for (Task task : taskRepository.getTasks()) {
            System.out.println(task);
        }
    }

    /**
     * Usuwa zadanie.
     */
    private void removeTask() {
        System.out.println("Usuwanie zadania");
        System.out.print("Podaj ID zadania do usunięcia: ");
        int taskId = scanner.nextInt();

        boolean removed = taskRepository.removeTask(taskId);
        if (removed) {
            System.out.println("Zadanie o ID " + taskId + " zostało usunięte.");
        } else {
            System.out.println("Nie znaleziono zadania o podanym ID.");
        }
    }

    /**
     * Zmienia status zadania.
     */
    private void changeTaskStatus() {
        System.out.println("Zmiana statusu zadania");
        System.out.print("Podaj ID zadania do zmiany statusu: ");
        int taskId = scanner.nextInt();

        Task task = taskRepository.getTaskById(taskId);
        if (task != null) {
            System.out.print("Podaj nowy status zadania (true/false): ");
            boolean completed = scanner.nextBoolean();
            task.setCompleted(completed);
            System.out.println("Status zadania o ID " + taskId + " został zmieniony.");
        } else {
            System.out.println("Nie znaleziono zadania o podanym ID.");
        }
    }

    /**
     * Wyjście z programu.
     */
    private void exit() {
        System.out.println("Koniec programu. Do widzenia!");
        scanner.close();
    }
}

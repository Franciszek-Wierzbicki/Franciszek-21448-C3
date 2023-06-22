package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa odpowiedzialna za zarządzanie repozytorium zadań.
 */
public class TaskRepository {
    private List<Task> tasks;

    public TaskRepository() {
        tasks = new ArrayList<>();
    }

    /**
     * Dodaje zadanie do repozytorium.
     *
     * @param task Zadanie do dodania
     */
    public void addTask(Task task) {
        tasks.add(task);
    }

    /**
     * Usuwa zadanie o podanym ID z repozytorium.
     *
     * @param taskId ID zadania do usunięcia
     * @return True, jeśli zadanie zostało usunięte; False w przeciwnym przypadku
     */
    public boolean removeTask(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }

    /**
     * Zwraca listę wszystkich zadań w repozytorium.
     *
     * @return Lista zadań
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Zwraca zadanie o podanym ID.
     *
     * @param taskId ID zadania
     * @return Zadanie o podanym ID lub null, jeśli zadanie nie istnieje
     */
    public Task getTaskById(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                return task;
            }
        }
        return null;
    }
}

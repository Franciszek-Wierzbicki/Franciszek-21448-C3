package org.example;

import java.time.LocalDate;

/**
 * Klasa reprezentująca zadanie w Task Managerze.
 */
public class Task {
    private static int nextId = 1;

    private int id;
    private String title;
    private String description;
    private LocalDate creationDate;
    private boolean completed;

    public Task(String title, String description) {
        this.id = nextId++;
        this.title = title;
        this.description = description;
        this.creationDate = LocalDate.now();
        this.completed = false;
    }

    // Gettery i settery

    /**
     * Zwraca ID zadania.
     *
     * @return ID zadania
     */
    public int getId() {
        return id;
    }

    /**
     * Zwraca tytuł zadania.
     *
     * @return Tytuł zadania
     */
    public String getTitle() {
        return title;
    }

    /**
     * Ustawia tytuł zadania.
     *
     * @param title Tytuł zadania
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Zwraca opis zadania.
     *
     * @return Opis zadania
     */
    public String getDescription() {
        return description;
    }

    /**
     * Ustawia opis zadania.
     *
     * @param description Opis zadania
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Zwraca datę utworzenia zadania.
     *
     * @return Data utworzenia zadania
     */
    public LocalDate getCreationDate() {
        return creationDate;
    }

    /**
     * Sprawdza, czy zadanie jest zakończone.
     *
     * @return True, jeśli zadanie jest zakończone; False w przeciwnym przypadku
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Ustawia status zakończenia zadania.
     *
     * @param completed True, jeśli zadanie jest zakończone; False w przeciwnym przypadku
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Tytuł: " + title +
                ", Opis: " + description +
                ", Data utworzenia: " + creationDate +
                ", Zakończone: " + completed;
    }
}
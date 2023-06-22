package org.example;


/**
 * Klasa pomocnicza do walidacji zadań.
 */
public class TaskValidator {
    /**
     * Sprawdza, czy tytuł zadania jest poprawny.
     *
     * @param title Tytuł zadania
     * @return True, jeśli tytuł jest poprawny; False w przeciwnym przypadku
     */
    public static boolean validateTitle(String title) {
        return title != null && !title.isEmpty();
    }
}
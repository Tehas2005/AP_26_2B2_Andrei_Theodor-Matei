package org.example.exception;
/**
 * Excepție personalizată pentru gestionarea erorilor din sistemul bibliografic.
 */
public class CatalogException extends Exception {
    public CatalogException(String message) {
        super(message);
    }

    public CatalogException(String message, Throwable cause) {
        super(message, cause);
    }
}
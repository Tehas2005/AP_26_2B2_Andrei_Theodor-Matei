package org.example.commands;
import org.example.CatalogException;

public interface Command {
    void execute() throws CatalogException;
}
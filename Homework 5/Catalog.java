package org.example;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private String name;
    private List<Resource> resources = new ArrayList<>();

    public Catalog(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public List<Resource> getResources() {
        return resources;
    }
}
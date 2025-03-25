package model;

import java.util.UUID;

public class Operator {
    private final String id;
    private String name;

    public Operator(String name) {
        this.id = generateId();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String generateId() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 10);
    }
}

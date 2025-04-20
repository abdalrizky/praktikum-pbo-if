package model;

public abstract class User {
    private final String id;
    private String name;

    public User(String name) {
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

    protected abstract String generateId();
}

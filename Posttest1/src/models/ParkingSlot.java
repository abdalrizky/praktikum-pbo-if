package models;

import java.util.UUID;

public class ParkingSlot {
    private final String id;
    private String name;
    private String type;
    private Status status;

    public ParkingSlot(String name, String type, Status status) {
        this.id = generateId();
        this.name = name;
        this.type = type;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Status getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private String generateId() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 5);
    }

}

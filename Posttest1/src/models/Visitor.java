package models;

import java.util.UUID;

public class Visitor {
    private final String id;
    private String name;
    private String phoneNumber;
    private String licenceNumber;

    public Visitor(String name, String phoneNumber, String licenceNumber) {
        this.id = generateId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.licenceNumber = licenceNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    private String generateId() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return uuid.substring(0, 5);
    }
}

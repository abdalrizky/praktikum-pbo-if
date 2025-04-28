package model;

import java.util.UUID;

public final class Visitor extends User {
    private String phoneNumber;
    private String licenceNumber;

    public Visitor(String name, String phoneNumber, String licenceNumber) {
        super(name);
        this.phoneNumber = phoneNumber;
        this.licenceNumber = licenceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    @Override
    protected String generateId() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return "v" + uuid.substring(0, 4);
    }
}

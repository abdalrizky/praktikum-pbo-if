package model;

import java.util.UUID;

public final class Operator extends User {
    public Operator(String name) {
        super(name);
    }

    @Override
    protected String generateId() {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        return "o" + uuid.substring(0, 4);
    }
}

package org.springsource.restbucks.user;

public enum Role {
    USER, ADMIN;

    @Override
    public String toString() {
        return name();
    }
}

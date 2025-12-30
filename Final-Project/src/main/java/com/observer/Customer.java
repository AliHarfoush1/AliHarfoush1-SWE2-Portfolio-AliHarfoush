package com.observer;

public class Customer implements Observer {
    private String name;
    private String email;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification to " + name + " (" + email + "): " + message);
    }

    public String getName() {
        return name;
    }
}
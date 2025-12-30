package com.observer;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {
    private String orderId;
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "Created";
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers("Order " + orderId + " status updated to: " + newStatus);
    }

    public String getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}

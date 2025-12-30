package com.singleton;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private boolean connected = false;

    private DatabaseConnection() {
        connect();
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    private void connect() {
        connected = true;
        System.out.println("Database connected");
    }

    public boolean isConnected() {
        return connected;
    }
}

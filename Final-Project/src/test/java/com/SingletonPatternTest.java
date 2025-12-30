package com;

import com.singleton.DatabaseConnection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingletonPatternTest {

    @Test
    void testSingletonInstance_Success() {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();

        assertSame(db1, db2, "Both instances should be the same");
        assertTrue(db1.isConnected(), "Database should be connected");
    }

    @Test
    void testSingletonConnection_Success() {
        DatabaseConnection db = DatabaseConnection.getInstance();

        assertTrue(db.isConnected(), "Database connection should be established");
    }
}

package com.gympulse.gympulse.utills;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GymLogger {

    private static GymLogger instance;
    private static final String LOG_FILE = "gym-activities.log";

    private GymLogger() {}

    public static GymLogger getInstance() {
        if (instance == null) {
            synchronized (GymLogger.class) {
                if (instance == null) {
                    instance = new GymLogger();
                }
            }
        }
        return instance;
    }
    public synchronized void log(String message) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            out.println(timestamp + " - " + message);
        } catch (IOException e) {
            handleLoggingError(e);
        }
    }

    private void handleLoggingError(IOException e) {
        // You can log this error to a different output or handle it according to your needs.
        System.err.println("Logging error: " + e.getMessage());
    }
}

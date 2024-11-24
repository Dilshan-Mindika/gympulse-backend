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
    
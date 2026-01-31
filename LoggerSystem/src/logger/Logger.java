package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    // SINGLE instance (Singleton)
    private static Logger instance;

    private BufferedWriter writer;
    private String fileName = "default_log.txt";

    // PRIVATE constructor (very important)
    private Logger() {
        openFile(fileName);
    }

    // Global access point
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Open file helper
    private void openFile(String name) {
        try {
            writer = new BufferedWriter(new FileWriter(name, true));
        } catch (IOException e) {
            System.out.println("Error opening log file: " + e.getMessage());
        }
    }

    // Change log file
    public void setFileName(String newFileName) {
        close();
        fileName = newFileName;
        openFile(fileName);
    }

    // Write log message
    public void write(String message) {
        try {
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }

    // Close logger
    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Error closing logger: " + e.getMessage());
        }
    }
}

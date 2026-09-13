package com.campusbuspass.db;

import com.campusbuspass.model.Pass;
import com.campusbuspass.model.Route;
import com.campusbuspass.model.Student;
import com.campusbuspass.model.VerificationLog;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Shared application store. Data is persisted locally between runs. */
public final class DB {
    private static final Path DATA_FILE = Path.of("campus_bus_passes.dat");
    private static final List<Student> STUDENTS = new ArrayList<>();
    private static final List<Route> ROUTES = new ArrayList<>();
    private static final List<Pass> PASSES = new ArrayList<>();
    private static final List<VerificationLog> VERIFICATION_LOGS = new ArrayList<>();
    private static boolean loaded;

    private DB() {
    }

    public static synchronized void init() {
        if (loaded) {
            return;
        }
        loaded = true;
        if (!Files.exists(DATA_FILE)) {
            return;
        }
        try (InputStream input = Files.newInputStream(DATA_FILE)) {
            Store store = (Store) new java.io.ObjectInputStream(input).readObject();
            STUDENTS.addAll(store.students);
            ROUTES.addAll(store.routes);
            PASSES.addAll(store.passes);
            VERIFICATION_LOGS.addAll(store.verificationLogs);
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.err.println("Could not load saved data: " + e.getMessage());
        }
    }

    public static List<Student> students() { init(); return STUDENTS; }
    public static List<Route> routes() { init(); return ROUTES; }
    public static List<Pass> passes() { init(); return PASSES; }
    public static List<VerificationLog> verificationLogs() { init(); return VERIFICATION_LOGS; }

    public static synchronized void save() {
        init();
        Path temporary = DATA_FILE.resolveSibling(DATA_FILE + ".tmp");
        try (OutputStream output = Files.newOutputStream(temporary)) {
            new java.io.ObjectOutputStream(output).writeObject(
                    new Store(STUDENTS, ROUTES, PASSES, VERIFICATION_LOGS));
            Files.move(temporary, DATA_FILE, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Could not save data: " + e.getMessage());
        }
    }

    private static final class Store implements java.io.Serializable {
        private static final long serialVersionUID = 1L;
        private final List<Student> students;
        private final List<Route> routes;
        private final List<Pass> passes;
        private final List<VerificationLog> verificationLogs;

        private Store(List<Student> students, List<Route> routes, List<Pass> passes,
                      List<VerificationLog> verificationLogs) {
            this.students = new ArrayList<>(students);
            this.routes = new ArrayList<>(routes);
            this.passes = new ArrayList<>(passes);
            this.verificationLogs = new ArrayList<>(verificationLogs);
        }
    }
}
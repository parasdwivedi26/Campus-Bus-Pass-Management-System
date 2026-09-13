package com.campusbuspass.dao;

import com.campusbuspass.db.DB;
import com.campusbuspass.model.VerificationLog;
import java.util.List;

/** CRUD operations for {@link VerificationLog}. */
public class VerificationLogDAO {

    /** Appends a verification entry and persists the change. */
    public void add(VerificationLog log) {
        DB.verificationLogs().add(log);
        DB.save();
    }

    /** Returns all verification entries (live view), most recent last. */
    public List<VerificationLog> findAll() {
        return DB.verificationLogs();
    }

    /** Next auto-increment id for a new log entry. */
    public int nextId() {
        return DB.verificationLogs().stream()
                .mapToInt(VerificationLog::getId)
                .max().orElse(0) + 1;
    }

    public int count() {
        return DB.verificationLogs().size();
    }

    public void log(String passId, String time, String result, String remarks) {
        boolean accepted = "VALID".equalsIgnoreCase(result);
        add(new VerificationLog(nextId(), passId, accepted, remarks, time));
    }
}
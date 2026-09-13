package com.campusbuspass.model;

import java.io.Serializable;

/**
 * Records one bus-pass verification performed by a verifier.
 */
public class VerificationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    private final int id;
    private final String passId;
    private final boolean result;   // true = accepted
    private final String message;
    private final String time;      // ISO LocalDateTime

    public VerificationLog(int id, String passId, boolean result, String message, String time) {
        this.id = id;
        this.passId = passId;
        this.result = result;
        this.message = message;
        this.time = time;
    }

    public int getId() { return id; }
    public String getPassId() { return passId; }
    public boolean isResult() { return result; }
    public String getMessage() { return message; }
    public String getTime() { return time; }

    @Override
    public String toString() {
        return "[" + time + "] Pass " + passId + " -> "
                + (result ? "ACCEPTED" : "REJECTED") + " - " + message;
    }
}
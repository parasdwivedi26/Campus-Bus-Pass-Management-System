package com.campusbuspass.service;

import com.campusbuspass.dao.PassDAO;
import com.campusbuspass.dao.VerificationLogDAO;
import com.campusbuspass.model.Pass;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VerificationService {
    private final PassDAO passDAO = new PassDAO();
    private final VerificationLogDAO logDAO = new VerificationLogDAO();

    public String verify(String passId) {
        String now = LocalDateTime.now().toString();
        Pass pass = passDAO.findByPassId(passId);
        if (pass == null) return record(passId, now, "INVALID", "Pass not found");
        if (!pass.isValid()) return record(passId, now, "BLOCKED", "Pass is blocked or expired");
        LocalDate expiry = LocalDate.parse(pass.getExpiryDate());
        if (LocalDate.now().isAfter(expiry)) {
            passDAO.updateStatus(passId, "EXPIRED");
            return record(passId, now, "EXPIRED", "Pass expired on " + expiry);
        }
        return record(passId, now, "VALID", "OK");
    }

    private String record(String passId, String time, String result, String message) {
        logDAO.log(passId, time, result, message);
        return result + ": " + message;
    }
}

package com.campusbuspass.dao;

import com.campusbuspass.db.DB;
import com.campusbuspass.model.Pass;
import java.util.List;
import java.time.LocalDate;

/** CRUD operations for {@link Pass}. */
public class PassDAO {

    /** Adds an issued pass and persists the change. */
    public void add(Pass pass) {
        DB.passes().add(pass);
        DB.save();
    }

    /** Finds a pass by its generated id (case-insensitive). */
    public Pass findByPassId(String passId) {
        for (Pass p : DB.passes()) {
            if (p.getPassId().equalsIgnoreCase(passId)) {
                return p;
            }
        }
        return null;
    }

    /** Returns all passes (live view). */
    public List<Pass> findAll() {
        return DB.passes();
    }

    /** Returns passes owned by a student, by registration number. */
    public List<Pass> findActiveByRegNo(String regNo) {
        return DB.passes().stream()
                .filter(p -> p.getRegNo().equalsIgnoreCase(regNo) && p.isValid())
                .toList();
    }

    /** Applies changes made to an existing pass object. */
    public boolean update(Pass updated) {
        Pass existing = findByPassId(updated.getPassId());
        if (existing == null) {
            return false;
        }
        existing.setExpiryDate(updated.getExpiryDate());
        existing.setValid(updated.isValid());
        DB.save();
        return true;
    }

    /** Removes a pass by id. */
    public boolean delete(String passId) {
        boolean removed = DB.passes().removeIf(p -> p.getPassId().equalsIgnoreCase(passId));
        if (removed) {
            DB.save();
        }
        return removed;
    }

    public int count() {
        return DB.passes().size();
    }

    public boolean updateStatus(String passId, String status) {
        Pass pass = findByPassId(passId);
        if (pass == null || status == null) return false;
        pass.setValid("ACTIVE".equalsIgnoreCase(status));
        DB.save();
        return true;
    }

    public List<Pass> listExpiringWithinDays(int days) {
        LocalDate today = LocalDate.now();
        LocalDate limit = today.plusDays(Math.max(0, days));
        return DB.passes().stream()
                .filter(pass -> pass.isValid())
                .filter(pass -> !LocalDate.parse(pass.getExpiryDate()).isBefore(today))
                .filter(pass -> !LocalDate.parse(pass.getExpiryDate()).isAfter(limit))
                .toList();
    }
}
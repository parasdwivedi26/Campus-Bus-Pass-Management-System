package com.campusbuspass.dao;

import com.campusbuspass.db.DB;
import com.campusbuspass.model.Student;
import java.util.List;

/** CRUD operations for {@link Student}. */
public class StudentDAO {

    /** Adds a new student and persists the change. */
    public void add(Student student) {
        DB.students().add(student);
        DB.save();
    }

    /** Finds a student by registration number (case-insensitive). */
    public Student findByRegNo(String regNo) {
        for (Student s : DB.students()) {
            if (s.getRegNo().equalsIgnoreCase(regNo)) {
                return s;
            }
        }
        return null;
    }

    /** Returns all students (live view). */
    public List<Student> findAll() {
        return DB.students();
    }

    /** Updates the mutable fields of an existing student. */
    public boolean update(Student updated) {
        Student existing = findByRegNo(updated.getRegNo());
        if (existing == null) {
            return false;
        }
        existing.setName(updated.getName());
        existing.setCategory(updated.getCategory());
        existing.setEmail(updated.getEmail());
        existing.setPhone(updated.getPhone());
        existing.setAddress(updated.getAddress());
        existing.setRegDate(updated.getRegDate());
        DB.save();
        return true;
    }

    /** Removes a student by registration number. */
    public boolean delete(String regNo) {
        boolean removed = DB.students().removeIf(s -> s.getRegNo().equalsIgnoreCase(regNo));
        if (removed) {
            DB.save();
        }
        return removed;
    }

    public int count() {
        return DB.students().size();
    }

    public Student findByRollNo(String regNo) { return findByRegNo(regNo); }

    public List<Student> listAll() { return findAll(); }

    public int addStudent(String regNo, String name, String category, String phone) {
        if (findByRegNo(regNo) != null) throw new IllegalArgumentException("Student already exists");
        add(new Student(regNo, name, category, "", phone, "", java.time.LocalDate.now().toString()));
        return DB.students().size();
    }
}
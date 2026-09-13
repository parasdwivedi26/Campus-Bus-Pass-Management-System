package com.campusbuspass.service;

import com.campusbuspass.dao.PassDAO;
import com.campusbuspass.dao.RouteDAO;
import com.campusbuspass.dao.StudentDAO;
import com.campusbuspass.model.Pass;
import com.campusbuspass.model.Route;
import com.campusbuspass.model.Student;

import java.time.LocalDate;

public class PassService {

    private final PassDAO passDAO = new PassDAO();
    private final PassIdGenerator idGenerator = new PassIdGenerator();

    private final StudentDAO studentDAO = new StudentDAO();
    private final RouteDAO routeDAO = new RouteDAO();

    public String issuePass(
            String regNo,
            int routeId,
            LocalDate validFrom,
            LocalDate validTo) {

        // 1. Validate dates
        if (validTo.isBefore(validFrom)) {
            throw new IllegalArgumentException(
                    "Expiry date must not be before start date");
        }

        // 2. Validate that student exists
        Student student = studentDAO.findByRegNo(regNo);

        if (student == null) {
            throw new IllegalArgumentException(
                    "Student not found: " + regNo);
        }

        // 3. Validate that route exists
        Route route = routeDAO.findById(routeId);

        if (route == null) {
            throw new IllegalArgumentException(
                    "Route not found: " + routeId);
        }

        // 4. Get actual fee from selected route
        double fee = route.getFee();

        // 5. Generate unique pass ID
        String passId = idGenerator.nextPassId();

        // 6. Create pass using the actual route fee
        Pass pass = new Pass(
                passId,
                regNo,
                routeId,
                "MONTHLY",
                fee,
                validFrom.toString(),
                validTo.toString(),
                true
        );

        // 7. Save pass
        passDAO.add(pass);

        return passId;
    }

    public boolean blockPass(String passId) {
        return passDAO.updateStatus(passId, "BLOCKED");
    }
}
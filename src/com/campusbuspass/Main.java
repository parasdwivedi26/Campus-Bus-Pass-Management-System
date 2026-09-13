package com.campusbuspass;

import com.campusbuspass.db.Schema;
import com.campusbuspass.dao.RouteDAO;
import com.campusbuspass.dao.StudentDAO;
import com.campusbuspass.service.PassService;
import com.campusbuspass.service.VerificationService;
import com.campusbuspass.util.Input;

import java.time.LocalDate;

public final class Main {

    private Main() {}

    public static void main(String[] args) {

        Schema.init();

        StudentDAO studentDAO = new StudentDAO();
        RouteDAO routeDAO = new RouteDAO();
        PassService passService = new PassService();
        VerificationService verificationService = new VerificationService();

        while (true) {

            System.out.println();
            System.out.println("=== CAMPUS BUS PASS SYSTEM ===");
            System.out.println("1. Add student");
            System.out.println("2. Add route");
            System.out.println("3. Generate pass");
            System.out.println("4. Verify pass");
            System.out.println("0. Exit");

            switch (Input.integer("Choose: ")) {

                case 1 -> addStudent(studentDAO);

                case 2 -> addRoute(routeDAO);

                case 3 -> generatePass(passService);

                case 4 -> verifyPass(verificationService);

                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent(StudentDAO studentDAO) {

        String regNo = Input.text("Registration number: ");
        String name = Input.text("Name: ");
        String category = Input.text("Category: ");
        String phone = Input.text("Phone: ");

        try {

            studentDAO.addStudent(
                    regNo,
                    name,
                    category,
                    phone
            );

            System.out.println("Student added.");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    private static void addRoute(RouteDAO routeDAO) {

        String name = Input.text("Route name: ");
        String source = Input.text("Source: ");
        String destination = Input.text("Destination: ");
        double fee = Input.decimal("Fee: ");

        System.out.println(
                "Route added with ID: "
                        + routeDAO.addRoute(
                                name,
                                source,
                                destination,
                                fee
                        )
        );
    }

    private static void generatePass(PassService passService) {

        String regNo = Input.text(
                "Registration number: "
        );

        int routeId = Input.integer(
                "Route ID: "
        );

        try {

            LocalDate validFrom = LocalDate.now();

            LocalDate validTo = validFrom.plusMonths(1);

            String passId = passService.issuePass(
                    regNo,
                    routeId,
                    validFrom,
                    validTo
            );

            System.out.println();
            System.out.println("PASS GENERATED SUCCESSFULLY");
            System.out.println("----------------------------");
            System.out.println("Pass ID: " + passId);
            System.out.println("Registration No: " + regNo);
            System.out.println("Route ID: " + routeId);
            System.out.println("Valid From: " + validFrom);
            System.out.println("Valid To: " + validTo);
            System.out.println("Status: ACTIVE");
            System.out.println("----------------------------");

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Unable to generate pass: "
                            + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Error generating pass: "
                            + e.getMessage()
            );
        }
    }

    private static void verifyPass(
            VerificationService verificationService) {

        String passId = Input.text(
                "Pass ID: "
        );

        try {

            System.out.println(
                    verificationService.verify(passId)
            );

        } catch (Exception e) {

            System.out.println(
                    "Unable to verify pass: "
                            + e.getMessage()
            );
        }
    }
}
# Campus Bus Pass Management System

## 1. Project Title

**Campus Bus Pass Management System using Java**

A console-based Java application for managing campus bus students, routes, bus pass generation, and pass verification.

---

## 2. Problem Statement

Managing campus bus passes manually can be time-consuming and may lead to errors while handling student details, route information, pass IDs, and pass verification.

The Campus Bus Pass Management System provides a simple computerized solution for managing these activities through a Java-based console application.

The system allows users to:
- Add student information.
- Add campus bus routes.
- Generate unique bus passes.
- Verify generated bus passes.

---

## 3. Objectives

- Maintain student information.
- Maintain campus bus route information.
- Generate unique bus pass IDs.
- Associate a bus pass with a student and route.
- Define the validity period of a bus pass.
- Verify whether a bus pass is valid.
- Handle invalid user input.
- Implement a modular Java application using OOP concepts.

---

## 4. Features

### Student Management
- Add student details.
- Store registration number.
- Store student name.
- Store category.
- Store phone number.
- Detect duplicate student registration numbers.

### Route Management
- Add a campus bus route.
- Store route name.
- Store source.
- Store destination.
- Store route fee.
- Generate a route ID.

### Pass Generation
- Generate a unique pass ID.
- Associate the pass with a student's registration number.
- Associate the pass with a route.
- Set the pass start date.
- Set the pass expiry date.
- Maintain pass validity status.

### Pass Verification
- Enter a pass ID.
- Check whether the pass exists.
- Check whether the pass is valid.
- Display the verification result.

### Input Validation
The system handles invalid input such as entering text where an integer is required.

Example:
```text
Route ID: COLLEGE
Enter a valid integer.
```

---

## 5. Technologies Used

| Technology | Purpose |
|---|---|
| Java | Main programming language |
| Java OOP | Application architecture |
| Java `LocalDate` | Pass validity dates |
| VS Code | Development environment |
| PowerShell | Compilation and execution |
| Git | Version control |
| GitHub | Project repository |

---

## 6. Requirements

### Hardware
- Computer or laptop
- Minimum 4 GB RAM
- Basic storage space

### Software
- Java Development Kit (JDK)
- Visual Studio Code
- Java Extension Pack for VS Code
- PowerShell / Terminal
- Git
- GitHub account

---

## 7. Current Project Structure

```text
vit java project/
│
├── .vscode/
│   └── settings.json
│
├── src/
│   └── com/
│       └── campusbuspass/
│           ├── Main.java
│           │
│           ├── dao/
│           │   ├── PassDAO.java
│           │   ├── RouteDAO.java
│           │   ├── StudentDAO.java
│           │   └── VerificationLogDAO.java
│           │
│           ├── db/
│           │   ├── DB.java
│           │   └── Schema.java
│           │
│           ├── model/
│           │   ├── Pass.java
│           │   ├── Route.java
│           │   ├── Student.java
│           │   └── VerificationLog.java
│           │
│           ├── service/
│           │   ├── PassIdGenerator.java
│           │   ├── PassService.java
│           │   └── VerificationService.java
│           │
│           ├── ui/
│           │
│           └── util/
│               └── Input.java
│
├── screenshots/
│
├── README.md
└── .gitignore
```

> The `out/` directory contains compiled `.class` files locally and should be excluded from GitHub using `.gitignore`.

---

## 8. Main Menu

The current application provides:

```text
=== CAMPUS BUS PASS SYSTEM ===
1. Add student
2. Add route
3. Generate pass
4. Verify pass
0. Exit
Choose:
```

| Option | Function |
|---|---|
| `1` | Add student |
| `2` | Add route |
| `3` | Generate pass |
| `4` | Verify pass |
| `0` | Exit |

---

## 9. Application Flow

```text
                  CAMPUS BUS PASS SYSTEM
                           |
             +-------------+-------------+
             |             |             |
             ▼             ▼             ▼
        Add Student    Add Route    Generate Pass
             |             |             |
             ▼             ▼             ▼
        Student Data   Route Data    Student + Route
                                         |
                                         ▼
                                  Unique Pass ID
                                         |
                                         ▼
                                  Validity Period
                                         |
                                         ▼
                                   Verify Pass
                                         |
                               +---------+---------+
                               |                   |
                               ▼                   ▼
                           VALID: OK       INVALID: ...
```

---

## 10. Setup

Open the project folder in Visual Studio Code.

Example:
```powershell
cd "C:\Users\dwive\paras\vit java project"
```

Open the VS Code terminal and make sure you are inside the project directory.

---

## 11. Compile the Project

Run the following PowerShell command:

```powershell
Remove-Item -Recurse -Force .\out -ErrorAction SilentlyContinue
New-Item -ItemType Directory -Force .\out
javac -d .\out (Get-ChildItem -Recurse .\src -Filter *.java).FullName
```

This command:
1. Removes the previous `out` directory.
2. Creates a new `out` directory.
3. Finds all `.java` files inside `src`.
4. Compiles the source files.
5. Places compiled `.class` files inside `out`.

If there are no errors, compilation is successful.

---

## 12. Run the Project

After successful compilation, run:

```powershell
java -cp .\out com.campusbuspass.Main
```

The application will display:

```text
=== CAMPUS BUS PASS SYSTEM ===
1. Add student
2. Add route
3. Generate pass
4. Verify pass
0. Exit
Choose:
```

---

## 13. Using the Application

### 13.1 Add Student

Select:
```text
1
```

Enter:
```text
Registration number:
Name:
Category:
Phone:
```

Example:
```text
Registration number: XPB
Name: BHUMI
Category: 1
Phone: 9898
```

If the student already exists:
```text
Student already exists
```

### 13.2 Add Route

Select:
```text
2
```

Enter:
```text
Route name:
Source:
Destination:
Fee:
```

Example:
```text
Route name: COLLEGE
Source: BUS
Destination: BHOPAL
Fee: 500
```

The system generates a route ID:
```text
Route added with ID: 4
```

### 13.3 Generate Pass

Select:
```text
3
```

Enter the student's registration number and numeric Route ID:
```text
Registration number: XPB
Route ID: 4
```

Example output:
```text
PASS GENERATED SUCCESSFULLY
----------------------------
Pass ID: BP-2026-00001
Registration No: XPB
Route ID: 4
Valid From: 2026-09-13
Valid To: 2026-10-13
Status: ACTIVE
----------------------------
```

### 13.4 Verify Pass

Select:
```text
4
```

Enter the exact generated pass ID:
```text
Pass ID: BP-2026-00001
```

For a valid pass:
```text
VALID: OK
```

For an incorrect or nonexistent pass:
```text
INVALID: Pass not found
```

---

## 14. Testing

| Test Case | Input / Action | Expected Result |
|---|---|---|
| Add new student | Valid student information | Student added |
| Add duplicate student | Existing registration number | `Student already exists` |
| Add route | Valid route information | Route added with ID |
| Generate pass | Valid registration number + route ID | Pass generated |
| Verify valid pass | Correct pass ID | `VALID: OK` |
| Verify invalid pass | Incorrect pass ID | `INVALID: Pass not found` |
| Invalid numeric input | Text instead of integer | `Enter a valid integer.` |
| Exit | `0` | Application exits |

### Invalid Input Example

```text
Route ID: COLLEGE
Enter a valid integer.
Route ID:
```

---

## 15. Screenshots

Place screenshots of the working application inside:

```text
screenshots/
```

Recommended screenshots:
- Main menu
- Add student
- Add route
- Generate pass
- Verify valid pass
- Verify invalid pass
- Invalid input handling

Example:
```markdown
![Main Menu](screenshots/main-menu.png)
![Add Student](screenshots/add-student.png)
![Add Route](screenshots/add-route.png)
![Generate Pass](screenshots/generate-pass.png)
![Verify Pass](screenshots/verify-pass.png)
```

---

## 16. Project Architecture

The project follows a modular layered structure:

```text
Main
  |
  ▼
Input / Console
  |
  ▼
Service Layer
  |
  ▼
DAO Layer
  |
  ▼
Data / Database Layer
```

### Model Layer
- `Student`
- `Route`
- `Pass`
- `VerificationLog`

### DAO Layer
- `StudentDAO`
- `RouteDAO`
- `PassDAO`
- `VerificationLogDAO`

### Service Layer
- `PassService`
- `VerificationService`
- `PassIdGenerator`

### Database Layer
- `DB`
- `Schema`

### Utility Layer
- `Input`

---

## 17. Future Enhancements

Possible future improvements include:
- Persistent database storage.
- Student login and authentication.
- Admin login.
- Bus pass renewal.
- Pass blocking and unblocking.
- QR-code-based pass verification.
- Digital bus pass generation.
- Online payment integration.
- Bus route schedules.
- Search and filtering.
- Graphical User Interface.
- Web-based application.
- Mobile application.
- Reports and analytics.

---

## 18. Limitations

The current version is a console-based Java application.

Current limitations include:
- No graphical user interface.
- No web-based interface.
- No advanced authentication system.
- No online payment system.
- Additional persistent storage features can be implemented in future versions.

---

## 19. Conclusion

The Campus Bus Pass Management System is a Java-based console application developed to provide a structured approach to campus bus pass management.

The application provides functionality for adding students, adding routes, generating unique bus passes, and verifying bus passes.

The project uses a modular architecture with separate model, DAO, service, database, and utility packages. This separation makes the project easier to maintain, test, and extend.

The current system provides a foundation for developing a more advanced campus transportation management system with persistent storage, authentication, QR-code verification, and graphical or web-based interfaces.

---

## 20. Project Information

**Project Name:** Campus Bus Pass Management System  
**Programming Language:** Java  
**Application Type:** Console-Based Application  
**Development Environment:** Visual Studio Code  
**Version Control:** Git / GitHub  
**Academic Project:** VITyarthi Project

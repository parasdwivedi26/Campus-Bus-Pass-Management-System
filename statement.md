\# Project Statement



\## 1. Problem Statement



Managing campus bus passes manually can be time-consuming and may lead to errors while handling student details, route information, pass IDs, and pass verification.



The Campus Bus Pass Management System provides a simple Java-based console solution for managing these activities. The system allows users to add student information, add campus bus routes, generate unique bus passes, and verify generated bus passes.



\## 2. Scope of the Project



The project covers the following operations:



\- Adding student information.

\- Adding campus bus route information.

\- Generating unique monthly bus passes.

\- Associating a pass with a student and route.

\- Assigning validity dates to a pass.

\- Verifying bus pass validity.

\- Handling invalid user input.



The current implementation is a command-line Java application.



\## 3. Target Users



The primary target users are:



\- Campus transportation administrators.

\- Staff members responsible for managing student bus passes.

\- Authorized personnel responsible for checking bus pass validity.



\## 4. High-Level Features



\### Student Management

\- Add student details.

\- Store registration number, name, category, and phone number.

\- Detect duplicate registration numbers.



\### Route Management

\- Add campus bus routes.

\- Store route name, source, destination, and fee.

\- Automatically generate route IDs.



\### Bus Pass Management

\- Generate unique bus pass IDs.

\- Associate passes with students and routes.

\- Set pass validity dates.

\- Maintain pass validity status.



\### Pass Verification

\- Enter a pass ID.

\- Check whether the pass exists.

\- Verify pass validity.

\- Display the verification result.



\### Input Validation

\- Handle invalid numeric input.

\- Validate student existence before pass generation.

\- Validate route existence before pass generation.


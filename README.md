Vehicle Rental Management System
The Vehicle Rental Management System is a Java-based application designed to manage vehicle rentals efficiently. It demonstrates all key Object-Oriented Programming (OOP) principles, including Abstraction, Encapsulation, Inheritance, Polymorphism, and Composition.

Key Features
Vehicle Management:

Abstract Vehicle class with concrete implementations for Car, Motorcycle, and Truck.
Flexible rental cost calculations and availability checks specific to each vehicle type.
Customer Management:

Tracks rental history and ensures eligibility for new rentals.
Encapsulates customer information for secure handling.
Rental Transactions:

Processes vehicle rentals and returns.
Generates detailed transaction reports.
Agency Operations:

Manages a fleet of vehicles.
Implements business logic for rentals and loyalty programs.
OOP Principles in Action
Abstraction: An abstract base class (Vehicle) and interfaces ensure modular design.
Encapsulation: Fields are private with controlled access through getters, setters, and validation logic.
Inheritance: Specialized classes like Car, Motorcycle, and Truck inherit from the base Vehicle class.
Polymorphism: Method overriding for unique rental cost calculations and dynamic behavior.
Composition: Classes like RentalAgency manage a fleet and customer transactions using composition.
Technologies Used
Java for implementation.
Maven for build and dependency management.
JUnit 5 for testing.
How to Run
Clone the repository to your local machine.
Open the project in IntelliJ IDEA.
Navigate to Main.java in the com.vehicle.rental package.
Run the application to test vehicle rental and management functionalities.

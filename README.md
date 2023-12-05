# EventMan

# Project Overview:

The Event Management System is a JavaFX application built to streamline the process of organizing and managing events. The system provides a user-friendly interface for creating, updating, and deleting events. It also allows users to view a list of all events along with their details.
Features:

    Event Creation:
        Users can create new events by providing essential details such as event name, date, time, and location.
        Additional information such as event description and organizer details can be included.

    Event Listing:
        The application displays a list of all events, showing key information like event name, date, and location in a tabular format.
        Users can easily browse through the list to get an overview of upcoming events.

    Event Details:
        Clicking on a specific event in the list provides detailed information about that event, including description and organizer details.

    Event Update:
        Users have the ability to update event information, such as modifying the date, time, or location.
        The system ensures data integrity by validating user inputs during the update process.

    Event Deletion:
        Events can be deleted, and the system prompts the user for confirmation to prevent accidental deletions.

# Technologies Used:

    JavaFX: Used for building the graphical user interface.
    FXML: XML-based language for designing the UI.
    IntelliJ IDEA: Integrated development environment for Java.
    SQL: Database

# Implementation Details:

    UI Design:
        The user interface is designed using FXML to create a visually appealing and intuitive layout.
        Different scenes and controllers are employed to manage various aspects of the application.

    Event Class:
        A Java class represents the event entity with attributes such as name, date, time, location, description, and organizer details.

    EventDAO (Data Access Object):
        Manages the interaction with the data source, whether it be a local database or file storage.
        Includes methods for adding, updating, deleting, and retrieving events.

    Controller Classes:
        Separate controllers are implemented for different views, ensuring a clean and modular code structure.
        Controllers handle user inputs, trigger appropriate actions, and update the UI.

# Features:

    User Authentication: Implement a secure login system for organizers to manage their events.
    Database Integration: Extend the project to use a database for persistent storage of event data.

 # further developenment of this project is currently paused

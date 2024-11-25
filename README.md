# GYMPULSE: Gym Management System

GYMPULSE is a comprehensive gym management system designed using **Spring Boot** with MongoDB as the database. This application is aimed at automating gym-related operations, including member management, workout plans, trainer management, feedback collection, and more.

## Features

- **Member Management**: Allows gym members to be registered, their workout plans assigned, and feedback collected.
- **Trainer Management**: Trainers can be added, updated, and assigned to workout plans for members.
- **Workout Plans**: Members can receive personalized workout plans, with daily exercises based on the trainer's strategy.
- **Feedback System**: Allows members and trainers to provide feedback on workout plans and services.

## Technologies Used

- **Backend**: Java 21, Spring Boot 3.x
- **Database**: MongoDB (NoSQL)
- **Design Patterns**: Singleton, Factory Method, Strategy, Template Method, Observer (Potential)

## Functional Requirements

1. **Member Service**: 
   - Create, update, delete, and find members.
   - Assign and manage workout plans.
   
2. **Trainer Service**:
   - Create, update, delete, and find trainers.
   - Assign trainers to workout plans.

3. **Workout Plan Service**:
   - Create, update, delete, and find workout plans.
   - Apply different workout strategies to members.
   
4. **Feedback Service**:
   - Collect, update, delete, and view feedback from members and trainers.

## Non-Functional Requirements

1. **Scalability**: The system should be able to handle multiple members, trainers, and workout plans concurrently.
2. **Reliability**: Ensure that the application is reliable and provides consistent performance even under high loads.

## Setup Instructions

### Prerequisites

- **Java 21** or higher installed.
- **Maven** (for dependency management and building the project).
- **MongoDB** instance running locally or remotely.

### Setup MongoDB

Make sure your MongoDB instance is running locally or configure it in the `application.properties` file:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/gympulse_db
```

### Build and Run the Application

1. **Using Maven**:

```bash
mvn clean install
mvn spring-boot:run
```

2. **Directly via Spring Boot**:

```bash
mvn spring-boot:run
```

This will start the application on port `4040` by default.

### API Documentation

The application exposes REST APIs for managing members, trainers, workout plans, and feedback. Here are some of the key endpoints:

1. **Members**:
   - `POST /api/members`: Create a new member.
   - `GET /api/members`: Get all members.
   - `GET /api/members/{id}`: Get a member by ID.
   - `PUT /api/members/{id}`: Update member information.
   - `DELETE /api/members/{id}`: Delete a member by ID.

2. **Trainers**:
   - `POST /api/trainers`: Create a new trainer.
   - `GET /api/trainers`: Get all trainers.
   - `GET /api/trainers/{id}`: Get a trainer by ID.
   - `PUT /api/trainers/{id}`: Update trainer information.
   - `DELETE /api/trainers/{id}`: Delete a trainer by ID.

3. **Workout Plans**:
   - `POST /api/workoutplans`: Create a new workout plan.
   - `GET /api/workoutplans`: Get all workout plans.
   - `GET /api/workoutplans/{id}`: Get a workout plan by ID.
   - `DELETE /api/workoutplans/{id}`: Delete a workout plan by ID.

4. **Feedback**:
   - `POST /api/feedback`: Create feedback for a workout plan.
   - `GET /api/feedback`: Get all feedbacks.
   - `GET /api/feedback/{id}`: Get feedback by ID.
   - `PUT /api/feedback/{id}`: Update feedback by ID.
   - `DELETE /api/feedback/{id}`: Delete feedback by ID.

## Design Patterns Used

1. **Singleton Pattern**: Used in the `GymLogger` class to ensure a single instance is used for logging.
2. **Factory Method Pattern**: Used in `MemberService` and `TrainerService` to centralize object creation.
3. **Strategy Pattern**: Used in `WorkoutPlanService` to apply different workout strategies.
4. **Template Method Pattern**: Used in `FeedbackService` to define a consistent workflow for operations.
5. **Observer Pattern (Potential)**: Could be implemented for workout plan updates to notify observers (members, trainers).

## Architecture

- **Microservices**: The system can be extended in the future to a microservice-based architecture.
- **MongoDB** is used as the database due to its flexibility and ease of scaling.

## Quality Attributes

1. **Performance**: The system is designed to handle large volumes of data due to its use of MongoDB, which scales horizontally.
2. **Maintainability**: Use of design patterns such as Factory Method, Singleton, and Strategy promotes code maintainability and extensibility.
3. **Scalability**: The application is designed to scale horizontally, especially due to MongoDB's NoSQL nature.


## Conclusion

This project provides a solid foundation for a gym management system, with all essential features for managing members, trainers, workout plans, and feedback. The use of design patterns, a robust architecture, and a clear separation of concerns makes it a flexible and scalable system.

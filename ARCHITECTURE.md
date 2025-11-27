# eVite - Android Project Architecture

## Project Overview
Evite is a native Android application built with Kotlin and Jetpack Compose. It follows the recommended Android architecture guidelines (MVVM/Clean Architecture).

## Tech Stack
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Navigation**: Jetpack Navigation Compose
- **Architecture**: MVVM (Model-View-ViewModel)

## Folder Structure

```
com.example.evite
├── di/                  # Dependency Injection (Hilt/Koin) - To be implemented
├── data/                # Data Layer (Repositories, API, Room) - To be implemented
├── domain/              # Domain Layer (Use Cases, Models) - To be implemented
└── ui/                  # Presentation Layer
    ├── auth/            # Authentication Screens (Login, Register)
    ├── components/      # Reusable UI Components
    ├── navigation/      # Navigation Graph
    ├── theme/           # App Theme (Colors, Typography)
    ├── home/            # Home Screens - To be implemented
    ├── events/          # Event Management Screens - To be implemented
    └── profile/         # Profile Screens - To be implemented
```

## Implementation Status

### ✅ Completed
1.  **Authentication UI**:
    -   `LoginScreen.kt`: Login UI with validation.
    -   `RegisterScreen.kt`: Registration UI with validation.
    -   `EviteTextField.kt`: Custom text field component.
    -   `EviteButton.kt`: Custom button component.
2.  **Navigation**:
    -   `NavGraph.kt`: Basic navigation between Login and Register.
3.  **Theming**:
    -   `Theme.kt`, `Color.kt`, `Type.kt`: App styling matching the design.

### 📝 To Be Implemented by Team

1.  **Data Layer**:
    -   Implement API calls (Retrofit/Ktor).
    -   Implement local storage (Room/DataStore).
    -   Create Repository implementations.

2.  **Domain Layer**:
    -   Define Data Models (Event, User, Invitation).
    -   Define Repository interfaces.
    -   Implement Use Cases.

3.  **Dependency Injection**:
    -   Set up Hilt or Koin for dependency injection.

4.  **View Models**:
    -   Create ViewModels for each screen to handle state and business logic.

5.  **Remaining Screens**:
    -   Home Dashboard.
    -   Create/Edit Event.
    -   Event Details.
    -   Profile Management.

## Use Case Mapping

-   **Sign in / Register**: `ui/auth/LoginScreen.kt`, `ui/auth/RegisterScreen.kt`
-   **Create Event**: `ui/events/CreateEventScreen.kt` (TODO)
-   **View Event List**: `ui/home/HomeScreen.kt` (TODO)
-   **View Profile**: `ui/profile/ProfileScreen.kt` (TODO)

## Getting Started

1.  Open the project in Android Studio.
2.  Sync Gradle files.
3.  Run the app on an emulator or physical device.

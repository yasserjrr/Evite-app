# eVite Developer Guide 📘

This document serves as a technical guide for the development team. It details the project structure, design system, reusable components, and the workflow for adding new screens.

---

## 1. Project Structure 📂

The project follows the standard Android project structure.
- **Source Code**: `app/src/main/java/com/evite/`
- **Package Name**: `com.evite`

### Key Directories
- `ui/auth/`: Authentication screens (Login, Register).
- `ui/components/`: **Reusable UI widgets** (Buttons, TextFields). Use these!
- `ui/theme/`: Color palette, Typography, and Theme definitions.
- `ui/navigation/`: The central navigation graph.

---

## 2. Design System 🎨

We use a custom implementation of Material Design 3. Always use the defined theme values instead of hardcoding hex codes or text sizes.

### Colors
Defined in `ui/theme/Color.kt`. Access them directly or via `MaterialTheme.colorScheme`.

| Name | Usage |
|------|-------|
| `PrimaryBlue` | Main buttons, active elements, branding. |
| `DarkText` | Primary text color. |
| `MediumGray` | Secondary text, placeholders, icons. |
| `LightGray` | Input field backgrounds, borders. |
| `ErrorRed` | Error messages, validation states. |

**Example:**
```kotlin
import com.evite.ui.theme.PrimaryBlue

Text(text = "Hello", color = PrimaryBlue)
```

### Typography
Defined in `ui/theme/Type.kt`. Access via `MaterialTheme.typography`.

| Style | Usage |
|-------|-------|
| `headlineLarge` | Main page titles (e.g., "Welcome Back"). |
| `headlineMedium` | Section headers. |
| `bodyLarge` | Standard body text. |
| `bodyMedium` | Smaller text, hints. |

**Example:**
```kotlin
Text(
    text = "Page Title",
    style = MaterialTheme.typography.headlineLarge
)
```

---

## 3. Reusable Components 🧩

Use these components to ensure consistency across the app.

### `EviteButton`
A standard primary button with rounded corners and brand color.

**Parameters:**
- `text`: String - The label on the button.
- `onClick`: () -> Unit - Function to call when clicked.
- `modifier`: Modifier (Optional) - For padding, sizing, etc.
- `enabled`: Boolean (Default: true) - Set to false to disable interaction.

**Usage:**
```kotlin
EviteButton(
    text = "Create Event",
    onClick = { viewModel.createEvent() },
    enabled = !isLoading
)
```

### `EviteTextField`
A standardized input field with support for icons, passwords, and error states.

**Parameters:**
- `value`: String - Current text value.
- `onValueChange`: (String) -> Unit - Callback when text changes.
- `placeholder`: String - Hint text shown when empty.
- `leadingIcon`: ImageVector - Icon shown at the start (e.g., `Icons.Outlined.Email`).
- `isPassword`: Boolean (Default: false) - If true, hides text and shows toggle eye icon.
- `error`: String? (Optional) - If provided, shows the field in red with error text below.

**Usage:**
```kotlin
EviteTextField(
    value = email,
    onValueChange = { email = it },
    placeholder = "Enter email",
    leadingIcon = Icons.Outlined.Email,
    error = emailError // Pass null if no error
)
```

---

## 4. Navigation 🧭

We use **Jetpack Navigation Compose**. The graph is defined in `ui/navigation/NavGraph.kt`.

### Adding a New Screen
1.  **Create the Screen**: Create your Composable in the appropriate folder (e.g., `ui/home/HomeScreen.kt`).
    ```kotlin
    @Composable
    fun HomeScreen(navController: NavController) { ... }
    ```
2.  **Register the Route**: Open `NavGraph.kt` and add a new `composable` entry.
    ```kotlin
    NavHost(navController = navController, startDestination = "login") {
        // ... existing routes
        
        composable("home") {
            HomeScreen(navController = navController)
        }
    }
    ```
3.  **Navigate**: Use the `navController` to move to your new screen.
    ```kotlin
    navController.navigate("home")
    ```

---

## 5. Workflow: Creating a New Feature 🚀

**Scenario**: You need to build the "Create Event" page.

1.  **Create File**: New file `ui/events/CreateEventScreen.kt`.
2.  **Scaffold**: Start with a `Scaffold` to get the basic page layout.
3.  **Top Bar**: Add a `TopAppBar` if needed (copy style from `RegisterScreen.kt`).
4.  **Content**:
    - Use `Column` for vertical layout.
    - Use `EviteTextField` for the event name, location, etc.
    - Use `EviteButton` for the "Save" action.
5.  **State**: Use `remember { mutableStateOf("") }` for local state or a ViewModel for complex logic.
6.  **Navigation**: Add `"create_event"` to `NavGraph.kt`.

### Example Template
```kotlin
@Composable
fun CreateEventScreen(navController: NavController) {
    var title by remember { mutableStateOf("") }

    Scaffold(
        topBar = { /* ... */ }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text("New Event", style = MaterialTheme.typography.headlineLarge)
            
            EviteTextField(
                value = title,
                onValueChange = { title = it },
                placeholder = "Event Title",
                leadingIcon = Icons.Outlined.Event
            )
            
            EviteButton(
                text = "Save",
                onClick = { /* Save logic */ }
            )
        }
    }
}
```

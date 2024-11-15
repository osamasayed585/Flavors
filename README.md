# **Flavors**

This project demonstrates the usage of **Build Types** and **Product Flavors** in an Android application to customize functionality and dependencies for different versions of the app. The aim is to showcase how to use flavor-specific logic, libraries, and resources effectively.

---

## **Goals**

### 1. Understanding Build Types
- Separate **Debug** and **Release** versions to optimize builds for development and production.
- Customize configurations like `isDebuggable`, minification, and signing based on the build type.

### 2. Implementing Product Flavors
- Create distinct **Free** and **Paid** versions of the app, each with its own:
  - Features.
  - Dependencies.
  - Resources.

### 3. Flavor-Specific Libraries
- Demonstrate how to include libraries that are specific to each flavor:
  - **Free Version:** Includes `play.services.measurement.api` for tracking (placeholder logic).
  - **Paid Version:** Includes `Retrofit` and `Gson` for making API calls.

### 4. Flavor-Specific Logic
- Implement unique features and behaviors for each flavor using isolated logic:
  - **Free Version:** Logs a feature usage string (using a placeholder for analytics).
  - **Paid Version:** Simulates an API call using Retrofit (placeholder for network logic).

---

## **Project Structure**
src/
├── free/
│   ├── java/
│   │   └── com/osama/flavors/FreeAction.kt
│   │   └── com/osama/flavors/FreeFeature.kt
│   └── ...
├── paid/
│   ├── java/
│   │   └── com/osama/flavors/PaidAction.kt
│   │   └── com/osama/flavors/PaidFeature.kt
│   └── ...
├── main/
│   ├── java/
│   │   └── com/osama/flavors/MainActivity.kt
│   │   └── com/osama/flavors/FlavorAction.kt
│   └── ...


### Key Files:
- **`FlavorAction.kt` (main):**  
  Common interface implemented by flavor-specific classes.
- **`FreeAction.kt` (free):**  
  Logic specific to the free version.
- **`PaidAction.kt` (paid):**  
  Logic specific to the paid version.
- **`MainActivity.kt` (main):**  
  Handles flavor detection and executes flavor-specific logic.

---

## **Features**

### **Free Version**
- Uses **`play.services.measurement.api`** (placeholder for analytics).
- Implements `FreeFeature` to log usage:
  ```kotlin
  class FreeFeature {
      fun logFreeFeatureUsage(): String {
          return "Free feature usage logged using Play Services"
      }
  }



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

```
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
```

---

## **Features**

### Free Version
- Uses `play.services.measurement.api` (placeholder for analytics).
- Implements `FreeFeature` to log usage:
  ```kotlin
  class FreeFeature {
      fun logFreeFeatureUsage(): String {
          return "Free feature usage logged using Play Services"
      }
  }
  ```

### Paid Version
- Uses Retrofit and Gson for simulated API calls.
- Implements `PaidFeature` to create a Retrofit instance:
  ```kotlin
  class PaidFeature {
      fun createRetrofitInstance(): Retrofit {
          return Retrofit.Builder()
              .baseUrl("https://jsonplaceholder.typicode.com/")
              .addConverterFactory(GsonConverterFactory.create())
              .build()
      }

      fun makeDummyApiCall(): String {
          return "Dummy API call setup using Retrofit"
      }
  }
  ```

---

## **How to Build and Run**

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-repo/Flavors.git
   cd Flavors
   ```

2. **Open the project in Android Studio.**

3. **Select a Build Variant:**
   - Go to **Build Variants** in the side panel.
   - Choose:
     - `freeDebug` for the Free version.
     - `paidDebug` for the Paid version.

4. **Run the app:**
   - Click the "Run" button in Android Studio.
   - Observe the behavior based on the selected flavor.

---

## **Expected Behavior**

### Free Version (`freeDebug`)
- Button click shows:  
  `"Free feature usage logged using Play Services"`

### Paid Version (`paidDebug`)
- Button click shows:  
  `"Dummy API call setup using Retrofit"`

---

## **Key Learnings**

1. **Customization with Build Types and Product Flavors:**
   - Build Types for debugging and production optimizations.
   - Product Flavors for flavor-specific behavior and libraries.

2. **Dependency Management:**
   - Use `freeImplementation` and `paidImplementation` to add flavor-specific dependencies.

3. **Flavor-Specific Logic:**
   - Isolate logic for each flavor using separate source sets.

4. **Code Reusability:**
   - Shared logic and interfaces in `src/main`.

---

## **Future Improvements**

- Add more realistic use cases for the libraries (e.g., real API integration for the Paid version).
- Include flavor-specific resources like strings, icons, or themes.
- Extend flavors to support additional versions (e.g., "Enterprise").

---
Enjoy building! 🚀

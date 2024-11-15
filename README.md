
# **Flavors**

This project shows how to use **Build Types** and **Product Flavors** in Android. It helps you create different versions of your app (like Free and Paid) with specific features, libraries, and logic.

---

## **What You Will Learn**

1. **Build Types**:
    - Use different settings for Debug and Release versions.
2. **Product Flavors**:
    - Create versions like Free and Paid with different features.
3. **Flavor-Specific Libraries**:
    - Add libraries only for a specific version.
4. **Flavor-Specific Logic**:
    - Write code that works differently for each version.

---

## **Project Structure**

```
src/
├── free/
│   ├── java/
│   │   └── com/osama/flavors/FreeAction.kt
│   │   └── com/osama/flavors/FreeFeature.kt
├── paid/
│   ├── java/
│   │   └── com/osama/flavors/PaidAction.kt
│   │   └── com/osama/flavors/PaidFeature.kt
├── main/
│   ├── java/
│   │   └── com/osama/flavors/MainActivity.kt
│   │   └── com/osama/flavors/FlavorAction.kt
```

---

## **How to Run**

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-repo/Flavors.git
   cd Flavors
   ```

2. **Open in Android Studio**.

3. **Select Build Variant**:
    - `freeDebug` for the Free version.
    - `paidDebug` for the Paid version.

4. **Run the app**.

---

## **What Happens**

- **Free Version**:
    - Logs feature usage using Play Services (example logic).
- **Paid Version**:
    - Simulates API calls using Retrofit and Gson.

---

## **Feedback**

If you like the project, don't forget to give it a ⭐ on GitHub!

---

Enjoy! 🚀

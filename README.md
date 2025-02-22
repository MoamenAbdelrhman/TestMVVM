# 🍽️ Meal Categories App - MVVM (Model-View-ViewModel)

This project implements **Model-View-ViewModel (MVVM)** architecture in an Android app.  
It fetches meal categories from **TheMealDB API** and allows users to **add/remove favorites**.

---

## 📌 Features
✅ Fetch meal categories from **TheMealDB API**  
✅ Display categories in a **RecyclerView**  
✅ Add categories to **Favorites (Room Database)**  
✅ Remove categories from Favorites  
✅ Uses **LiveData** to update UI automatically  
✅ Implements **ViewModelFactory** for dependency injection  

---

## ✅ Benefits of MVVM
- **LiveData automatically updates UI**.
- **ViewModel survives configuration changes**.
- **Better separation of concerns**.
- **Easier to test than MVP**.

## ❌ Drawbacks of MVVM
- **Slightly more complex than MVP**.
- **Requires understanding of LiveData & ViewModel**.

---

---

## 🚀 Installation Guide
### **🔹 Clone the Repository**
```sh
git clone https://github.com/your
```

📌 API Used
This project uses TheMealDB API to fetch meal categories.

Base URL:
```sh
https://www.themealdb.com/api/json/v1/1/
```

🔹 Open in Android Studio
Open Android Studio
Click "Open an Existing Project"
Select TestMVVM
Sync Gradle and Run! 🚀

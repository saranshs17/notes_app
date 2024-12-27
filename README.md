# Notes App

## Overview
A fully functional **Notes App** built with **Jetpack Compose** following the **Clean Architecture** principles for Android, hosted on **Render**. The app integrates a **Node.js** backend and utilizes **MongoDB** as its database.

---

## Features
- **Create, Read, Update, and Delete (CRUD)** operations for notes.
- Prioritize notes with options like High, Medium, or Low.
- Seamless user experience with a modern UI designed using Jetpack Compose.
- Secure and scalable backend hosted on Render.
- Real-time data synchronization with MongoDB.

---

## Tech Stack
### Frontend (Android):
- **Jetpack Compose**: Declarative UI toolkit for building native Android UIs.
- **Clean Architecture**: Ensures maintainability and scalability by dividing the code into clear layers.
  - **Presentation Layer**: Jetpack Compose and ViewModels.
  - **Domain Layer**: Use cases and business logic.
  - **Data Layer**: Repositories and Room Database.

### Backend:
- **Node.js**: JavaScript runtime for building fast and scalable server-side applications.
- **Express.js**: Web framework for handling routes and APIs.
- **MongoDB**: NoSQL database for efficient and flexible data storage.

### Hosting:
- **Render**: Hosting platform for the backend, providing a public API endpoint accessible from the Android app.

---

## Setup Instructions

### Prerequisites
1. Android Studio installed on your machine.
2. Node.js and npm installed.
3. MongoDB instance (cloud-hosted on MongoDB Atlas or local setup).
4. A Render account for hosting the backend.

### Backend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/notes-app-backend.git
   cd notes-app-backend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Create a `.env` file for environment variables:
   ```plaintext
   PORT=3000
   MONGO_URI=mongodb+srv://<username>:<password>@cluster.mongodb.net/<dbname>?retryWrites=true&w=majority
   ```

4. Start the server:
   ```bash
   npm start
   ```

5. Deploy to Render:
   - Link your repository to Render.
   - Set up environment variables (`PORT`, `MONGO_URI`) in Render's settings.

### Frontend Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/notes-app-frontend.git
   ```

2. Open the project in Android Studio.

3. Replace `YOUR_BASE_URL` in `gradle.properties` with your Render base URL:
   ```properties
   BASE_URL=https://your-backend-url.onrender.com
   ```

4. Build and run the app on an Android device or emulator.

---

## API Endpoints
### Base URL:
```
https://your-backend-url.onrender.com
```

### Endpoints:
- **GET /notes**: Fetch all notes.
- **POST /save-notes**: Create a new note.
- **GET /save-dummy-note**: Save a dummy note for testing.

---

## Contributions
Contributions are welcome! Feel free to submit issues or pull requests to enhance the app.

---


<p align="center">
    <a href="" rel="noopener">
    <img src="https://www.metropolitan.ac.rs/files/2024/05/tech-inno-vest.jpg" alt="Met Tech Inno Day"></a>
</p>
<h2 align="center">Met Tech Inno Day 2024</h2>

---

<h3 align="center">Prerequisites</h3>
- Java 11 or higher
- JavaFX SDK

<h3 align="center">Running the Application</h3>

1.Clone the repository:
```bash
git clone https://github.com/Nosalis1/JavaRadionica.git
```

2.Navigate to the project directory:
```bash
cd Editor
```

3.Build and run the application:
```bash
./gradlew run
```

---

<h3 align="center">Project Structure</h3>

```
ImageEditor/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.metropolitan/
│   │   │       └── editor/
│   │   │           ├── MainApp.java                // Main entry point for the application
│   │   │           ├── controllers/                // Contains controllers that handle UI logic and user interactions
│   │   │           │   └── ...                     // Controller classes (e.g., ImageEditorController.java)
│   │   │           ├── models/                     // Contains model classes representing data structures
│   │   │           │   └── ...                     // Model classes (e.g., ImageModel.java)
│   │   │           ├── views/                      // Contains FXML files and view-related classes
│   │   │           │   └── ...                     // View classes or FXML files (e.g., ImageView.fxml)
│   │   │           ├── utils/                      // Contains utility classes with common functions
│   │   │           │   └── ...                     // Utility classes (e.g., FileUtil.java)
│   │   │           └── services/                   // Contains service classes for business logic and data access
│   │   │               └── ...                     // Service classes (e.g., ImageService.java)
│   │   └── resources/
│   │       ├── css/                                // Stylesheets for the application
│   │       │   └── ...                             // CSS files (e.g., styles.css)
│   │       ├── images/                             // Image resources used in the application
│   │       │   └── ...                             // Image files (e.g., logo.png)
│   │       ├── i18n/                               // Internationalization resource bundles
│   │       │   └── ...                             // Properties files for different languages (e.g., messages.properties)
│   │       └── fxml/                               // FXML files defining the UI layout
│   │           └── ...                             // FXML files (e.g., ImageView.fxml)
│   └── test/
│       ├── java/
│       │   └── metropolitan/
│       │       └── imageeditor/
│       │           ├── controllers/                // Test classes for controllers
│       │           │   └── ...                     // Test classes (e.g., ImageEditorControllerTest.java)
│       │           ├── models/                     // Test classes for models
│       │           │   └── ...                     // Test classes (e.g., ImageModelTest.java)
│       │           └── services/                   // Test classes for services
│       │               └── ...                     // Test classes (e.g., ImageServiceTest.java)
│       └── resources/                              // Resources needed for testing
│
├── README.md                                       // Documentation file for project description and usage instructions
└── .gitignore                                      // Git configuration file to ignore unnecessary files and directories
```

<p align="center">

</p>

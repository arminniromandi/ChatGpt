# ChatGPT Android App

An Android application built with Kotlin and Jetpack Compose that provides AI chat functionality.

## 📱 Features

- **AI Chat Interface** - Interactive chat interface powered by AI
- **Material 3 Design** - Modern UI following Material Design 3 guidelines
- **Offline Support** - Local database storage using Room
- **Dependency Injection** - Hilt for clean architecture
- **Network Layer** - Retrofit for API communication
- **Coroutines & Flow** - Asynchronous programming with Kotlin coroutines
- **SMS Integration** - SMS verification functionality
- **Prompt Library** - Save and manage custom prompts
- **Chat History** - View and manage conversation history
- **Settings** - Configurable app settings

## 🛠️ Tech Stack

### Core Technologies
- **Language**: Kotlin
- **UI Toolkit**: Jetpack Compose
- **Architecture**: MVVM with Clean Architecture principles
- **Min SDK**: 24 (Android 7.0)
- **Target SDK**: 36
- **Compile SDK**: 36

### Libraries & Dependencies
- **Jetpack Components**:
  - Navigation Compose
  - Room Database
  - LiveData
  - Lifecycle
  - Hilt Navigation

- **Networking**:
  - Retrofit
  - Gson Converter

- **Dependency Injection**:
  - Hilt (Dagger)

- **UI**:
  - Material 3
  - Lottie Animations
  - Compose Markdown

- **Async**:
  - Kotlin Coroutines

- **Database**:
  - Room (with KSP)

## 📁 Project Structure

```
app/
├── src/main/java/ir/arminniromandi/chatgpt/
│   ├── Api/
│   │   ├── ChatAi/          # AI Chat API implementation
│   │   └── sms/             # SMS API implementation
│   ├── di/                  # Dependency Injection modules
│   ├── ext/
│   │   ├── Connection/      # Network connectivity observer
│   │   └── util/            # Utility classes
│   ├── viewModel/           # ViewModels for screens
│   ├── dataBase/
│   │   ├── dao/             # Room DAOs
│   │   └── model/           # Database entities
│   ├── activity/            # Activities
│   └── ui/
│       └── Screens/         # Compose UI screens
│           ├── main/
│           │   ├── chat/
│           │   ├── History/
│           │   └── Setting/
│           ├── SignUp/
│           └── gymplanner/
└── src/main/res/            # Android resources
```

## ⚙️ Configuration

### API Keys

This project requires API keys for external services. Create a `gradle.properties` file in your local environment with:

```properties
API_AVAL_AI=your_ai_api_key_here
API_SMS_IR=your_sms_api_key_here
```

**Note**: Never commit these keys to version control. The project uses `buildConfigField` to securely inject these values at build time.

## 🚀 Getting Started

### Prerequisites
- Android Studio Hedgehog or later
- JDK 21
- Android SDK 36

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd ChatGpt
   ```

2. **Configure API keys**
   - Add your API keys to `gradle.properties` (see Configuration section)

3. **Sync Gradle**
   - Open the project in Android Studio
   - Let Gradle sync complete

4. **Build and Run**
   - Select an emulator or physical device (API 24+)
   - Click Run ▶️

## 🏗️ Building from Command Line

```bash
# Debug build
./gradlew assembleDebug

# Release build
./gradlew assembleRelease

# Run tests
./gradlew test

# Install on connected device
./gradlew installDebug
```

## 🧪 Testing

The project includes:
- Unit tests (JUnit)
- Instrumented tests (Espresso, Compose Test)

Run tests with:
```bash
./gradlew test
./gradlew connectedAndroidTest
```

## 📦 Project Info

- **Package Name**: `ir.arminniromandi.chatgpt`
- **Version**: 1.0 (versionCode: 1)
- **Application ID**: `ir.arminniromandi.chatgpt`

## 🔐 Permissions

The app requires the following permissions:
- `INTERNET` - For API communication
- `ACCESS_NETWORK_STATE` - For connectivity monitoring

## 📝 License

This project is proprietary software. All rights reserved.

## 👨‍💻 Author

Armin Niromandi

## 🤝 Contributing

This is a private project. For questions or issues, please contact the maintainer directly.

---

**Built with ❤️ using Kotlin & Jetpack Compose**

# Tic Tac Toe Android App

This is an Android version of the console-based XO (Tic Tac Toe) game.

## Project Structure

```
TicTacToeAndroid/
├── app/
│   ├── src/main/
│   │   ├── java/com/tictactoe/
│   │   │   ├── MainActivity.java       # Main game activity with UI logic
│   │   │   ├── Player.java             # Player class (from original)
│   │   │   ├── Marble.java             # Marble class for X/O pieces (from original)
│   │   │   └── PlaygroundXOGame.java   # Game board logic (from original)
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml   # Game UI layout
│   │   │   ├── values/
│   │   │   │   ├── strings.xml         # String resources
│   │   │   │   ├── colors.xml          # Color definitions
│   │   │   │   └── themes.xml          # App theme
│   │   │   └── mipmap-*/
│   │   │       └── ic_launcher.xml     # App icons
│   │   └── AndroidManifest.xml         # App configuration
│   ├── build.gradle                    # App-level build config
│   └── proguard-rules.pro              # ProGuard rules
├── gradle/wrapper/
│   └── gradle-wrapper.properties       # Gradle wrapper config
├── build.gradle                        # Project-level build config
└── settings.gradle                     # Project settings
```

## Features

- **Classic Tic Tac Toe gameplay** - Two players take turns placing X and O marks
- **Modern Material Design UI** - Dark theme with colorful accents
- **Win detection** - Automatically detects when a player wins
- **Draw detection** - Recognizes when the game ends in a draw
- **Play Again option** - Quick restart after each game
- **Turn indicator** - Shows whose turn it is
- **Responsive grid** - 3x3 button grid for easy touch interaction

## How to Build

1. Open Android Studio
2. Select "Open an existing project"
3. Navigate to the `TicTacToeAndroid` folder
4. Wait for Gradle sync to complete
5. Click "Run" to install on your device or emulator

## Requirements

- Android Studio Arctic Fox or later
- Android SDK 21 (Android 5.0) or higher
- Gradle 8.0

## Original Console Code

The game logic from the original console-based Java code has been preserved:
- `Player.java` - Player representation
- `Marble.java` - X/O game pieces  
- `PlaygroundXOGame.java` - Board state and win detection

The console input/output has been replaced with a graphical touch interface using Android Buttons and Dialogs.

## License

Free to use and modify.

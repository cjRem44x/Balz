# Balz
A fun 2D arcade game made with Java!

## Overview
Balz is a 2D arcade game built with Java, featuring a custom game engine architecture. The project has been restructured with a modular design separating game logic from the core engine.

## Project Structure
- `src/main/java/Main.java` - Entry point of the application
- `src/main/java/game/GameDriver.java` - Game driver that initializes and manages the game
- `src/main/java/game/engine/GameEngine.java` - Core game engine with main game loop
- `src/main/java/archived/` - Previous version components (v0.x)

## Recent Updates
- **v0.1**: Complete project restructuring with new game engine architecture
- Added modular game engine with proper game loop implementation
- Implemented GameDriver for game management
- Moved legacy code to archived directory
- Added comprehensive code documentation headers

## How to Run
### Automated
Use the shell script in ```./scripts/build.sh``` to run the project.
### Manually
```bash
javac src/main/java/*.java ... # there are other src paths to compile 
java -cp src main.java.Main
```

## Features
- Custom game engine with main loop
- Modular architecture for easy expansion
- Proper separation of concerns between game logic and engine

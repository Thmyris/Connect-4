
# Connect 4
A simple human vs human Connect 4 game, written in java. The game uses X and O's to represent yellow and red checkers. The in-game language is Turkish.

 <p align="center">
  <img src="https://user-images.githubusercontent.com/14177706/112196587-3e78a900-8c1c-11eb-8866-c5d32211a0e3.png">
</p>

## Playing
First make sure java is installed (version 8.x.x)
- **On Windows:** Simply run the `run jar.bat` file
- **On Linux:** Run the command ```java connect.Connect4``` from up a folder. Running it on where the `.class` files are won't work

## Building from source
Make sure `JDK 8` is installed and added to `PATH`. Then, open a terminal and navigate to where the `.java` files are:

1. Compile the `.class` files with: ```javac *.class```  
2. (Optional) If you wish to build the `.jar` file as well, you can use this command:  
```jar cmvf META-INF/MANIFEST.MF run.jar  *.class```  
The MANIFEST.mf file is already set.


### Changelog:  
v1.1:
- Removed useless IDE files and recompiled classes with `javac`
- Added an executable `.jar` file.  
- Added an executable `.bat` file for ease of use in windows
- Changed package name to 'connect'
- Not changed: Wanted to add an executable `.sh` file for Linux but you cannot execute shell files in Linux by double clicking them without giving them the 'executable' permission :/

v1.0:  
- Initial release

###### More Updates?
For the time being I consider this small weekend project done. I may come back to it to add an unbeatable AI (This is possible).

---

*I do not own the concept idea of "Connect 4" or any of its assets. Pls no sue :P*

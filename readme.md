# Connect 4
A simple connect 4 game, written in java, that can be played as human vs human. No AI was implemented. The game uses X and O's to represent  yellow and red checkers. The in-game language is Turkish.  
If you find any bugs please create an issue :)


## Playing
First make sure java is installed (version 8.x.x)
- In Windows: Simply run the 'run jar.bat' file.
- In Linux: Run the command ```java connect.Connect4``` from up a folder. Running it on where the .class files are won't work.  

## Building
To build from source, open a terminal window and navigate to where the .java files are:
0. Make sure JDK 8 is installed and added to PATH
1. Compile the .class files:
```javac *.class```  
2. (Optional) If you wish to build the .jar file as well, you can use this command:  
```jar cmvf META-INF/MANIFEST.MF run.jar  *.class```  
The MANIFEST.mf file is already set.


### Changelog:  
v1.1:
- Removed useless IDE files and recompiled classes with 'javac'.
- Added an executable .jar file.  
- Added an executable .bat file for windows for executing the .jar file, for convenience.  
- Changed package name to 'connect'.  
- Not changed: Wanted to add an executable .sh file for Linux but apparently you cannot execute shell files in GNU/Linux by double clicking them without giving them the 'executable' permission :/  

v1.0:  
- Initial release

# More Updates?
For the time being I consider this small weekend project done, will move on to other ventures.

## License  
I do not own the concept idea of "Connect 4" or any of its assets. Pls no sue :P

# Controller project
An attempt to connect a USB Gamepad controller to a Java application. I wanted to see how to get inputs from another kind of device.

## Info
This project is made runs with version 17 of Java.

You can run it on your pc with:
```
gradlew run
```

## State of work
Up to now, the program polls the controller continuously.
If the controller is disconnected after being initially detected,
a strange error from the library <span style=color:lightgreen><em>net.games.java.input</em></span> is printed. Also, the program doesn't currently support repeated connection and disconnection of the controller.

# UWG-SE2-Class-Example

This system will support cooks seeking to find recipes, plan meals, identify needed ingredients, and track dietary concerns such as protein, carbohydrate, or sugar intake. 

This system will also support cooks seeking to store recipes and recipe providers sharing recipes.

# Installation Instructions

## Meal Planning App
1 Install Java 10 (download from https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase10-4425482.html)

2 Install Eclipse Photon (download from eclipse.org)

3 Install JavaFX plugin via Eclipse MArketplace (help->Eclipse Marketplace, search for 'javafx')

4 Clone project (File->Import, Git->Projects from Git, Clone URI, enter uri for project and select finish)

### (optional) SceneBuilder

1 Download SceneBuilder from https://gluonhq.com/products/scene-builder/

2 Configure Eclipse to use SceneBuilder (Window->Preferences, JavaFX, enter the location of the SceneBuilder executable)

## RecipeServer

1 Install Python 3.X (download from python.org)

2 Install ZMQ 4.X (download from http://zeromq.org/intro:get-the-software)  

3 Install Install PyZMQ (from cmd line: python -m pip install pyzmq)

4 Install PyDev via Eclipse Marketplace (help->Eclipse Marketplace, search for 'pydev')

### (optional) PyDev Code Coverage 

1 Install coverage module for python (from cmd line: python -m pip install coverage)

2 Open the Code Coverage window for PyDev (Window->Show View->Other, PyDev->Code Coverage)

3 Configure Code Coverage (In Code Coverage view elect Choose folder to analyze, select Python Server project src folder, check Enable code coverage for new launches)

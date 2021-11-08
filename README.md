# Command Line Drawer Application
__Description__
<br >
This is a command line drawer application.

<br >
This application does the following:<br >
1. Creates a canvas <br >
2. Draws various shapes [line, rectangle, fill area with colour] onto the created Canvas <br >
3. Quits application<br >

<br >
The first char of the instruction describes the command. Each command might have some -- space separated -- parameters
the commands.<br ><br >

|Command 		|Description|
|----|----|
|C w h|Create new canvas (w: width, h: heigh)|
|L x1 y1 x2 y2|Draw a line (only vertical and horizontal lines are supported)|
|R x1 y1 x2 y2|Draw a rectangle|
|F x y c|Fill the connected area with c colour from x, y coordinates|
|Q|Quit|
<br >

__Assumptions__
1. Throw error if user tries to create shape before Canvas is created
2. New lines drawn are from (x1,y1) to (x2,y2)
3. Rectangles are drawn from upper left corner (x1,y1) to lower right corner (x2,y2)
4. Colour filler is built with the colour filler from Paint (Windows OS application) in mind

<br >

__Other information__
<br >
Points outside to the canvas are transferred to the closest edge points.
<br ><br >
 
__Build__
<br > 
To build an executable Jar, run the following maven command in the project root directory:<br >
$ mvn clean package

It will create a jar CommandLineDrawer.jar in <project root>/target directory.
<br ><br >

__Execution__
<br >
To execute the program:<br >
$ java -jar CommandLineDrawer.jar
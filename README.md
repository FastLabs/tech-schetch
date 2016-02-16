## Sketch Tech
Is a text based rendering engine prototype. Explores some aspects of OOP.
Supports the commands:
- create canvas
- render a line (only horizontal and vertical supported)
- render rectangle 
##Problem
You can find the problem description in ./docs/tech-schetch-requirements.pdf document

**Altered the original problem** the coordinates start from **0** I thought that this will me more consistent with other rendering engines 
(although complicated a little some aspects of the code). 
 
##High level solution
The diagram below ilustrates the main components of the application and their interactions
<pre>
Available Cmmands
+----------------------+     +---------------------------------+
| Line Command         |     |                                 |
+----------------------+     | +----------------------------+  |
+----------------------+     | |                            |  |
|Rectangle Command     |     | | +--------+   +----------+  |  |        +---------------+
+----------------------+     | | | canvas +---> Renderer +-------------->System Console |
+----------------------+     | | +--------+   +----------+  |  |        +-------+-------+
|Bucket Fill Command   |     | |                            |  |                |
+----------------------+     | | Graphic Shell              |  |                |
|Create Canvas Command |     | +-^---------^----------------+  |                |
+----------------------+     |   |         |                   |                |
                             |   |         |                   |          +-----v-------+
                             |   |Exec Cmd |New Canvas         <----------+ Sketch REPL |
                             |   +         +                   |          +-------------+
                             |  Sketch Command Processor       |
                             +---------------------------------+
<pre>
- Sketch REPL : has the role of Read Evaluate Print Loop component that reads the literal commands from the System Console and passes them for execution to the Sketch **Sketch Command Processor** component. The REPL will terminate the loop when **Exit Command** is received.
- **Sketch Command Processor** parses validates and if valid pases the command for execution to the **Graphic Shell** component.
- **Graphic Shell** executes a graphic command and sends the results to the renderer
- **Canvas** represents the rendering area
- **Renderer** renders the canvas onto specific output, in this case system console 

##Implementation details
Class diagram is provided in: ./docs/class-diagram.png
Test coverage is provided in: ./docs/tech-sketch-coverage.png 
**Note:** I think the command validation and error management should be improved a little.
Side effect classes that are not covered by the unit tests: Main and SketchRepl 

##Execution
Git and Apache Maven is required
Current released version is branched as RELEASE1, please run: **git checkout RELEASE1**
Execute the application with the following command: **mvn clean compile exec:java**

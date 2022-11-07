# Todo

## backlog

Shape:

+ Line types:
  + line
- Surface types:
  + rectangle
  + circle
  - ellipse
+ Text:
  + text

InformationPanel:

- shape type
- colour
- possible line length
- possible area
- possible text
- z-order (+/-) buttons

- User creates a Shape:

  - by clicking on a button,
  - then draws the shape on the drawing board using the mouse
  - the order in which Shapes are created determines the z-order

- User sees InformationPanel:

  - by clicking on a shape
  - then the InformationPanel appears on the right hand side

- User changes Shape fillColor:

  - by launching InformationPanel
  - by clicking on the colorPicker box corresponding to fillColor

- User changes Shape strokeColor:

  - by launching InformationPanel
  - by clicking on the colorPicker box corresponding to strokeColor

- User moves the shape in the x,y plane:

  - by clicking on it and dragging it
  - when Shapes overlap, the Shape with highest z-order is selected

- User changes the z-order of the shape in the z plane:

  - by launching InformationPanel
  - by clicking on the z-order buttons

- Programmer must use JavaDoc

## Commands

```bash
# compile application
mvn compile

# compile and run application
mvn package && java --module-path 'C:\Program Files\Java\javafx-sdk-19\lib' --add-modules javafx.controls,javafx.fxml  -jar target/PaintApp-1.0-SNAPSHOT.jar
```

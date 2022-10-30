# Paint App

## Design

what features:

- line
- rectangle
- circle
- text

user input: - change shape size - change shape position - change shape color

input -> process -> output

inputs data:
line:
start_x, start_y, end_x, end_y
rectangle:
start_x, start_y, end_x, end_y

circle:
x, y, radius
text:
x, y, fontSize, text

find data common to all inputs, organize
shape: - color - size - start_x, start_y

organize the groups into an oop structure:
shape <- line:
private:
end_x, end_y

    code:
      - given size, compute end_x,y

rectangle:
private:
end_x, end_y
code:
given size, compute end_x,y

circle:
code:
given size, compute radius

text:
code:
given size, compute fontSize

when you have a question:

1. read the documentation
2. find code similar to your problem (stack overflow)
3. ask a collegue (classmate)
4. ask your tech lead (professor/ta)

## Reference

- [Color Picker](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ColorPicker.html)
- [class Color](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/paint/Color.html)
- [Line](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/Line.html)

## Commands

```bash
mvn prettier:write   # format source files
mvn package          # compile application
# run application
java --module-path 'C:\Program Files\Java\javafx-sdk-19\lib' --add-modules javafx.controls,javafx.fxml  -jar target/PaintApp-1.0-SNAPSHOT.jar
```

## Questions

- what data type should I use to store color?

  - string
  - tuple of RGB: (0,0,255)
  - tuple of HSV: (270,1.0,1.0)

- what data type do i need to use to tell JavaFX what color something is?

  - ans: Color data type

- set the color of a LIne, what data do i need to pass to Java FX?

  - ans:
    ```
    line.setStroke(Color.RED);
    ```

- How do I paint a line with javafx?
  ans: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/canvas/GraphicsContext.html

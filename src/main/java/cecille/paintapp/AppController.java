package cecille.paintapp;

import cecille.paintapp.model.Circle;
import cecille.paintapp.model.Line;
import cecille.paintapp.model.Rectangle;
import cecille.paintapp.model.Shape;
import cecille.paintapp.model.Text;
import java.io.IOException;
import java.lang.Object;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class AppController {
  @FXML
  private Pane sketch;

  @FXML
  private Label lblShapeType;

  @FXML
  private Label lblShapeColor;

  @FXML
  private Label lblShapeStat;

  @FXML
  private Label lblShapeCoordinates;

  @FXML
  private ColorPicker cpFill;

  @FXML
  private ColorPicker cpStroke;

  /*** shape creation */
  private enum ShapeType {
    LINE,
    RECTANGLE,
    CIRCLE,
    ELLIPSE,
    TEXT
  }

  private double createStartX, createStartY;
  private boolean userInitiatedCreateShape = false;
  private ShapeType createShapeOfType = ShapeType.RECTANGLE;

  /*** existing shape management */
  private Shape currentModelShape = null;
  private List<Shape> modelShapeList = new LinkedList<Shape>();

  @FXML
  public void initialize() {
    cpStroke.setValue(Color.BLACK);
  }

  public void setCurrentShape(Shape shape) {
    if (currentModelShape != null) {
      // turn off visual indicator
      currentModelShape.jfx.setStrokeWidth(1d);
    }

    currentModelShape = shape;

    if (currentModelShape != null) {
      // turn on visual indicator
      currentModelShape.jfx.setStrokeWidth(3d);

      currentModelShape.updateInformation(
        lblShapeType,
        lblShapeColor,
        lblShapeStat,
        lblShapeCoordinates,
        cpFill,
        cpStroke
      );
    }
  }

  @FXML
  private void sketchMousePressed(MouseEvent event) throws IOException {
    this.createStartX = event.getX();
    this.createStartY = event.getY();
  }

  @FXML
  private void sketchMouseDragged(MouseEvent event) throws IOException {
    this.userInitiatedCreateShape = true;
    sketch.setCursor(Cursor.CROSSHAIR);
  }

  @FXML
  private void sketchMouseReleased(MouseEvent event) throws IOException {
    if (this.userInitiatedCreateShape) {
      this.userInitiatedCreateShape = false;
      sketch.setCursor(Cursor.DEFAULT);

      // create shape
      Shape modelShape = null;

      switch (createShapeOfType) {
        case LINE:
          modelShape =
            new Line(
              this.createStartX,
              this.createStartY,
              event.getX(),
              event.getY(),
              cpFill.getValue(),
              cpStroke.getValue()
            );
          break;
        case RECTANGLE:
          modelShape =
            new Rectangle(
              this.createStartX,
              this.createStartY,
              event.getX(),
              event.getY(),
              cpFill.getValue(),
              cpStroke.getValue()
            );
          break;
        case CIRCLE:
          modelShape =
            new Circle(
              this.createStartX,
              this.createStartY,
              event.getX(),
              event.getY(),
              cpFill.getValue(),
              cpStroke.getValue()
            );
          break;
        case ELLIPSE:
          break;
        case TEXT:
          modelShape =
            new Text(
              this.createStartX,
              this.createStartY,
              event.getX(),
              event.getY(),
              cpFill.getValue(),
              cpStroke.getValue()
            );
          break;
      }

      if (modelShape != null) {
        modelShapeList.add(modelShape);

        // update gui
        modelShape.jfx.setCursor(javafx.scene.Cursor.MOVE);
        modelShape.jfx.setOnMousePressed(this::shapeMousePressed);
        modelShape.jfx.setOnMouseDragged(this::shapeMouseDragged);
        this.sketch.getChildren().add(modelShape.jfx);

        this.setCurrentShape(modelShape);
      }
    }
  }

  private double moveStartX, moveStartY, translateX, translateY;

  private void shapeMousePressed(MouseEvent event) {
    event.consume();

    // set current shape
    final Object eventFromJfxShape = event.getSource();
    for (Shape modelShape : modelShapeList) {
      if (modelShape.jfx == eventFromJfxShape) {
        this.setCurrentShape(modelShape);
        break;
      }
    }

    moveStartX = event.getSceneX();
    moveStartY = event.getSceneY();
    translateX = currentModelShape.jfx.getTranslateX();
    translateY = currentModelShape.jfx.getTranslateY();
  }

  private void shapeMouseDragged(MouseEvent event) {
    event.consume();

    double offsetX = event.getSceneX() - moveStartX;
    double offsetY = event.getSceneY() - moveStartY;
    currentModelShape.jfx.setTranslateX(translateX + offsetX);
    currentModelShape.jfx.setTranslateY(translateY + offsetY);
  }

  @FXML
  private void toggleToLine() throws IOException {
    this.createShapeOfType = ShapeType.LINE;
  }

  @FXML
  private void toggleToArc() throws IOException {}

  @FXML
  private void toggleToPolyLine() throws IOException {}

  @FXML
  private void toggleToRectangle() throws IOException {
    this.createShapeOfType = ShapeType.RECTANGLE;
  }

  @FXML
  private void toggleToCircle() throws IOException {
    this.createShapeOfType = ShapeType.CIRCLE;
  }

  @FXML
  private void toggleToEllipse() throws IOException {
    this.createShapeOfType = ShapeType.ELLIPSE;
  }

  @FXML
  private void toggleToPolygon() throws IOException {}

  @FXML
  private void toggleToText() throws IOException {
    this.createShapeOfType = ShapeType.TEXT;
  }

  @FXML
  private void zorderDown() throws IOException {
    if (currentModelShape != null) {
      currentModelShape.jfx.toBack();
    }
  }

  @FXML
  private void zorderUp() throws IOException {
    if (currentModelShape != null) {
      currentModelShape.jfx.toFront();
    }
  }

  @FXML
  private void changeFillColor() throws IOException {
    if (currentModelShape != null) {
      currentModelShape.jfx.setFill(cpFill.getValue());

      currentModelShape.updateInformation(
        lblShapeType,
        lblShapeColor,
        lblShapeStat,
        lblShapeCoordinates,
        cpFill,
        cpStroke
      );
    }
  }

  @FXML
  private void changeStrokeColor() throws IOException {
    if (currentModelShape != null) {
      currentModelShape.jfx.setStroke(cpStroke.getValue());

      currentModelShape.updateInformation(
        lblShapeType,
        lblShapeColor,
        lblShapeStat,
        lblShapeCoordinates,
        cpFill,
        cpStroke
      );
    }
  }
}

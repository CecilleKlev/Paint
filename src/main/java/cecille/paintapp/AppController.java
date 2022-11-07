package cecille.paintapp;

import cecille.paintapp.Rectangle;
import java.io.IOException;
import java.lang.Object;
import java.util.LinkedList;
import java.util.List;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

  private boolean userInitiatedCreateShape = false;
  private double startX, startY;
  private Rectangle currentModelShape = null;
  private List<Rectangle> modelShapeList = new LinkedList<Rectangle>();

  @FXML
  public void initialize() {
    cpStroke.setValue(Color.BLACK);
  }

  public void setCurrentShape(Rectangle shape) {
    if (currentModelShape != null) {
      // turn off visual indicator
      currentModelShape.jfx.setStrokeWidth(1d);
    }

    currentModelShape = shape;

    if (currentModelShape != null) {
      // turn on visual indicator
      currentModelShape.jfx.setStrokeWidth(5d);

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
    this.startX = event.getX();
    this.startY = event.getY();
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
      Rectangle modelShape = new Rectangle(
        this.startX,
        this.startY,
        event.getX(),
        event.getY(),
        cpFill.getValue(),
        cpStroke.getValue()
      );
      modelShapeList.add(modelShape);

      // update gui
      modelShape.jfx.setCursor(javafx.scene.Cursor.MOVE);
      modelShape.jfx.setOnMousePressed(this::shapeMousePressed);
      modelShape.jfx.setOnMouseDragged(this::shapeMouseDragged);
      this.sketch.getChildren().add(modelShape.jfx);

      this.setCurrentShape(modelShape);
    }
  }

  // this should go in controller
  private double moveStartX, moveStartY, translateX, translateY;

  private void shapeMousePressed(MouseEvent event) {
    event.consume();

    // set current shape
    final Object eventFromJfxShape = event.getSource();
    for (Rectangle modelShape : modelShapeList) {
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
  private void toggleToLine() throws IOException {}

  @FXML
  private void toggleToArc() throws IOException {}

  @FXML
  private void toggleToPolyLine() throws IOException {}

  @FXML
  private void toggleToRectangle() throws IOException {}

  @FXML
  private void toggleToCircle() throws IOException {}

  @FXML
  private void toggleToEllipse() throws IOException {}

  @FXML
  private void toggleToPolygon() throws IOException {}

  @FXML
  private void toggleToText() throws IOException {}

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

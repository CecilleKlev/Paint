package cecille.paintapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class AppController {

  @FXML
  private BorderPane root;

  private enum UserClickState {
    CLICKED_0,
    CLICKED_1,
  }

  private UserClickState clickState = UserClickState.CLICKED_0;
  private double startX, startY;

  @FXML
  private void appWindowClick(MouseEvent event) throws IOException {
    String stateText = new String();

    switch (clickState) {
      case CLICKED_0:
        stateText = "first";
        clickState = UserClickState.CLICKED_1;
        this.startX = event.getSceneX();
        this.startY = event.getSceneY();
        break;
      case CLICKED_1:
        stateText = "second";
        clickState = UserClickState.CLICKED_0;
        // line
        Line line = new Line(
          this.startX,
          this.startY,
          event.getSceneX(),
          event.getSceneY()
        );
        root.getChildren().add(line);
        break;
    }

    System.out.println(
      stateText +
      " appWindowClick! " +
      event.getSource() +
      " x: " +
      event.getSceneX() +
      " y: " +
      event.getSceneY()
    );
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
  private void toggleToCircle() throws IOException {
    System.out.println("Create circle");
    Circle kreis1;
    kreis1 = new Circle(200, 200, 10, Color.BLACK);
    root.getChildren().add(kreis1);
  }

  @FXML
  private void toggleToEllipse() throws IOException {}

  @FXML
  private void toggleToPolygon() throws IOException {}

  @FXML
  private void toggleToText() throws IOException {}

  @FXML
  private void upButton() throws IOException {}

  @FXML
  private void downButton() throws IOException {}

  @FXML
  private void strokeColor() throws IOException {}

  @FXML
  private void fillColor() throws IOException {}
}

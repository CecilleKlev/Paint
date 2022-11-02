package cecille.paintapp;

import java.io.IOException;
import javafx.fxml.FXML;

public class AppController {

  @FXML
  private void switchToSecondary() throws IOException {
    App.setRoot("secondary");
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

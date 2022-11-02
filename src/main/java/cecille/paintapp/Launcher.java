package cecille.paintapp;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @web http://java-buddy.blogspot.com/
 */
public class Launcher extends Application {

  Circle circle_Red, circle_Green, circle_Blue;
  double orgSceneX, orgSceneY;
  double orgTranslateX, orgTranslateY;

  @Override
  public void start(Stage primaryStage) {
    // line
    Line line = new Line(0, 0, 50f, 100f);
    // line.setStartX(0.0f);
    // line.setStartY(0.0f);
    // line.setEndX(100.0f);
    // line.setEndY(100.0f);

    // rectangle
    Rectangle rect = new Rectangle(20, 40);
    // r.setX(50);
    // r.setY(50);
    // r.setWidth(20);
    // r.setHeight(50);
    // r.setArcWidth(20);
    // r.setArcHeight(20);

    // text
    Text t = new Text(10, 20, "The quick brown fox jumps over the lazy dog");
    // text.setFont(new Font(20));
    // text.setWrappingWidth(200);
    // text.setTextAlignment(TextAlignment.JUSTIFY)
    // text.setText();

    // ellipse
    Ellipse ellipse = new Ellipse(300, 100, 50, 80);
    ellipse.setFill(Color.RED);
    ellipse.setCenterX(150);
    ellipse.setCenterY(150);
    ellipse.setRadiusX(25.0f);
    ellipse.setRadiusY(50.0f);

    //Create Circles
    circle_Red = new Circle(50.0f, Color.RED);
    circle_Red.setCursor(Cursor.HAND);
    circle_Red.setOnMousePressed(circleOnMousePressedEventHandler);
    circle_Red.setOnMouseDragged(circleOnMouseDraggedEventHandler);

    circle_Green = new Circle(50.0f, Color.GREEN);
    circle_Green.setCursor(Cursor.MOVE);
    circle_Green.setCenterX(150);
    circle_Green.setCenterY(150);
    circle_Green.setOnMousePressed(circleOnMousePressedEventHandler);
    circle_Green.setOnMouseDragged(circleOnMouseDraggedEventHandler);

    circle_Blue = new Circle(50.0f, Color.BLUE);
    circle_Blue.setCursor(Cursor.CROSSHAIR);
    circle_Blue.setTranslateX(300);
    circle_Blue.setTranslateY(100);
    circle_Blue.setOnMousePressed(circleOnMousePressedEventHandler);
    circle_Blue.setOnMouseDragged(circleOnMouseDraggedEventHandler);

    Group root = new Group();
    root
      .getChildren()
      .addAll(circle_Red, circle_Green, circle_Blue, line, rect, t, ellipse);

    Scene scene = new Scene(root, 400, 350);
    scene.setOnMousePressed(
      new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
          System.out.println(
            "mouse click detected! " +
            event.getSource() +
            " x: " +
            event.getSceneX() +
            " y: " +
            event.getSceneY()
          );
        }
      }
    );

    primaryStage.setResizable(false);
    primaryStage.setScene(scene);

    primaryStage.setTitle("java-buddy");
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }

  EventHandler<MouseEvent> circleOnMousePressedEventHandler = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent t) {
      orgSceneX = t.getSceneX();
      orgSceneY = t.getSceneY();
      orgTranslateX = ((Circle) (t.getSource())).getTranslateX();
      orgTranslateY = ((Circle) (t.getSource())).getTranslateY();
    }
  };

  EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent t) {
      double offsetX = t.getSceneX() - orgSceneX;
      double offsetY = t.getSceneY() - orgSceneY;
      double newTranslateX = orgTranslateX + offsetX;
      double newTranslateY = orgTranslateY + offsetY;

      ((Circle) (t.getSource())).setTranslateX(newTranslateX);
      ((Circle) (t.getSource())).setTranslateY(newTranslateY);
    }
  };
}

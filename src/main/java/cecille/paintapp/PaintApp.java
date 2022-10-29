package cecille.paintapp;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import cecille.paintapp.Line;

public class PaintApp extends Application {

  public void start(Stage primaryStage) {
    /*Buttons and labels*/
    ToggleGroup group = new ToggleGroup();

    ToggleButton linebtn = new ToggleButton("Line");
    ToggleButton rectbtn = new ToggleButton("Rectangle");
    ToggleButton circlebtn = new ToggleButton("Circle");
    ToggleButton textbtn = new ToggleButton("Text");
    Label txtLabel = new Label("Your text here");
    TextArea txt = new TextArea();

    ToggleButton[] array = { linebtn, rectbtn, circlebtn, textbtn };
    for (ToggleButton button : array) {
      button.setMinWidth(200);
      button.setToggleGroup(group);
      button.setCursor(Cursor.HAND);
    }
    linebtn.setToggleGroup(group);
    rectbtn.setToggleGroup(group);
    circlebtn.setToggleGroup(group);

    /*Colorpicker */
    Label line_color = new Label("Line Color:");
    Label fill_color = new Label("Fill Color:");
    ColorPicker lineCp = new ColorPicker();
    lineCp.setValue(Color.BLACK);
    ColorPicker fillCp = new ColorPicker();
    fillCp.setValue(Color.BLUE);
    //VBOX container(Hvor alle knappene skal være) inni BORDERPANE
    VBox btns = new VBox();
    btns.setSpacing(15);
    btns.setPadding(new Insets(10));
    btns.setPrefWidth(100);
    btns.setStyle("-fx-background-color: #cccccc");

    //Sette inn alt inn i Vbox
    btns
      .getChildren()
      .addAll(
        linebtn,
        rectbtn,
        circlebtn,
        textbtn,
        line_color,
        lineCp,
        fill_color,
        fillCp,
        txtLabel,
        txt
      );

    /*--Stage, scene, canvas, borderpane, gc*/
    primaryStage.setTitle("Paint"); //setter stage tittel
    // Image icon = new Image("cecille/icon.png"); //vindu logo
    // primaryStage.getIcons().add(icon);

    Group root = new Group();
    Canvas canvas = new Canvas(800, 600);
    GraphicsContext gc = canvas.getGraphicsContext2D();

    //drawShapes(gc);

    Line line1 = new Line(200, 200, "#ff0000", 40);
    line1.paint(gc);
    Rectangle rect1 = new Rectangle(40, 40, "#00ff00", 50);
    rect1.paint(gc);
    Circle circle1 = new Circle(300, 300, "#0000ff", 10);
    circle1.paint(gc);

    Text text1 = new Text(70, 100, "#222222", 60, "hello");
    text1.paint(gc);

    VBox toggletest = new VBox();
    Label lbl = new Label();
    /*
    linebtn.setOnAction(
      e -> {
        if (linebtn.isSelected()) {
          lbl.setText("line is selected");
        }
      }
    );

    circlebtn.setOnAction(
      e -> {
        if (circlebtn.isSelected()) {
          lbl.setText("circle is selected");
        }
      }
    );

    rectbtn.setOnAction(
      e -> {
        if (rectbtn.isSelected()) {
          lbl.setText("rectangle is selected");
        }
      }
    );

    textbtn.setOnAction(
      e -> {
        if (textbtn.isSelected()) {
          lbl.setText("text is selected");
        }
      }
    );
    lineCp.setOnAction(
      new EventHandler() {
        public void handle(Event t) {
          Color c = lineCp.getValue();
          lbl.setTextFill(c);
        }
      }
    );

    fillCp.setOnAction(
      new EventHandler() {
        public void handle(Event t) {
          Color c = fillCp.getValue();
          lbl.setTextFill(c);
        }
      }
    );
    */

    toggletest.getChildren().addAll(lbl);
    root.getChildren().add(canvas);

    BorderPane bPane = new BorderPane();
    //bPane.setCenter(root);
    bPane.setTop(toggletest);
    bPane.setRight(btns);
    bPane.setCenter(canvas);
    Scene scene = new Scene(bPane, 1200, 600);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void drawShapes(GraphicsContext gc) {
    gc.setFill(Color.GREEN);
    gc.setStroke(Color.BLUE);
    gc.setLineWidth(5);
    gc.strokeLine(40, 10, 10, 40);
    gc.fillOval(10, 60, 30, 30);
    gc.strokeOval(60, 60, 30, 30);
    gc.fillRoundRect(110, 60, 30, 30, 10, 10);
    gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
    gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
    gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
    gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
    gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
    gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
    gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
    gc.fillPolygon(
      new double[] { 10, 40, 10, 40 },
      new double[] { 210, 210, 240, 240 },
      4
    );
    gc.strokePolygon(
      new double[] { 60, 90, 60, 90 },
      new double[] { 210, 210, 240, 240 },
      4
    );
    gc.strokePolyline(
      new double[] { 110, 140, 110, 140 },
      new double[] { 210, 210, 240, 240 },
      4
    );
  }
}

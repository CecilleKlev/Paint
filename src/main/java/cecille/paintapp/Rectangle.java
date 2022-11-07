package cecille.paintapp;

import cecille.paintapp.AppController;
import javafx.event.EventHandler;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Rectangle {
  /*** rectangle information */
  private final String type;
  private final double area;

  /*** coordinates */
  protected double startX;
  protected double startY;
  protected double endX;
  protected double endY;

  /*** JavaFX controls */
  public final javafx.scene.shape.Shape jfx;

  public Rectangle(double ax, double ay, double bx, double by, Color fill, Color stroke) {
    // coordinates
    if (ax < bx) {
      this.startX = ax;
      this.endX = bx;
    } else {
      this.startX = bx;
      this.endX = ax;
    }

    if (ay < by) {
      this.startY = ay;
      this.endY = by;
    } else {
      this.startY = by;
      this.endY = ay;
    }

    // rectangle stats
    double width, height;
    width = endX - startX;
    height = endY - startY;
    this.type = "Rectangle";
    this.area = width * height;

    // jfx shape object
    this.jfx = new javafx.scene.shape.Rectangle(this.startX, this.startY, width, height);

    this.jfx.setFill(fill);
    this.jfx.setStroke(stroke);
  }

  public void updateInformation(
    Label lblType,
    Label lblColor,
    Label lblStat,
    Label lblCoordinates,
    ColorPicker cpFill,
    ColorPicker cpStroke
  ) {
    // access jfx controls via bound controller fields
    final String colorFill = this.jfx.getFill().toString();
    final String colorStroke = this.jfx.getStroke().toString();

    cpFill.setValue(Color.web(colorFill));
    cpStroke.setValue(Color.web(colorStroke));

    lblType.setText("Shape: " + this.type);
    lblColor.setText("Stroke: " + colorStroke + " Fill: " + colorFill);
    lblStat.setText("Area: " + this.area);
    lblCoordinates.setText(
      "Coords: (" +
      this.startX +
      ", " +
      this.startY +
      ")-(" +
      this.endX +
      ", " +
      this.endY +
      ")"
    );
  }
}

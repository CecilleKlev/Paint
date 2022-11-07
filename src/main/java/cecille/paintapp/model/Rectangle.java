package cecille.paintapp.model;

import java.lang.Math;
import javafx.scene.paint.Color;

public class Rectangle extends Shape {

  public Rectangle(double ax, double ay, double bx, double by, Color fill, Color stroke) {
    super("Rectangle", ax, ay, bx, by, fill, stroke);
  }

  protected String getMetric(double startX, double startY, double endX, double endY) {
    final double width = Math.abs(endX - startX);
    final double height = Math.abs(endY - startY);
    return "Area: " + (width * height);
  }

  protected javafx.scene.shape.Shape createJfxShape(
    double startX,
    double startY,
    double endX,
    double endY
  ) {
    final double width = Math.abs(endX - startX);
    final double height = Math.abs(endY - startY);
    return new javafx.scene.shape.Rectangle(startX, startY, width, height);
  }
}

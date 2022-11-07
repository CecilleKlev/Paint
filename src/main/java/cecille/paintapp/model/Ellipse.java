package cecille.paintapp.model;

import java.lang.Math;
import javafx.scene.paint.Color;

public class Ellipse extends Shape {

  public Ellipse(double ax, double ay, double bx, double by, Color fill, Color stroke) {
    super("Ellipse", ax, ay, bx, by, fill, stroke);
  }

  protected String getMetric(double startX, double startY, double endX, double endY) {
    final double radiusX = Math.abs(endX - startX) / 2;
    final double radiusY = Math.abs(endY - startY) / 2;
    return "Area: " + (radiusX * radiusY * Math.PI);
  }

  protected javafx.scene.shape.Shape createJfxShape(
    double startX,
    double startY,
    double endX,
    double endY
  ) {
    final double radiusX = Math.abs(endX - startX) / 2;
    final double radiusY = Math.abs(endY - startY) / 2;
    final double centerX = Math.min(startX, endX) + radiusX;
    final double centerY = Math.min(startY, endY) + radiusY;
    return new javafx.scene.shape.Ellipse(centerX, centerY, radiusX, radiusY);
  }
}

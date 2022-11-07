package cecille.paintapp.model;

import java.lang.Math;
import javafx.scene.paint.Color;

public class Circle extends Shape {

  public Circle(double ax, double ay, double bx, double by, Color fill, Color stroke) {
    super("Circle", ax, ay, bx, by, fill, stroke);
  }

  protected String getMetric(double startX, double startY, double endX, double endY) {
    final double width = Math.abs(endX - startX);
    final double height = Math.abs(endY - startY);
    final double diameter = Math.max(width, height);
    final double centerX = startX + width / 2;
    final double centerY = startY + height / 2;
    final double radius = diameter / 2;
    return "Area: " + (radius * radius * Math.PI);
  }

  protected javafx.scene.shape.Shape createJfxShape(
    double startX,
    double startY,
    double endX,
    double endY
  ) {
    final double width = Math.abs(endX - startX);
    final double height = Math.abs(endY - startY);
    final double diameter = Math.max(width, height);
    final double centerX = Math.min(startX, endX) + width / 2;
    final double centerY = Math.min(startY, endY) + height / 2;
    final double radius = diameter / 2;
    return new javafx.scene.shape.Circle(centerX, centerY, radius);
  }
}

package cecille.paintapp.model;

import javafx.scene.paint.Color;

public class Line extends Shape {

  public Line(double ax, double ay, double bx, double by, Color fill, Color stroke) {
    super("Line", ax, ay, bx, by, fill, stroke);
  }

  protected String getMetric(double startX, double startY, double endX, double endY) {
    final double hypotenuse = Math.sqrt(
      (endY - startY) * (endY - startY) + (endX - startX) * (endX - startX)
    );
    return "Length: " + hypotenuse;
  }

  protected javafx.scene.shape.Shape createJfxShape(
    double startX,
    double startY,
    double endX,
    double endY
  ) {
    return new javafx.scene.shape.Line(startX, startY, endX, endY);
  }
}

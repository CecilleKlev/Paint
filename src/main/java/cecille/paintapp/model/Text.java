package cecille.paintapp.model;

import javafx.scene.paint.Color;

public class Text extends Shape {

  public Text(double ax, double ay, double bx, double by, Color fill, Color stroke) {
    super("Text", ax, ay, bx, by, fill, stroke);
  }

  protected String getMetric(double startX, double startY, double endX, double endY) {
    return "";
  }

  protected javafx.scene.shape.Shape createJfxShape(
    double startX,
    double startY,
    double endX,
    double endY
  ) {
    return new javafx.scene.text.Text(
      startX,
      startY,
      "The quick brown fox jumps over the lazy dog"
    );
  }
}

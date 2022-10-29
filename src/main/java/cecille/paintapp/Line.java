package cecille.paintapp;

import javafx.scene.canvas.GraphicsContext;

public class Line extends Shape {

  private double end_x, end_y;

  public Line(double x, double y, String color, double size) {
    super(x, y, color, size);
  }

  public void paint(GraphicsContext gc)  {
    super.paint(gc);
      gc.strokeLine(this.x, this.y, this.end_x, this.end_y);
  }
}

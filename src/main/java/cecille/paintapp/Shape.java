package cecille.paintapp;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Shape {
  protected String color;
  protected double x;
  protected double y;
  protected double size;
  protected double end_x;
  protected double end_y;

  public Shape(double x, double y, String color, double size) {
    this.x = x;
    this.y = y;
    this.color = color;
    this.size = size;
    this.end_x = this.x + this.size;
    this.end_y = this.y + this.size;
  }

  protected void paint(GraphicsContext gc) {
    Color c = Color.web(this.color);
    gc.setStroke(c);
  }
}

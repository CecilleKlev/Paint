package cecille.paintapp;

import javafx.scene.canvas.GraphicsContext;

public class Rectangle extends Shape {

  public Rectangle(double x, double y, String color, double size) {
    super(x, y, color, size);
  }

  public void paint(GraphicsContext gc) {
    super.paint(gc);
    gc.strokeRect(this.x, this.y, this.end_x, this.end_y);
  }
}

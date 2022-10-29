package cecille.paintapp;

import javafx.scene.canvas.GraphicsContext;

public class Text extends Shape{

  private String text;

  public Text( double x, double y, String color, double size, String text) {
    super(x, y, color, size);
    this.text = text;
  }

  public void paint(GraphicsContext gc)  {
      super.paint(gc);
      gc.strokeText(text, this.x, this.y);
  }
}

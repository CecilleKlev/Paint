package cecille.paintapp;

import javafx.scene.canvas.GraphicsContext;

public class Circle extends Shape
  {
    private double radius;

    public Circle(double x, double y, String
                    color,double size){
       super(x, y, color, size);
    }


     public void paint(GraphicsContext gc)  {
       super.paint(gc);
      gc.strokeOval(this.x, this.y, this.end_x, this.end_y);
  }
  }

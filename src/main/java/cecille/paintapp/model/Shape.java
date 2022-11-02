package cecille.paintapp.model;

public abstract class Shape {

  private double startX;
  private double startY;
  private double endX;
  private double endY;

  public Shape(double startX, double startY, double endX, double endY) {
    this.startX = startX;
    this.startY = startY;
    this.endX = endX;
    this.endY = endY;
  }

  public abstract void paint();
}

package cecille.paintapp.model;

import java.lang.String;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public abstract class Shape {
  /*** shape information */
  private final String type;
  private final String metric;

  /*** coordinates */
  private final double startX;
  private final double startY;
  private final double endX;
  private final double endY;

  /*** JavaFX shape */
  public final javafx.scene.shape.Shape jfx;

  public Shape(
    String type,
    double ax,
    double ay,
    double bx,
    double by,
    Color fill,
    Color stroke
  ) {
    this.type = "Shape: " + type;

    // coordinates
    this.startX = ax;
    this.startY = ay;
    this.endX = bx;
    this.endY = by;

    this.metric = getMetric(startX, startY, endX, endY);

    // jfx shape object
    this.jfx = createJfxShape(startX, startY, endX, endY);
    this.jfx.setFill(fill);
    this.jfx.setStroke(stroke);
  }

  protected abstract String getMetric(
    double startX,
    double startY,
    double endX,
    double endY
  );

  protected abstract javafx.scene.shape.Shape createJfxShape(
    double startX,
    double startY,
    double endX,
    double endY
  );

  public void updateInformation(
    Label lblType,
    Label lblColor,
    Label lblStat,
    Label lblCoordinates,
    ColorPicker cpFill,
    ColorPicker cpStroke
  ) {
    // access jfx controls via bound controller fields
    final String colorFill = this.jfx.getFill().toString();
    final String colorStroke = this.jfx.getStroke().toString();

    cpFill.setValue(Color.web(colorFill));
    cpStroke.setValue(Color.web(colorStroke));

    lblType.setText(this.type);
    lblColor.setText("Stroke: " + colorStroke + " Fill: " + colorFill);
    lblStat.setText(this.metric);
    lblCoordinates.setText(
      "Coords: (" +
      this.startX +
      ", " +
      this.startY +
      ")-(" +
      this.endX +
      ", " +
      this.endY +
      ")"
    );
  }
}

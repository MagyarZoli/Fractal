package org.example.model;

import java.util.Objects;

public class Coordinate implements Tolerance {

  private final double x;
  private final double y;

  public Coordinate(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coordinate that = (Coordinate) o;
    return equalsWithTolerance(this.x, that.x, 1e-10) &&
        equalsWithTolerance(this.y, that.y, 1e-10);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public static Coordinate parseCoordinate(ComplexNumber c) {
    return new Coordinate(c.getReal(), c.getImaginary());
  }

  public static Coordinate parseCoordinate(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY) {
    double x = PanelCoordinate.coordinatePoint(panelCoordinate.getX(), width, unitX, false);
    double y = PanelCoordinate.coordinatePoint(panelCoordinate.getY(), height, unitY, true);
    return new Coordinate(x, y);
  }
}

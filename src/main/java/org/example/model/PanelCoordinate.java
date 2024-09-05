package org.example.model;

import java.util.Objects;

public class PanelCoordinate implements Tolerance {

  private final int x;
  private final int y;

  public PanelCoordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  @Override
  public String toString() {
    return "[" + x + ", " + y + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PanelCoordinate that = (PanelCoordinate) o;
    return equalsWithTolerance(this.x, that.x, 1e-10) &&
        equalsWithTolerance(this.y, that.y, 1e-10);
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  public static PanelCoordinate parsePanelCoordinate(Coordinate coordinate, int width, int height, double unitX, double unitY) {
    double x = panelPoint(coordinate.getX(), width, unitX, false);
    double y = panelPoint(coordinate.getY(), height, unitY, true);
    return new PanelCoordinate((int)x, (int)y);
  }

  public static PanelCoordinate parsePanelCoordinate(ComplexNumber c, int width, int height, double unitX, double unitY) {
    return parsePanelCoordinate(Coordinate.parseCoordinate(c), width, height, unitX, unitY);
  }

  private static double panelPoint(double num, int size, double unit, boolean isAxisY) {
    return (size / 2.0) + num * (size / unit) * (isAxisY ? -1 : 1);
  }

  protected static double coordinatePoint(double num, int size, double unit, boolean isAxisY) {
    return (num - (size / 2.0)) * (unit / size) * (isAxisY ? -1 : 1);
  }
}

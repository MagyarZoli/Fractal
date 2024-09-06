package org.example.model;

import java.util.Objects;

/**
 * Kétdimenziós pontot reprezentál egy derékszögű koordináta-rendszerben.
 * A pont két valós számot tartalmaz: az <em>x</em> és <em>y</em> koordinátákat.
 */
public class Coordinate implements Tolerance {

  /**
   * A pont x> koordinátája.
   */
  private double x;

  /**
   * A pont y koordinátája.
   */
  private double y;

  /**
   * Létrehoz egy új példányt a megadott x és y koordinátákkal.
   * @param x A pont x koordinátája.
   * @param y A pont y koordinátája.
   */
  public Coordinate(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Visszaadja a pont x koordinátáját.
   * @return A pont x koordinátája.
   */
  public double getX() {
    return x;
  }

  /**
   * Visszaadja a pont y koordinátáját.
   * @return A pont y koordinátája.
   */
  public double getY() {
    return y;
  }

  /**
   * Visszaadja a koordináták reprezentációját
   * @return A koordináták reprezentációja.
   */
  @Override
  public String toString() {
    return "(" + x + ", " + y + ")";
  }

  /**
   * Összehasonlít két Coordinate objektumot, hogy egyenlőek-e.
   * @param o Az összehasonlítandó objektum.
   * @return true, ha az objektumok egyenlőek, különben false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Coordinate that = (Coordinate) o;
    return equalsWithTolerance(this.x, that.x, 1e-10) &&
        equalsWithTolerance(this.y, that.y, 1e-10);
  }

  /**
   * Visszaadja az objektum hash kódját.
   * @return A pont hash kódja, amelyet az x és y koordináták alapján számítanak ki.
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  /**
   * A komplex szám valós és képzetes része közvetlenül a derékszögű koordináta rendszer x és y értékévé válik.
   * @param c Átalakítandó objektum.
   * @return Egy új Coordinate objektum, amely a komplex szám valós és képzetes részét x és y koordinátaként tartalmazza.
   */
  public static Coordinate parseCoordinate(ComplexNumber c) {
    return new Coordinate(c.getReal(), c.getImaginary());
  }

  /**
   * Egy panel koordinátákat alakít át derékszögű koordináta rendszer x és y értékévé,
   * figyelembe véve a panel méretét és az egyes tengelyek mentén alkalmazott méretarányokat.
   * @param panelCoordinate Átalakítandó objektum.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @param unitX Az x tengely méretarányának mértékegysége.
   * @param unitY Az y tengely méretarányának mértékegysége.
   * @return Egy új Coordinate objektum, amely a panel koordinátákból számított valós koordinátákat tartalmazza.
   */
  public static Coordinate parseCoordinate(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY) {
    double x = PanelCoordinate.coordinatePoint(panelCoordinate.getX(), width, unitX, false);
    double y = PanelCoordinate.coordinatePoint(panelCoordinate.getY(), height, unitY, true);
    return new Coordinate(x, y);
  }
}

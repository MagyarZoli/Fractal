package org.example.model;

import java.util.Objects;

/**
 * Az osztály képes átalakítani általános koordinátákat panel koordinátákká,
 * figyelembe véve a panel méretét és a méretarányt.
 */
public class PanelCoordinate implements Tolerance {

  /**
   * A panel x koordinátája (oszlop).
   */
  private final int x;

  /**
   * A panel y koordinátája (sor).
   */
  private final int y;

  /**
   * Létrehoz egy új példányt a megadott x és y koordinátákkal.
   * @param x A panel x koordinátája.
   * @param y A panel y koordinátája.
   */
  public PanelCoordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Visszaadja a panel x koordinátáját.
   * @return A panel x koordinátája.
   */
  public int getX() {
    return x;
  }

  /**
   * Visszaadja a panel y koordinátáját.
   * @return A panel y koordinátája.
   */
  public int getY() {
    return y;
  }

  /**
   * Visszaadja a panel koordinátájának reprezentációját.
   * @return A panel koordináta reprezentációja.
   */
  @Override
  public String toString() {
    return "[" + x + ", " + y + "]";
  }

  /**
   * Összehasonlít két PanelCoordinate objektumot, hogy egyenlőek-e.
   * @param o Az összehasonlítandó objektum.
   * @return true, ha az objektumok egyenlőek, különben false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PanelCoordinate that = (PanelCoordinate) o;
    return equalsWithTolerance(this.x, that.x, 1e-10) &&
        equalsWithTolerance(this.y, that.y, 1e-10);
  }

  /**
   * Visszaadja az objektum hash kódját.
   * @return A panel koordináta hash kódja, amelyet az x és y koordináták alapján számítanak ki.
   */
  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  /**
   * Átalakít egy általános koordinátát panel koordinátává,
   * figyelembe véve a panel méretét és az egyes tengelyek mentén alkalmazott mértékegységet.
   * @param coordinate Átalakítandó objektum.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @param unitX Az x tengely méretarányának mértékegysége.
   * @param unitY Az y tengely méretarányának mértékegysége.
   * @return Egy új PanelCoordinate objektum, amely az átalakított koordinátát tartalmazza.
   */
  public static PanelCoordinate parsePanelCoordinate(Coordinate coordinate, int width, int height, double unitX, double unitY) {
    double x = panelPoint(coordinate.getX(), width, unitX, false);
    double y = panelPoint(coordinate.getY(), height, unitY, true);
    return new PanelCoordinate((int)x, (int)y);
  }

  /**
   * Átalakít egy komplex számot panel koordinátává,
   * figyelembe véve a panel méretét és az egyes tengelyek mentén alkalmazott mértékegységet.
   * @param c Átalakítandó objektum.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @param unitX Az x tengely méretarányának mértékegysége.
   * @param unitY Az y tengely méretarányának mértékegysége.
   * @return Egy új PanelCoordinate objektum, amely az átalakított koordinátát tartalmazza.
   */
  public static PanelCoordinate parsePanelCoordinate(ComplexNumber c, int width, int height, double unitX, double unitY) {
    return parsePanelCoordinate(Coordinate.parseCoordinate(c), width, height, unitX, unitY);
  }

  /**
   * Kiszámítja egy adott koordináta pont panelen belüli pozícióját.
   * @param num Átalakítandó szám.
   * @param size A panel adott dimenziója.
   * @param unit A tengely menti mértékegység.
   * @param isAxisY Igaz, ha az Y tengelyen végzünk számítást, hamis, ha az X tengelyen.
   * @return Az adott koordináta panelen belüli pozíciója.
   */
  private static double panelPoint(double num, int size, double unit, boolean isAxisY) {
    return (size / 2.0) + num * (size / unit) * (isAxisY ? -1 : 1);
  }

  /**
   * Kíszámítja egy adott panelen lévő pontott általános koordinátává.
   * @param num Átalakítandó szám.
   * @param size A panel adott dimenziója.
   * @param unit A tengely menti mértékegység.
   * @param isAxisY Igaz, ha az Y tengelyen végzünk számítást, hamis, ha az X tengelyen.
   * @return Az adott panel koordináta általános valós számokkal ábrázolt koordinátaként.
   */
  protected static double coordinatePoint(double num, int size, double unit, boolean isAxisY) {
    return (num - (size / 2.0)) * (unit / size) * (isAxisY ? -1 : 1);
  }
}

package org.example.model;

import java.util.Objects;

/**
 * Komplex számot reprezentál, amelynek valós és képzetes része van.
 * A komplex szám formája: <em>a + ib</em>, ahol <em>a</em> a valós rész és a <em>b</em> a képzetes rész.
 */
public class ComplexNumber implements Tolerance {

  /**
   * A komplex szám valós része.
   */
  private final double real;

  /**
   * A komplex szám képzetes része.
   */
  private final double imaginary;

  /**
   * Létrehoz egy új példányt a megadott valós és képzetes résszel.
   * @param real A komplex szám valós része.
   * @param imaginary  A komplex szám képzetes része.
   */
  public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  /**
   * Visszaadja a komplex szám valós részét.
   * @return A komplex szám valós része.
   */
  public double getReal() {
    return real;
  }

  /**
   * Visszaadja a komplex szám képzetes részét.
   * @return A komplex szám képzetes része.
   */
  public double getImaginary() {
    return imaginary;
  }

  /**
   * Összeadja az aktuális komplex számot egy másik komplex számmal.<br>
   * <em>(a + ib) + (c + id) = (a + c) + i(b + d)</em><br>
   * <em>(a + ib) = this;</em><br>
   * <em>(c + id) = other;</em><br>
   * @param other A másik komplex szám, amelyet hozzáadunk az aktuálishoz.
   * @return új példány, amely az összeadás eredményét tartalmazza.
   */
  public ComplexNumber add(ComplexNumber other) {
    double newReal = this.real + other.real;
    double newImaginary= this.imaginary + other.imaginary;
    return new ComplexNumber(newReal, newImaginary);
  }

  /**
   * Kivon egy másik komplex számot az aktuálisból.<br>
   * <em>(a + ib) – (c + id) = (a – c) + i(b – d)</em><br>
   * <em>(a + ib) = this;</em><br>
   * <em>(c + id) = other;</em><br>
   * @param other A kivonandó komplex szám.
   * @return Egy új példány, amely a kivonás eredményét tartalmazza.
   */
  public ComplexNumber subtract(ComplexNumber other) {
    double newReal = this.real - other.real;
    double newImaginary= this.imaginary - other.imaginary;
    return new ComplexNumber(newReal, newImaginary);
  }

  /**
   * Megszorozza az aktuális komplex számot egy másik komplex számmal.<br>
   * <em>(a + ib). (c + id) = (ac – bd) + i(ad + bc)</em><br>
   * <em>(a + ib) = this;</em><br>
   * <em>(c + id) = other;</em><br>
   * @param other A másik komplex szám, amellyel szorzunk.
   * @return Egy új példány, amely a szorzás eredményét tartalmazza.
   */
  public ComplexNumber multiply(ComplexNumber other) {
    double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
    double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
    return new ComplexNumber(newReal, newImaginary);
  }

  /**
   * Elosztja az aktuális komplex számot egy másik komplex számmal.<br>
   * <em>(a + ib) / (c + id) = (ac + bd)/ (c2 + d2) + i(bc – ad) / (c2 + d2)</em>
   * <em>(a + ib) = this;</em><br>
   * <em>(c + id) = other;</em><br>
   * @param other A másik komplex szám, amellyel osztunk.
   * @return Egy új példány, amely az osztás eredményét tartalmazza.
   */
  public ComplexNumber divide(ComplexNumber other) {
    double divide = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);
    divide = divide == 0 ? 1 : divide;
    double newReal = ((this.real * other.real) + (this.imaginary * other.imaginary)) / divide;
    double newImaginary = ((this.imaginary * other.real) - (this.real * other.imaginary)) / divide;
    return new ComplexNumber(newReal, newImaginary);
  }

  /**
   * Visszaadja a komplex szám reprezentációját.
   * @return A komplex szám reprezentációja.
   */
  @Override
  public String toString() {
    return real + " + " + imaginary + "i";
  }

  /**
   * Visszaadja a komplex szám formázott reprezentációját, négy tizedesjegy pontossággal.
   * @return A komplex szám formázott reprezentációja.
   */
  public String toStringFormat() {
    return String.format("%.4f + %.4fi", real, imaginary);
  }

  /**
   * Összehasonlít két ComplexNumber objektumot, hogy egyenlőek-e.
   * @param o Az összehasonlítandó objektum.
   * @return true, ha az objektumok egyenlőek, különben false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ComplexNumber that = (ComplexNumber) o;
    return equalsWithTolerance(this.real, that.real, 1e-10) &&
        equalsWithTolerance(this.imaginary, that.imaginary, 1e-10);
  }

  /**
   * Visszaadja az objektum hash kódját.
   * @return A komplex szám hash kódja.
   */
  @Override
  public int hashCode() {
    return Objects.hash(real, imaginary);
  }

  /**
   * A koordináta x és y értékei közvetlenül a komplex szám valós és képzetes részévé válnak.
   * @param coordinate Átalakítandó objektum.
   * @return Egy új ComplexNumber objektum, amely a koordináta x és y értékét a komplex szám valós és képzetes részeként tartalmazza.
   */
  public static ComplexNumber parseComplexNumber(Coordinate coordinate) {
    return new ComplexNumber(coordinate.getX(), coordinate.getY());
  }

  /**
   * Egy panel koordinátákat alakít át komplex számmá,
   * figyelembe véve a panel méretét és az egyes tengelyek mentén alkalmazott méretarányokat.
   * @param panelCoordinate Átalakítandó objektum.
   * @param width A panel szélessége.
   * @param height A panel magassága.
   * @param unitX Az x tengely méretarányának mértékegysége.
   * @param unitY Az y tengely méretarányának mértékegysége.
   * @return Egy új ComplexNumber objektum, amely a panel koordinátákból számított valós és képzetes részeket tartalmazza.
   */
  public static ComplexNumber parseComplexNumber(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY) {
    double real = PanelCoordinate.coordinatePoint(panelCoordinate.getX(), width, unitX, false);
    double imaginary = PanelCoordinate.coordinatePoint(panelCoordinate.getY(), height, unitY, true);
    return new ComplexNumber(real, imaginary);
  }
}

package org.example.model;

import java.util.Objects;

public class ComplexNumber {

  private final double real;
  private final double imaginary;

  public ComplexNumber(double real, double imaginary) {
    this.real = real;
    this.imaginary = imaginary;
  }

  public double getReal() {
    return real;
  }

  public double getImaginary() {
    return imaginary;
  }

  /**
   * (a + ib) + (c + id) = (a + c) + i(b + d)
   * (a + ib) = this;
   * (c + id) = other;
   * a = this.real;
   * b = this.imaginary;
   * c = other.real;
   * d = other.imaginary;
   * @param other
   * @return
   */
  public ComplexNumber add(ComplexNumber other) {
    double newReal = this.real + other.real;
    double newImaginary= this.imaginary + other.imaginary;
    return new ComplexNumber(newReal, newImaginary);
  }

  /**
   * (a + ib). (c + id) = (ac – bd) + i(ad + bc)
   * (a + ib) = this;
   * (c + id) = other;
   * a = this.real;
   * b = this.imaginary;
   * c = other.real;
   * d = other.imaginary;
   * @param other
   * @return
   */
  public ComplexNumber multiply(ComplexNumber other) {
    double newReal = (this.real * other.real) - (this.imaginary * other.imaginary);
    double newImaginary = (this.real * other.imaginary) + (this.imaginary * other.real);
    return new ComplexNumber(newReal, newImaginary);
  }

  @Override
  public String toString() {
    return real + " + " + imaginary + "i";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ComplexNumber that = (ComplexNumber) o;
    return Double.compare(that.real, real) == 0 && Double.compare(that.imaginary, imaginary) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(real, imaginary);
  }

  public static ComplexNumber parseComplexNumber(Coordinate coordinate) {
    return new ComplexNumber(coordinate.getX(), coordinate.getY());
  }

  public static ComplexNumber parseComplexNumber(PanelCoordinate panelCoordinate, int width, int height, double unitX, double unitY) {
    double real = PanelCoordinate.coordinatePoint(panelCoordinate.getX(), width, unitX, false);
    double imaginary = PanelCoordinate.coordinatePoint(panelCoordinate.getY(), height, unitY, true);
    return new ComplexNumber(real, imaginary);
  }
}

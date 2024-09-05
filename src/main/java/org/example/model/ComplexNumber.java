package org.example.model;

import java.util.Objects;

public class ComplexNumber implements Tolerance {

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
   * (a + ib) – (c + id) = (a – c) + i(b – d)
   * (a + ib) = this;
   * (c + id) = other;
   * a = this.real;
   * b = this.imaginary;
   * c = other.real;
   * d = other.imaginary;
   * @param other
   * @return
   */
  public ComplexNumber subtract(ComplexNumber other) {
    double newReal = this.real - other.real;
    double newImaginary= this.imaginary - other.imaginary;
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

  /**
   * (a + ib) / (c + id) = (ac + bd)/ (c2 + d2) + i(bc – ad) / (c2 + d2)
   * (a + ib) = this;
   * (c + id) = other;
   * a = this.real;
   * b = this.imaginary;
   * c = other.real;
   * d = other.imaginary;
   * @param other
   * @return
   */
  public ComplexNumber divide(ComplexNumber other) {
    double divide = Math.pow(other.real, 2) + Math.pow(other.imaginary, 2);
    divide = divide == 0 ? 1 : divide;
    double newReal = ((this.real * other.real) + (this.imaginary * other.imaginary)) / divide;
    double newImaginary = ((this.imaginary * other.real) - (this.real * other.imaginary)) / divide;
    return new ComplexNumber(newReal, newImaginary);
  }

  @Override
  public String toString() {
    return real + " + " + imaginary + "i";
  }

  public String toStringFormat() {
    return String.format("%.4f + %.4fi", real, imaginary);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ComplexNumber that = (ComplexNumber) o;
    return equalsWithTolerance(this.real, that.real, 1e-10) &&
        equalsWithTolerance(this.imaginary, that.imaginary, 1e-10);
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

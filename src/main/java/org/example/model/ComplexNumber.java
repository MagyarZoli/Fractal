package org.example.model;

public class ComplexNumber {

  private double real;
  private double imaginary;

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
}
